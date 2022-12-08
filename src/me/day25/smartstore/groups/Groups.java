package me.day25.smartstore.groups;


import me.day25.smartstore.customers.Customer;

public class Groups { // singleton
    private static Groups allGroups;
    private int count;
    private Group[] groups;


    public static Groups getInstance() {
        if (allGroups == null) {
            allGroups = new Groups();
        }
        return allGroups;
    }

    public Groups() {
        this.groups = new Group[GroupType.values().length];
        initialize();
    }

    public Groups(int maxSize) {
        this.groups = new Group[maxSize];
    }

    public int getCount() {
        return this.count;
    }

    public int length() {
        return this.groups.length;
    }

    private boolean isNull() {
        return groups == null;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void initialize() {
        int i = 0;
        for(GroupType groupType : GroupType.values()) {
            groups[i] = new Group(groupType, null);
            i++;
        }
    }

    public void add(Group group) {
        Group grp = this.find(group.getType());
        if (grp != null) {
            update(group);
        } else {
            this.groups[this.count] = group;
            ++this.count;
        }

    }

    public Group get(int i) {
        return this.groups[i];
    }

    public void update(Group group) {
        Group grp = this.find(group.getType());
        if (grp != null) {
            grp.setParam(group.getParam());
        }

    }

    public void print() {
        for (int i = 0; i < count; i++) {
            if (groups[i] != null) {
                System.out.println(groups[i]);
            }
        }
    }

    public Group find(GroupType groupType) {
        for (Group grp : groups) {
            if (grp.getType() == groupType)
                return grp;
        }
        return null;
    }

    public Group findGroupFor(Customer cust) {
        if (groups == null || cust == null) return null;


        for(int i = groups.length - 1; i >= 0; i--) {
            Parameter param = groups[i].getParam();
            if (param == null) continue;;

            if (cust.getSpentTime() >= param.getMinimumSpentTime()
                    && cust.getTotalPay() >= param.getMinimumTotalPay()) {
                return groups[i];
            }

            return null;
        }

        return null;
    }

    @Override
    public String toString() {
        String str = "";

        for(int i = 0; i < count; ++i) {
            str = str + " " + groups[i].toString() + "\n";
        }

        return str;
    }
}
