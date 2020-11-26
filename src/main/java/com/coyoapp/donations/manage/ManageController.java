package com.coyoapp.donations.manage;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/manage")
@RestController
@RequiredArgsConstructor
public class ManageController {

    private final MongoDbService mongoDbService;

    @DeleteMapping("mongodb")
    public ResponseEntity flushMongoDb() {
        mongoDbService.flush();
        return ResponseEntity.accepted().build();
    }
}
