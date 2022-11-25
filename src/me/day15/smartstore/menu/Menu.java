package me.day15.smartstore.menu;

public class Menu { // 싱글톤
    private static Menu menu;

    protected Menu() {}
    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }
}
