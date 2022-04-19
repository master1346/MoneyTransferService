package com.example.demo.card;

public class Card {
    private String cardNumber;
    private String cardFromValidTill;
    private String cardFromCVV;
    private int value;
    private String currency;

    public Card(String cardNumber, String cardFromValidTill, String cardFromCVV, int value, String currency) {
        this.cardNumber = cardNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.value = value;
        this.currency = currency;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public void setCardFromValidTill(String cardFromValidTill) {
        this.cardFromValidTill = cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public void setCardFromCVV(String cardFromCVV) {
        this.cardFromCVV = cardFromCVV;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardFromValidTill='" + cardFromValidTill + '\'' +
                ", cardFromCVV='" + cardFromCVV + '\'' +
                ", value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
