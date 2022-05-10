package com.example.demo.repository;

import com.example.demo.operation.Amount;
import com.example.demo.operation.Properties;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CashRepositoryTests {
    CashRepository cashRepository = new CashRepository();
    Properties properties = new Properties("1111111111111111","12/24","111", "2222222222222222");
    Amount amount = new Amount(12, "P");

    @Test
    public void findCardTest(){
        int expected = 1;
        int actual = cashRepository.findCard(properties);
        assertEquals(expected,actual);
    }

    @Test
    public void transferCardTest(){
        int expected = 1;
        int actual = cashRepository.transferCard(properties,amount);
        assertEquals(expected,actual);
    }
}
