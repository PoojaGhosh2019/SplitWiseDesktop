package com.splitwise;

import com.splitwise.core.Activity;
import com.splitwise.core.Group;
import com.splitwise.core.LedgerManager;
import com.splitwise.core.People;

import java.util.ArrayList;

public class SplitWiseCore {
    private LedgerManager ledger = new LedgerManager();
    private People currentUser = new People();
    private ArrayList<People> friends = new ArrayList<>(); // list of friends
    private ArrayList<Group> groups = new ArrayList<>(); //list of groups
    private ArrayList<Activity> activities = new ArrayList<>();


    public void login(){

    }

    public void initialize(){

    }

    public void addFriend(){

    }

    public void createGroup(){

    }
    public void removeGroup(){

    }
    public void removeFriend(){

    }
    public void updateUserInfo(){

    }
    public void getAllActivities(){

    }
    public void getAllGroups(){

    }
    public void getAllFriends(){

    }

}
