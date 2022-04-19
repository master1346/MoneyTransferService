package com.example.demo.operation;

public class MergeShemaAmount {
    private Shema shema;
    private Amount amount;

    public MergeShemaAmount(Shema shema, Amount amount){
        this.shema = shema;
        this.amount = amount;
    }

    public Shema getShema() {
        return shema;
    }

    public void setShema(Shema shema) {
        this.shema = shema;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "MergeShemaAmount{" +
                "shema=" + shema +
                ", amount=" + amount +
                '}';
    }
}
