package com.coyoapp.donations.payment;

import com.coyoapp.donations.invitation.InvitationToken;
import com.coyoapp.donations.invitation.InvitationTokenService;
import com.coyoapp.donations.location.PlaceRequest;
import com.coyoapp.donations.location.PlaceService;
import com.coyoapp.donations.mail.MailService;
import com.coyoapp.donations.paypal.PaypalService;
import com.coyoapp.donations.transaction.TransactionService;
import java.math.BigDecimal;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Handles donations (payments) by users and starts the process for the place that has been donated to if necessary.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentService {

    private final PaypalService paypalService;
    private final TransactionService transactionService;
    private final InvitationTokenService invitationTokenService;
    private final MailService mailService;
    private final PlaceService placeService;

    public PaypalService.PaypalResult processPayment(PaymentRequest request) {
        BigDecimal amount = calculateAmountSum(request.getPlaces());
        PaypalService.PaypalResult result = paypalService.processCheckout(request.getNonce(), amount);
        if (result.isSuccess()) {
            processSuccessfullyCheckout(request.getNonce(), request.getPlaces());
            createPlaces(request);
        }
        return result;
    }

    private BigDecimal calculateAmountSum(Collection<PaymentPlaceRequest> places) {
        return places.stream().map(PaymentPlaceRequest::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void processSuccessfullyCheckout(String transactionId, Collection<PaymentPlaceRequest> places) {
        places.forEach(place ->
                createTransactionAndSendInvitation(place.getDetails().getPlaceId(), transactionId, place.getAmount()));
    }

    private void createTransactionAndSendInvitation(String placeId, String transactionId, BigDecimal amount) {
        transactionService.createTransaction(placeId, transactionId, amount);
        if (invitationTokenService.getByGooglePlaceId(placeId).isEmpty()) {
            createAndSendInvitationToken(placeId);
        }
    }

    private void createAndSendInvitationToken(String placeId) {
        InvitationToken token = invitationTokenService.createToken(placeId);
        mailService.sendInvitationTokenMail(token);
    }

    private void createPlaces(PaymentRequest request) {
        request.getPlaces()
                .stream()
                .map(PaymentPlaceRequest::getDetails)
                .forEach(this::createPlace);
    }

    private void createPlace(PlaceRequest placeRequest) {
        if (placeService.getByGooglePlaceId(placeRequest.getPlaceId()).isEmpty()) {
            placeService.createPlace(placeRequest);
        }
    }
}
