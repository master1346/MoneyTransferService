package com.example.demo.service;

import com.example.demo.operation.Amount;
import com.example.demo.operation.ConfirmOperation;
import com.example.demo.operation.MergeShemaAmount;
import com.example.demo.operation.Shema;
import com.example.demo.repository.CashRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@Service
public class CashService {

    private final File logFile = new File("log","logFile.log");
    private final File dir = new File("log");
    private final CashRepository cashRepository;

    public CashService(CashRepository cashRepository) throws IOException {
       this.cashRepository = cashRepository;
    }

    public ResponseEntity<String> transferCardToCard(MergeShemaAmount requestJSON) throws IOException {
        int statusFind = 2;
        int statusTransfer = 2;
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Success",HttpStatus.OK);
        Shema shema = requestJSON.getShema();
        Amount amount = requestJSON.getAmount();

        statusFind = cashRepository.findCard(shema);
        if(statusFind == 2) responseEntity = new ResponseEntity<>("Error input data",HttpStatus.BAD_REQUEST);
        if(statusFind == 0){ responseEntity = new ResponseEntity<>("Error transfer",HttpStatus.INTERNAL_SERVER_ERROR);}

        statusTransfer = cashRepository.transferCard(shema, amount);
        if(statusFind == 1 && statusTransfer == 2) responseEntity = new ResponseEntity<>("Error input data",HttpStatus.BAD_REQUEST);
        //Good request
        if(statusFind == 1 && statusTransfer == 1) responseEntity = new ResponseEntity<>("Success",HttpStatus.OK);
        printLog(requestJSON, responseEntity);

       return responseEntity;
    }

    public void printLog(MergeShemaAmount requestJSON,ResponseEntity response) throws IOException {
        Date date = new Date();
        FileWriter fileWriter = new FileWriter(logFile,true);
        fileWriter.append(date.toString() + requestJSON.getShema().getCardFromNumber() +
                requestJSON.getShema().getCardToNumber() +
                requestJSON.getAmount().getValue() + response.toString() + "\n");
        fileWriter.close();
    }

    public ResponseEntity<String> confirmOperation(ConfirmOperation confirmOperation) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Succeess", HttpStatus.OK);
        if(confirmOperation.getCodeAuth().equals("0000")) responseEntity = new ResponseEntity<>("Success confirmation", HttpStatus.OK);
        if(confirmOperation.getCodeAuth().equals("0000")) responseEntity = new ResponseEntity<>("Error input data", HttpStatus.BAD_REQUEST );
        if(confirmOperation.getCodeAuth().equals("0000")) responseEntity = new ResponseEntity<>("Error confirmation", HttpStatus.INTERNAL_SERVER_ERROR);

        return responseEntity;
    }
}
