package me.day15.smartstore.menu;

import me.day15.smartstore.groups.Groups;

public class CustomerMenu extends Menu { // 싱글톤
    private static CustomerMenu customerMenu;

    private CustomerMenu() {}
    public static CustomerMenu getInstance() {
        if (customerMenu == null) {
            customerMenu = new CustomerMenu();
        }
        return customerMenu;
    }
}
