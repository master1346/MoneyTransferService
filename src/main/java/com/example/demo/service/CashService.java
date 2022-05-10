package com.example.demo.service;

import com.example.demo.operation.*;
import com.example.demo.repository.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@Service
public class CashService {

    private final File logFile;
    private final CashRepository cashRepository;

    @Autowired
    public CashService() {
       this.logFile =  new File("log","logFile.log");
       this.cashRepository = new CashRepository();
    }

    public ResponseEntity<String> transferCardToCard(MergeShemaAmountNew requestJSON) throws IOException {
        Properties properties = new Properties(requestJSON.getCardFromNumber(), requestJSON.getCardFromValidTill(), requestJSON.getCardFromCVV(), requestJSON.getCardToNumber());
        Amount amount = requestJSON.getAmount();

        ResponseEntity<String> responseEntity = statusMessage(cashRepository.findCard(properties), cashRepository.transferCard(properties, amount));
        printLog(requestJSON, responseEntity);

        return responseEntity;
    }

    public void printLog(MergeShemaAmountNew requestJSON, ResponseEntity<String> response) throws IOException{
        Date date = new Date();
        FileWriter fileWriter = new FileWriter(this.logFile,true);
        fileWriter.append(date + requestJSON.getCardFromNumber() +
                requestJSON.getCardToNumber() +
                requestJSON.getAmount().getValue() + response.toString() + "\n");
        fileWriter.close();
    }

    public ResponseEntity<String> confirmOperation(ConfirmOperation confirmOperation) {
        if(confirmOperation.getCode().equals("0000")) {
            return new ResponseEntity<>("Success confirmation", HttpStatus.OK);
        } else {
            return new ResponseEntity<>( "Error code", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> statusMessage(int statusFind, int statusTransfer){
        if(statusFind == 2) return new ResponseEntity<>("Error input data",HttpStatus.BAD_REQUEST);
        if(statusFind == 0) return new ResponseEntity<>("Error transfer",HttpStatus.INTERNAL_SERVER_ERROR);
        if(statusFind == 1 && statusTransfer == 2) new ResponseEntity<>("Error input data",HttpStatus.BAD_REQUEST);
        //Good request
        if(statusFind == 1 && statusTransfer == 1) new ResponseEntity<>("Success",HttpStatus.OK);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
