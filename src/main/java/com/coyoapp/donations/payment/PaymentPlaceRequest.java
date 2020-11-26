package com.coyoapp.donations.payment;

import com.coyoapp.donations.location.PlaceRequest;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PaymentPlaceRequest {

    private PlaceRequest details;

    private BigDecimal amount;
}
