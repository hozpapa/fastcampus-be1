package me.day15.smartstore.menu;

public class SummaryMenu extends Menu { // 싱글톤
    private static SummaryMenu summaryMenu;

    private SummaryMenu() {}
    public static SummaryMenu getInstance() {
        if (summaryMenu == null) {
            summaryMenu = new SummaryMenu();
        }
        return summaryMenu;
    }
}
