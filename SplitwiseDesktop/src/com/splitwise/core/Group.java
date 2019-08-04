package com.splitwise.core;

import java.util.ArrayList;

public class Group {

        private String groupId;
        private ArrayList<GroupMember> members = new  ArrayList<>();
        private ArrayList<Expense> expenses = new ArrayList<>();

        //doubt - won't the parameter passed for addGroupMember will be (People people)?
        public boolean addGroupMember(GroupMember groupMember) {
           // members.add(groupMember);
            for (int i = 0; i < members.size(); i++) {
                if ((members.get(i).getMember().equals(groupMember.getMember())) && (members.get(i).getGroupId()
                        .equals(groupMember.getGroupId())
                )) {
                    return false;
                } else {
                    members.add(groupMember);
                }
            }
            return true;

            // Verify that groupMember is not already in members
            // If not then add it to members and return true
            // else do nothing and return false
        }

        // sameGroup.addGroupMember(new GroupMember(p));
        // sameGroup.addPeople(p);


        public boolean addPeople(People people) {
            return addGroupMember(new GroupMember(people,groupId));
        }

        public boolean removeGroupMember(GroupMember groupMember) {

            for (int i = 0; i < members.size(); i++) {
                if ((members.get(i).getMember().equals(groupMember.getMember())) && (members.get(i).getGroupId()
                        .equals(groupMember.getGroupId())
                )) {
                    members.remove(i);
                    return true;
                }
            }
            return false;


            // Verify that groupMember is in members
            // If yes then remove it and return true
            // else do nothing and return false
        }

    /*public boolean removePeople(People people) {
        return removeGroupMember(new GroupMember(people, groupId));
    }*/

    public void getTotalBalance(){

    }


}
