package com.splitwise.core;

public class GroupMember {
    private People member;
    private double balance;
    private String groupId;

    GroupMember(People people, String groupId) {
        this.member = people;
        this.groupId = groupId;
    }

    public People getMember() {
        return member;
    }

    public String getGroupId() {
        return groupId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
