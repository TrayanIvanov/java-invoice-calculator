package com.backpacknerd;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void testSum() {
        FinanceDto financeDto1 = new FinanceDto();
        financeDto1.setNumber(111);
        financeDto1.setType(FinanceDto.TYPE_INVOICE);
        financeDto1.setAmount(200);
        financeDto1.setCurrency("USD");
        FinanceDto financeDto2 = new FinanceDto();
        financeDto2.setNumber(222);
        financeDto2.setType(FinanceDto.TYPE_CREDIT);
        financeDto2.setAmount(100);
        financeDto2.setCurrency("USD");

        List<FinanceDto> financeDtosList = new LinkedList<>();
        financeDtosList.add(financeDto1);
        financeDtosList.add(financeDto2);

        CurrencyDto currencyDto1 = new CurrencyDto();
        currencyDto1.setLabel("EUR");
        currencyDto1.setRate(1);
        CurrencyDto currencyDto2 = new CurrencyDto();
        currencyDto2.setLabel("USD");
        currencyDto2.setRate(1.05);
        CurrencyDto currencyDto3 = new CurrencyDto();
        currencyDto3.setLabel("GBP");
        currencyDto3.setRate(0.86);

        List<CurrencyDto> currencyDtosList = new LinkedList<>();
        currencyDtosList.add(currencyDto1);
        currencyDtosList.add(currencyDto2);
        currencyDtosList.add(currencyDto3);

        assertEquals(81.9, Calculator.sum(financeDtosList, currencyDtosList, "GBP"));
    }
}
