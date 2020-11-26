package com.coyoapp.donations.location;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaceRepository extends MongoRepository<Place, String> {

    Optional<Place> findByPlaceId(String placeId);
}
