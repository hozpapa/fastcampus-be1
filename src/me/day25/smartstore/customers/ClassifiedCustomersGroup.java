package me.day25.smartstore.customers;


import me.day25.smartstore.exception.InputEmptyException;
import me.day25.smartstore.exception.InputNullException;
import me.day25.smartstore.groups.GroupType;
import me.day25.smartstore.menu.OrderType;

import java.util.Arrays;
import java.util.Comparator;

public class ClassifiedCustomersGroup {
    private static ClassifiedCustomersGroup classifiedCustomersGroup;

    private ClassifiedCustomers[] classifiedCustomers;

    public ClassifiedCustomersGroup() {
        classifiedCustomers = new ClassifiedCustomers[GroupType.values().length];
        for (int i = 0; i < classifiedCustomers.length; i++) {
            classifiedCustomers[i] = new ClassifiedCustomers();
        }
    }

    public static ClassifiedCustomersGroup getInstance() {
        if (classifiedCustomersGroup == null) {
            classifiedCustomersGroup = new ClassifiedCustomersGroup();
        }
        return classifiedCustomersGroup;
    }


    public ClassifiedCustomers get(int i) {
        return classifiedCustomers[i];
    }

    public void set(int i, ClassifiedCustomers customers) {
        classifiedCustomers[i] = customers;
    }

    public int length() {
        return GroupType.values().length;
    }
    
    public void print() {
        for (int i = 0; i < classifiedCustomers.length; i++) {
            System.out.println("==============================");
            System.out.println("Group : " + classifiedCustomers[i].getGroup().getType());
            System.out.println("==============================");

            if (classifiedCustomers[i] == null || classifiedCustomers[i].isEmpty()) {
                System.out.println("Null.");
                continue;
            }
            classifiedCustomers[i].print();
            System.out.println("==============================\n");
        }

    }

    public void sortByName(OrderType orderType) throws InputNullException {
        if (orderType == null) throw new InputNullException();

        for (int i = 0; i < classifiedCustomersGroup.length(); i++) {
            Customer[] customers = classifiedCustomersGroup.get(i).getCustomers();
            if (orderType == OrderType.ASCENDING) {
                Arrays.sort(customers);
            } else {
                Arrays.sort(customers, (o1, o2) -> o1.compareTo(o2) * -1);
            }
            classifiedCustomersGroup.get(i).setCustomers(customers);
        }
    }

    public void sortedBySpentTime(OrderType orderType) throws InputNullException {
        if (orderType == null) throw new InputNullException();

        Comparator<Customer> comparator = Comparator
                .comparing( Customer :: getSpentTime )
                .thenComparing( Customer :: getName );

        for (int i = 0; i < classifiedCustomersGroup.length(); i++) {
            Customer[] customers = classifiedCustomersGroup.get(i).getCustomers();
            if (orderType == OrderType.ASCENDING) {
                Arrays.sort(customers, comparator);
            } else {
                Arrays.sort(customers, comparator.reversed());
            }

            classifiedCustomersGroup.get(i).setCustomers(customers);
        }

    }

    public void sortedByTotalPay(OrderType orderType) {
        Comparator<Customer> comparatorByTotalPay = Comparator
                .comparing( Customer :: getTotalPay )
                .thenComparing( Customer :: getName );

        if (orderType != null && !orderType.equals("")) {
            for (int i = 0; i < classifiedCustomersGroup.length(); i++) {
                Customer[] customers = classifiedCustomersGroup.get(i).getCustomers();
                if (orderType == OrderType.ASCENDING) {
                    Arrays.sort(customers, comparatorByTotalPay);
                } else {
                    Arrays.sort(customers, comparatorByTotalPay.reversed());
                }
                classifiedCustomersGroup.get(i).setCustomers(customers);
            }
        }
    }

    private void sort() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassifiedCustomersGroup that = (ClassifiedCustomersGroup) o;
        return Arrays.equals(classifiedCustomers, that.classifiedCustomers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(classifiedCustomers);
    }

    @Override
    public String toString() {
        return "ClassifiedCustomersGroup{" +
                "classifiedCustomers=" + Arrays.toString(classifiedCustomers) +
                '}';
    }
}
