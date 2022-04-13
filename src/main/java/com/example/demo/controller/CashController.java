package com.example.demo.controller;

import com.example.demo.operation.MergeShemaAmount;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CashController {

    @PostMapping(path = "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> hello1(@RequestBody String requestJSON) throws IOException, ParseException {
        String responseRequest = " ";
        JSONParser parser = new JSONParser();
    JSONObject jsonObject = (JSONObject) parser.parse(requestJSON);

    JSONArray shemaArray = (JSONArray) jsonObject.get("shema");


    responseRequest = shemaArray.toString();


       return new ResponseEntity("Success " + responseRequest , HttpStatus.OK);
    }

    @GetMapping("/confirmOperation")
    public void confirmOperation(){

    }

    @GetMapping("/test")
    public String hello(){
        return "Hello";
    }
}
