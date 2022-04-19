package com.example.demo.operation;


public class Amount {
    private int value;
    private String currency;

    public Amount(int value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public int getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public void getValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
