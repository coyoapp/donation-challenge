package com.coyoapp.donations.entrepreneur;

import com.coyoapp.donations.invitation.InvitationToken;
import com.coyoapp.donations.invitation.InvitationTokenService;
import com.coyoapp.donations.location.PlaceService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

/**
 * An entrepreneur is an owner of a location. Use this service to update their information or find one.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class EntrepreneurService {

    private final InvitationTokenService invitationTokenService;
    private final EntrepreneurRepository entrepreneurRepository;
    private final PlaceService placeService;
    private final MapperFacade mapperFacade;

    public Optional<EntrepreneurResponse> getByInvitationToken(String invitationToken) {
        return invitationTokenService.getByToken(invitationToken)
                .map(InvitationToken::getGooglePlaceId)
                .map(this::getByGooglePlaceId)
                .map(this::transform);
    }

    private Entrepreneur getByGooglePlaceId(String placeId) {
        return entrepreneurRepository.findByGooglePlaceId(placeId).orElseGet(() -> {
            Entrepreneur entrepreneur = new Entrepreneur();
            entrepreneur.setGooglePlaceId(placeId);
            return entrepreneur;
        });
    }

    private EntrepreneurResponse transform(Entrepreneur entrepreneur) {
        EntrepreneurResponse entrepreneurResponse = mapperFacade.map(entrepreneur, EntrepreneurResponse.class);
        placeService.getByGooglePlaceId(entrepreneur.getGooglePlaceId()).ifPresent(place -> {
            mapperFacade.map(place, entrepreneurResponse);
            entrepreneurResponse.setPlaceId(entrepreneur.getGooglePlaceId());
        });
        return entrepreneurResponse;
    }

    public Entrepreneur createEntrepreneur(EntrepreneurCreateRequest request) {
        InvitationToken invitationToken = getAndValidateInvitationTokenAndGooglePlaceId(request);
        Entrepreneur entrepreneur = mapperFacade.map(request, Entrepreneur.class);
        entrepreneur.setGooglePlaceId(invitationToken.getGooglePlaceId());
        return entrepreneurRepository.save(entrepreneur);
    }

    private InvitationToken getAndValidateInvitationTokenAndGooglePlaceId(EntrepreneurCreateRequest request) {
        InvitationToken token = invitationTokenService.getByToken(request.getInvitationToken()).orElseThrow(
                () -> new IllegalArgumentException("The invitation token is invalid"));

        entrepreneurRepository.findByGooglePlaceId(token.getGooglePlaceId()).ifPresent(invitationToken -> {
            throw new IllegalArgumentException("An entrepreneur is already registered for this google place id");
        });
        return token;
    }

}
