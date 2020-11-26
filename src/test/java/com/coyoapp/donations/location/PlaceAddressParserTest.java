package com.coyoapp.donations.location;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PlaceAddressParserTest {

    @InjectMocks
    private PlaceAddressParser placeAddressParser;

    @Test
    void shouldParseAddress() {
        // given
        String formattedAddress = "Pflugacker 7, 22523 Hamburg, Deutschland";

        // when
        PlaceAddress actualAddress = placeAddressParser.parseAddress(formattedAddress);

        // then
        assertThat(actualAddress.getAddress()).isEqualTo("Pflugacker 7");
        assertThat(actualAddress.getZip()).isEqualTo("22523");
        assertThat(actualAddress.getCity()).isEqualTo("Hamburg");
        assertThat(actualAddress.getCountry()).isEqualTo("Deutschland");
    }
}
