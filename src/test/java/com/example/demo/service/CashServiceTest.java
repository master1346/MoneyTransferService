package com.example.demo.service;

import com.example.demo.operation.Amount;
import com.example.demo.operation.ConfirmOperation;
import com.example.demo.operation.MergeShemaAmountNew;
import com.example.demo.operation.Properties;
import com.example.demo.repository.CashRepository;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class CashServiceTest {

    @Mock
    private CashService cashService = new CashService();

    private MergeShemaAmountNew requestJSON = new MergeShemaAmountNew("111111111111111a", "12/24", "111","2222222222222222", new Amount(12, "P"));
    private ResponseEntity<String> response = new ResponseEntity<>("Success", HttpStatus.OK);

    @Test
    void transferCardToCard() throws IOException {
        ResponseEntity<String> actual = cashService.transferCardToCard(requestJSON);
        assertEquals(new ResponseEntity<>("Error input data",HttpStatus.BAD_REQUEST), actual);
    }

    @Test
     void printLog(){
       assertDoesNotThrow( () -> cashService.printLog(requestJSON,response));
    }

    @Test
    void confirmOperation() {
        var expected = new ResponseEntity<>("Success confirmation", HttpStatus.OK);
        var actual = cashService.confirmOperation(new ConfirmOperation("0000"));
        assertEquals(expected,actual);
    }

    @Test
    void statusMessage() {
        var expected = new ResponseEntity<>("Success",HttpStatus.OK);
        var actual = cashService.statusMessage(1,1);
        assertEquals(expected,actual);
    }

}