package me.day15.smartstore.customers;

public class ClassifiedCustomersGroup { // 싱글톤
    protected ClassifiedCustomers[] classifiedCustomers; // Customer[][]
    private static ClassifiedCustomersGroup classifiedCustomersGroup;

    private ClassifiedCustomersGroup() {}
    public static ClassifiedCustomersGroup getInstance() {
        if (classifiedCustomersGroup == null) {
            classifiedCustomersGroup = new ClassifiedCustomersGroup();
        }
        return classifiedCustomersGroup;
    }
}
