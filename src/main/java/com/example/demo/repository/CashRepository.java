package com.example.demo.repository;

import com.example.demo.card.Card;
import com.example.demo.operation.Amount;
import com.example.demo.operation.Shema;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class CashRepository {
    int statusFrom;
    int statusTo;
    private final List<Card> listCard = new ArrayList<>(Arrays.asList(
        new Card("1111111111111111","1224","111",1250,"Р"),
            new Card("2222222222222222","1225","222",4000,"Р"),
            new Card("3333333333333333","1225","333",2500,"Р"),
            new Card("4444444444444444","1225","111",3000,"Р")));


    public int findCard(Shema shema){
        statusFrom = 2;
        statusTo = 2;
        for (Card card : listCard) {
            if(Objects.equals(card.getCardNumber(), shema.getCardFromNumber())){
                if (Objects.equals(card.getCardFromCVV(), shema.getCardFromCVV())){
                    statusFrom = 1;
                }
            }
            if(card.getCardNumber().equals(shema.getCardToNumber())) statusTo = 1;
        }
        if(statusTo == 1 && statusFrom == 1) return 1;
        if(statusTo != statusFrom) return 2;
        return 0;
    }

    public int transferCard(Shema shema, Amount amount) {
        for (Card card : listCard) {
            if (Objects.equals(card.getCardNumber(), shema.getCardFromNumber())) {
                if (Objects.equals(card.getCardFromCVV(), shema.getCardFromCVV())) {
                    if ( amount.getValue() <= card.getValue() ) {
                       return 1;
                    }
                }
            }
        }
        return 2;
    }
}
