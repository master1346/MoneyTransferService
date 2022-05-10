package com.example.demo.operation;

public class MergeShemaAmount {
    private Properties properties;
    private Amount amount;

    public MergeShemaAmount(Properties properties, Amount amount){
        this.properties = properties;
        this.amount = amount;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
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
                "Properties=" + properties +
                ", amount=" + amount +
                '}';
    }
}
