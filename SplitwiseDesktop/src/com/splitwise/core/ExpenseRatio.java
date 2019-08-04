package com.splitwise.core;

public class ExpenseRatio {


    private People creditor;
    private People debitor ;
    private   float amount;
    private float portion;

    public People getCreditor() {
        return creditor;
    }

    public void setCreditor(People creditor) {
        this.creditor = creditor;
    }

    public People getDebitor() {
        return debitor;
    }

    public void setDebitor(People debitor) {
        this.debitor = debitor;
    }


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getPortion() {
        return portion;
    }

    public void setPortion(float portion) {
        this.portion = portion;
    }
}
