package com.splitwise.core;

public class Activity {
    private boolean isPositive; // doubt
    private String message;
    private String category;
    private String subMessage;
    private String date;
    private String activityType;
    private static String EXPENSE_ACTIVITY = "EXPENSE_ACTIVITY";
    private static String SETTLEMENT_ACTIVITY = "SETTLEMENT_ACTIVITY";

    public void setPositive(boolean positive) {
        isPositive = positive;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubMessage() {
        return subMessage;
    }

    public void setSubMessage(String subMessage) {
        this.subMessage = subMessage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public static String getExpenseActivity() {
        return EXPENSE_ACTIVITY;
    }

    public static void setExpenseActivity(String expenseActivity) {
        EXPENSE_ACTIVITY = expenseActivity;
    }

    public static String getSettlementActivity() {
        return SETTLEMENT_ACTIVITY;
    }

    public static void setSettlementActivity(String settlementActivity) {
        SETTLEMENT_ACTIVITY = settlementActivity;
    }

    //doubt whether getPositive = getter of isPositive
    public boolean isPositive() {
        return isPositive;
    }
}
