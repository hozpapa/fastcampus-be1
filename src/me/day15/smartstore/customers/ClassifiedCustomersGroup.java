package me.day15.smartstore.customers;

public class ClassifiedCustomersGroup { // 싱글톤
    private static ClassifiedCustomersGroup classifiedCustomersGroup;
    protected ClassifiedCustomers[] classifiedCustomers; // Customer[][]

    private ClassifiedCustomersGroup() {}
    public static ClassifiedCustomersGroup getInstance() {
        if (classifiedCustomersGroup == null) {
            classifiedCustomersGroup = new ClassifiedCustomersGroup();
        }
        return classifiedCustomersGroup;
    }
}
