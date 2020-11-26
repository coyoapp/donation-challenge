package com.coyoapp.donations.location;

import java.time.Instant;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@ToString
public class Place {

    @Id
    private String id;

    private String placeId;

    private String company;

    private String address;

    private String zip;

    private String city;

    private String country;

    private Instant created;
}
