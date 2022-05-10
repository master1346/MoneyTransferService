package com.example.demo.repository;

import com.example.demo.card.Card;
import com.example.demo.operation.Amount;
import com.example.demo.operation.Properties;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class CashRepository {
   private final List<Card> listCard = new ArrayList<>(Arrays.asList(
        new Card("1111111111111111","12/24","111",125000,"Р"),
            new Card("2222222222222222","12/25","222",4000,"Р"),
            new Card("3333333333333333","12/25","333",2500,"Р"),
            new Card("4444444444444444","12/25","111",3000,"Р")));


    public int findCard(Properties properties){
       int statusFrom = 2;
       int statusTo = 2;
        for (Card card : listCard) {
            if(Objects.equals(card.getCardNumber(), properties.getCardFromNumber())){
                if (Objects.equals(card.getCardFromCVV(), properties.getCardFromCVV())){
                    statusFrom = 1;
                }
            }
            if(card.getCardNumber().equals(properties.getCardToNumber())) statusTo = 1;
        }
        if(statusTo == 1 && statusFrom == 1) return 1;
        if(statusTo != statusFrom) return 2;
        return 0;
    }

    public int transferCard(Properties properties, Amount amount) {
        for (Card card : listCard) {
            if (Objects.equals(card.getCardNumber(), properties.getCardFromNumber())) {
                if (Objects.equals(card.getCardFromCVV(), properties.getCardFromCVV())) {
                    if ( amount.getValue() <= card.getValue() ) {
                       return 1;
                    }
                }
            }
        }
        return 2;
    }
}
