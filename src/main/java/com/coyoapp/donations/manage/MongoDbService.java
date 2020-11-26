package com.coyoapp.donations.manage;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * Handles management operations on the mongodb.
 */
@Component
@RequiredArgsConstructor
public class MongoDbService {

    private final List<MongoRepository> repositories;

    public void flush() {
        repositories.forEach(CrudRepository::deleteAll);
    }
}
