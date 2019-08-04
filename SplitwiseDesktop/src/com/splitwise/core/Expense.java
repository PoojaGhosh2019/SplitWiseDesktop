package com.splitwise.core;

import java.util.ArrayList;

public class Expense {
    private People added_by, paid_by; //doubt did you meet put together by this?
    private float total_Amount;
    private Group group;
    private String category;
    private ArrayList<ExpenseRatio> expenseRatios = new ArrayList<>();

    public void splitEqual(){
        //TODO implement

    }

    public void splitExactAmount(){
        //TODO implement
    }

    public Activity generateActivity(){
        return null;
    }
}
