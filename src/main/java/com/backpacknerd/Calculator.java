package com.backpacknerd;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Calculator {
    public static double sum(List<FinanceDto> financeDtos, List<CurrencyDto> currencyDtos, String outputCurrency) {
        double sum = 0.0;

        for(FinanceDto financeDtoRow: financeDtos) {
            double dtoAmount;

            Optional<CurrencyDto> currencyDto = currencyDtos.stream()
                    .filter(c -> c.getLabel().equalsIgnoreCase(financeDtoRow.getCurrency()))
                    .findFirst();

            if (currencyDto.isEmpty()) {
                throw new NoSuchElementException("No currency data found: " + financeDtoRow.getCurrency());
            }

            dtoAmount = financeDtoRow.getAmount() / currencyDto.get().getRate();

            Optional<CurrencyDto> outputCurrencyDto = currencyDtos.stream()
                    .filter(c -> c.getLabel().equalsIgnoreCase(outputCurrency))
                    .findFirst();

            if (outputCurrencyDto.isEmpty()) {
                throw new NoSuchElementException("No output currency data found: " + outputCurrency);
            }

            dtoAmount = dtoAmount * outputCurrencyDto.get().getRate();

            if (financeDtoRow.getType() != FinanceDto.TYPE_CREDIT) {
                sum += dtoAmount;
            } else {
                sum -= dtoAmount;
            }
        }

        return Math.round(sum * 100d) / 100d;
    }
}
