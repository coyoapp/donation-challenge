package com.coyoapp.donations.payment;

import com.coyoapp.donations.paypal.PaypalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/payment")
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaypalService paypalService;
    private final PaymentService paymentService;

    @PostMapping("token")
    public ResponseEntity generateToken() {
        String token = paypalService.generateClientToken();
        return ResponseEntity.ok(new TokenResponse(token));
    }

    @PostMapping("checkout")
    public ResponseEntity checkout(@RequestBody PaymentRequest request) {
        PaypalService.PaypalResult result = paymentService.processPayment(request);
        if (result.isSuccess()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
