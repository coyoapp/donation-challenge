package com.coyoapp.donations.transaction;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> findByGooglePlaceId(String placeId);
}
