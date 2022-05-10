package com.example.demo.controller;

import com.example.demo.operation.ConfirmOperation;
import com.example.demo.operation.MergeShemaAmountNew;
import com.example.demo.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class CashController {
    private final CashService cashService;

    @Autowired
    public CashController(CashService cashService) {
        this.cashService = cashService;
    }

    @PostMapping(path = "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> transferCardToCard(@RequestBody MergeShemaAmountNew requestJSON ) throws IOException {
        return cashService.transferCardToCard(requestJSON);
    }

    @PostMapping(path = "/confirmOperation",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> confirmOperation(@RequestBody ConfirmOperation confirmOperation){
        return cashService.confirmOperation(confirmOperation);
    }

    @GetMapping("/test")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("OK run test", HttpStatus.OK);
    }
}
