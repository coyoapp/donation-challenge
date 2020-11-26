package com.coyoapp.donations.location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PlaceAddressParser {

    private static final Pattern ADDRESS_PATTERN = Pattern.compile("([^,]+),\\s?([0-9]+)([^,]+),\\s?([^,]+)");

    public PlaceAddress parseAddress(String formattedAddress) {
        Matcher matcher = ADDRESS_PATTERN.matcher(formattedAddress);
        PlaceAddress placeAddress = new PlaceAddress();
        if (matcher.find()) {
            placeAddress.setAddress(matcher.group(1).trim());
            placeAddress.setZip(matcher.group(2).trim());
            placeAddress.setCity(matcher.group(3).trim());
            placeAddress.setCountry(matcher.group(4).trim());
        }
        return placeAddress;
    }
}
