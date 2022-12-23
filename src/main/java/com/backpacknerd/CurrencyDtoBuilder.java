package com.backpacknerd;

import java.util.LinkedList;
import java.util.List;

public class CurrencyDtoBuilder {
    public static List<CurrencyDto> buildCollectionFromString(String currenciesString) {
        LinkedList<CurrencyDto> currenciesDtosCollection = new LinkedList<>();

        String[] currenciesRates = currenciesString.split(",");
        for(String currency: currenciesRates) {
            String[] rate = currency.split(":");
            CurrencyDto dto = new CurrencyDto();
            dto.setLabel(rate[0]);
            dto.setRate(Double.parseDouble(rate[1]));

            currenciesDtosCollection.add(dto);
        }

        return currenciesDtosCollection;
    }
}
