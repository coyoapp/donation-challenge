package com.coyoapp.donations.invitation;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvitationTokenRepository extends MongoRepository<InvitationToken, String> {

    Optional<InvitationToken> findByGooglePlaceId(String placeId);

    Optional<InvitationToken> findByToken(String token);
}
