package com.coyoapp.donations.entrepreneur;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntrepreneurRepository extends MongoRepository<Entrepreneur, String> {

    Optional<Entrepreneur> findByGooglePlaceId(String placeId);
}
