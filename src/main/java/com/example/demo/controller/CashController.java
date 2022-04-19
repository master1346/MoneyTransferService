package com.example.demo.controller;

import com.example.demo.operation.ConfirmOperation;
import com.example.demo.operation.MergeShemaAmount;
import com.example.demo.service.CashService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CashController {
    private CashService cashService;

    public CashController(CashService cashService){
        this.cashService = cashService;
    }

    @PostMapping(path = "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> transferCardToCard(@RequestBody MergeShemaAmount requestJSON ) throws IOException {
        return cashService.transferCardToCard(requestJSON);
    }

    @PostMapping(path = "/confirmOperation",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> confirmOperation(@RequestBody ConfirmOperation confirmOperation){
        return cashService.confirmOperation(confirmOperation);
    }

    @GetMapping("/test")
    public String hello(){
        return "Hello";
    }
}
