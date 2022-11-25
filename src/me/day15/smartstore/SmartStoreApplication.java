package me.day15.smartstore;

public class SmartStoreApplication  { // 싱글톤
    private static SmartStoreApplication smartStoreApplication;

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


    public SmartStoreApplication test() {
        return this;
    }

    /*
     * this is method for running application.
     * */
    public void run() {

    }
}
