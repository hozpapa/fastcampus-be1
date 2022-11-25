package me.day15.smartstore.groups;

public class Group { // 그룹 1명 (NONE, GENERAL, VIP, VVIP)
    private GroupType groupType;
    private Parameter parameter;

    public Group() {
    }

    public Group(GroupType groupType, Parameter parameter) {
        this.groupType = groupType;
        this.parameter = parameter;
    }
}

