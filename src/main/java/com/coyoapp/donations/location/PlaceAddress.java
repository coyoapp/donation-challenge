package com.coyoapp.donations.location;

import lombok.Data;

@Data
public class PlaceAddress {

    private String address;

    private String zip;

    private String city;

    private String country;
}
