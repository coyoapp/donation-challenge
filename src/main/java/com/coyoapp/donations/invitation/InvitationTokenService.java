package com.coyoapp.donations.invitation;

import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Invitation tokens are lightweight tokens that are send to owners. The owner can use the token to check his balance or
 * set his contact information.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class InvitationTokenService {

    private final InvitationTokenRepository tokenRepository;

    public Optional<InvitationToken> getByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    public Optional<InvitationToken> getByGooglePlaceId(String googlePlaceId) {
        return tokenRepository.findByGooglePlaceId(googlePlaceId);
    }

    public InvitationToken createToken(String googlePlaceId) {
        InvitationToken token = new InvitationToken();
        token.setGooglePlaceId(googlePlaceId);
        token.setToken(UUID.randomUUID().toString());
        return tokenRepository.save(token);
    }
}
