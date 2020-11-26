package com.coyoapp.donations.payment;

import java.util.ArrayList;
import java.util.Collection;
import lombok.Data;

@Data
public class PaymentRequest {

    private String nonce;

    private Collection<PaymentPlaceRequest> places = new ArrayList<>();
}
