package com.coyoapp.donations.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PlaceRequest {

    @JsonProperty("formatted_address")
    private String formattedAddress;

    private String name;

    @JsonProperty("place_id")
    private String placeId;
}
