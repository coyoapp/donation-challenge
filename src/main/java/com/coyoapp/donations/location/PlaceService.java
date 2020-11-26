package com.coyoapp.donations.location;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

/**
 * A place is a location that has been donated towards. This service manages the places.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final PlaceAddressParser placeAddressParser;
    private final MapperFacade mapperFacade;

    public Optional<Place> getByGooglePlaceId(String placeId) {
        return placeRepository.findByPlaceId(placeId);
    }

    public Place createPlace(PlaceRequest placeRequest) {
        PlaceAddress address = placeAddressParser.parseAddress(placeRequest.getFormattedAddress());
        Place place = mapperFacade.map(address, Place.class);
        place.setCompany(placeRequest.getName());
        place.setPlaceId(placeRequest.getPlaceId());
        return placeRepository.save(place);
    }
}
