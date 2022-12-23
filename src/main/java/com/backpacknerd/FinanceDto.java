package com.backpacknerd;

public class FinanceDto {
    public static final int TYPE_INVOICE = 1;
    public static final int TYPE_CREDIT = 2;
    public static final int TYPE_DEBIT = 3;

    private int number;
    private int type;
    private double amount;
    private String currency;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
