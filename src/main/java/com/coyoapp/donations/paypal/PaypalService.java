package com.coyoapp.donations.paypal;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Mocked out PayPal payment provider.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PaypalService {

    public String generateClientToken() {
        return UUID.randomUUID().toString();
    }

    public PaypalResult processCheckout(String paymentMethodNonce, BigDecimal amount) {
        log.trace("processCheckout(paymentMethodNonce={}, amount={})", paymentMethodNonce, amount);
        return PaypalResult.of(UUID.randomUUID().toString(), true);
    }

    @Value(staticConstructor = "of")
    public static class PaypalResult {
        String transactionId;
        boolean success;
    }
}
