package me.day15.smartstore;

import me.day15.smartstore.customers.Customer;
import me.day15.smartstore.customers.Customers;
import me.day15.smartstore.groups.Group;
import me.day15.smartstore.groups.GroupType;
import me.day15.smartstore.groups.Groups;
import me.day15.smartstore.groups.Parameter;

public class SmartStoreApplication  { // 싱글톤
    private static SmartStoreApplication smartStoreApplication;
    private Groups allGroups = Groups.getInstance();
    private Customers allCustomers = Customers.getInstance();


    private SmartStoreApplication() {}

    public static SmartStoreApplication getInstance() {
        if (smartStoreApplication == null) {
            smartStoreApplication = new SmartStoreApplication();
        }
        return smartStoreApplication;
    }


    public void details() {
        System.out.println("===========================================");
        System.out.println(" Title : SmartStore Customer Classification");
        System.out.println("===========================================\n");
    }


    // init. allGroups
    // init. allCustomers
    public SmartStoreApplication test() {
//        allGroups.add(new Group(GroupType.GENERAL, new Parameter(10, 100000)));
//        allGroups.add(new Group(GroupType.VIP, new Parameter(20, 200000)));
//        allGroups.add(new Group(GroupType.VVIP, new Parameter(30, 300000)));

        for (int i = 0; i < 20; i++) {
            allCustomers.add(new Customer(
                    Character.toString((char) ('a' + i)), (char) ('a' + i) + "12345",
                    i * 10, i * 100000));
        }
        return this;
    }

    /*
     * this is method for running application.
     * */
    public void run() {
        // print main menu
        // call main menu
        // call sub menu by user select
    }
}
