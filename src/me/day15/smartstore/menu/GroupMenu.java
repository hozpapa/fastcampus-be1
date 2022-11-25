package me.day15.smartstore.menu;

public class GroupMenu extends Menu { // 싱글톤
    private static GroupMenu groupMenu;

    private GroupMenu() {}
    public static GroupMenu getInstance() {
        if (groupMenu == null) {
            groupMenu = new GroupMenu();
        }
        return groupMenu;
    }
}
