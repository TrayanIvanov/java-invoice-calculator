package com.backpacknerd;

import java.util.LinkedList;
import java.util.List;

public class FinanceDtoBuilder {
    public static List<FinanceDto> buildCollection(List<String[]> items, String vatNumber) {
        LinkedList<FinanceDto> financeDtosCollection = new LinkedList<>();

        items.stream()
                .skip(1)
                .forEach(el -> {
                    if (el[1].equalsIgnoreCase(vatNumber)) {
                        financeDtosCollection.add(buildItem(el));
                    }
                }
        );

        return financeDtosCollection;
    }

    public static FinanceDto buildItem(String[] item) {
        FinanceDto dto = new FinanceDto();
        dto.setNumber(Integer.parseInt(item[2]));
        dto.setType(Integer.parseInt(item[3]));
        dto.setAmount(Double.parseDouble(item[6]));
        dto.setCurrency(item[5]);

        return dto;
    }
}
