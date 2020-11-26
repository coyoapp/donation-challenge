package com.coyoapp.donations.entrepreneur;

import lombok.Data;

@Data
public class EntrepreneurResponse {

    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String placeId;

    private String company;

    private String address;

    private String zip;

    private String city;

    private String country;
}
