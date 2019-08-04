package com.splitwise.core;

import java.util.ArrayList;

public class People {
    protected String name;
    protected String id;
    private Float balance_amount;
    private Float userBalance;
    private ArrayList<String> friends = new ArrayList<>();
    protected ArrayList<Group> groups = new ArrayList<>();

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    //friends balance getter/ setter
    public Float getBalance_amount() {
        return balance_amount;
    }

    public void setBalance_amount(Float balance_amount) {
        this.balance_amount = balance_amount;
    }

    //user balance getter/setter
    public Float getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Float userBalance) {
        this.userBalance = userBalance;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public ArrayList<String> getFriends(String friendName) {
        friends.add(friendName);            //Ask doubt
        return friends;
    }
}

