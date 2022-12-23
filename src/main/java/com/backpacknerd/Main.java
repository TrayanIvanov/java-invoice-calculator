package com.backpacknerd;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello there!");

        System.out.println("Enter currencies with rates (example: EUR:1,GBP:1.9,USD:0.8):");
//        String currenciesRates = sc.next();
        String currenciesRates = "EUR:1,USD:1.05,GBP:0.86";
        List<CurrencyDto> currencyRates = CurrencyDtoBuilder.buildCollectionFromString(currenciesRates);

        System.out.println("Enter output currency (example: GBP):");
//        String outputCurrency = sc.next();
        String outputCurrency = "GBP";

        System.out.println("Enter csv filename:");
//        String filename = sc.next();
        String filename = "data2.csv";

        System.out.println("Enter vat number filter (leave blank for none):");
//        String filename = sc.next();
        String vatNumber = "123456789";

        try {
            List<String[]> rows = CsvReader.read(filename);
            List<FinanceDto> financeDtos = FinanceDtoBuilder.buildCollection(rows, vatNumber);
            double sum = Calculator.sum(financeDtos, currencyRates, outputCurrency);

            System.out.println("Total sum:");
            System.out.println(sum + outputCurrency);

        } catch (IOException | CsvException e) {
            System.out.println("CSV file not found!");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}