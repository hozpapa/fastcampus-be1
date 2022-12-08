package me.day25.smartstore.customers;


import me.day25.smartstore.groups.GroupType;
import me.day25.smartstore.groups.Parameter;
import me.day25.smartstore.util.UtilMethod;

import java.util.Arrays;
import java.util.Comparator;

public class ClassifiedCustomersGroup {

    /////////////////////////////////////////
    ////////////// singleton ////////////////
    private static ClassifiedCustomersGroup classifiedCustomersGroup;

    public static ClassifiedCustomersGroup getInstance() {
        if (classifiedCustomersGroup == null) {
            classifiedCustomersGroup = new ClassifiedCustomersGroup();
        }
        return classifiedCustomersGroup;
    }
    /////////////////////////////////////////
    /////////////////////////////////////////

    private ClassifiedCustomers[] classifiedCustomers;

    public ClassifiedCustomersGroup() {
        classifiedCustomers = new ClassifiedCustomers[GroupType.size()];

        for (int i = 0; i < GroupType.size(); i++) {
            classifiedCustomers[i] = new ClassifiedCustomers();
        }
    }


    public ClassifiedCustomers get(int i) {
        return classifiedCustomers[i];
    }

    public void set(int i, ClassifiedCustomers customers) {
        classifiedCustomers[i] = customers;
    }

    public int size() {
        return GroupType.size();
    }
    
    public void print() {
        for (int i = 0; i < classifiedCustomers.length; i++) {
            System.out.println("\n==============================");

            if (classifiedCustomers[i] == null) return;

            GroupType groupType = classifiedCustomers[i].getGroup().getType();
            Parameter parameter = classifiedCustomers[i].getGroup().getParam();

            System.out.printf("Group : %s ( Time : %d, Pay : %d )\n",
                    groupType,
                    parameter != null ? parameter.getMinimumSpentTime() : null,
                    parameter != null ? parameter.getMinimumTotalPay() : null);
            System.out.println("==============================");

            if (classifiedCustomers[i] == null || classifiedCustomers[i].isEmpty()) {
                System.out.println("Null.");
                continue;
            }
            classifiedCustomers[i].print();
            System.out.println("==============================\n");
        }

    }

    public void sort(Comparator<Customer> comparator) {

        for (int i = 0; i < classifiedCustomersGroup.size(); i++) {
            Customer[] customers = classifiedCustomersGroup.get(i).getRealCustomers();

            if (UtilMethod.isAnyNUll(customers)) continue;

            boolean checker = false;
            for (Customer customer: customers) {
                if (UtilMethod.isAnyNUll(
                        customer.getSerialNO(),
                        customer.getName(),
                        customer.getUserId(),
                        customer.getSpentTime(),
                        customer.getTotalPay())) {
                    checker = true;
                    break;
                }
            }
            if (checker) {
                continue;
            }

            //System.out.println(Arrays.toString(customers));

            if (comparator == null) Arrays.sort(customers);
            else Arrays.sort(customers, comparator);
            classifiedCustomersGroup.get(i).setCustomers(customers);
        }
    }

//    public void sortByName(OrderType orderType) throws InputNullException {
//        if (orderType == null) throw new InputNullException();
//
//        for (int i = 0; i < classifiedCustomersGroup.length(); i++) {
//            Customer[] customers = classifiedCustomersGroup.get(i).getCustomers();
//            if (orderType == OrderType.ASCENDING) {
//                Arrays.sort(customers);
//            } else {
//                Arrays.sort(customers, (o1, o2) -> o1.compareTo(o2) * -1);
//            }
//            classifiedCustomersGroup.get(i).setCustomers(customers);
//        }
//    }
//
//    public void sortedBySpentTime(OrderType orderType) throws InputNullException {
//        if (orderType == null) throw new InputNullException();
//
//        Comparator<Customer> comparator = Comparator
//                .comparing( Customer :: getSpentTime )
//                .thenComparing( Customer :: getName );
//
//        for (int i = 0; i < classifiedCustomersGroup.length(); i++) {
//            Customer[] customers = classifiedCustomersGroup.get(i).getCustomers();
//            if (orderType == OrderType.ASCENDING) {
//                Arrays.sort(customers, comparator);
//            } else {
//                Arrays.sort(customers, comparator.reversed());
//            }
//
//            classifiedCustomersGroup.get(i).setCustomers(customers);
//        }
//
//    }
//
//    public void sortedByTotalPay(OrderType orderType) {
//        Comparator<Customer> comparatorByTotalPay = Comparator
//                .comparing( Customer :: getTotalPay )
//                .thenComparing( Customer :: getName );
//
//        if (orderType != null && !orderType.equals("")) {
//            for (int i = 0; i < classifiedCustomersGroup.length(); i++) {
//                Customer[] customers = classifiedCustomersGroup.get(i).getCustomers();
//                if (orderType == OrderType.ASCENDING) {
//                    Arrays.sort(customers, comparatorByTotalPay);
//                } else {
//                    Arrays.sort(customers, comparatorByTotalPay.reversed());
//                }
//                classifiedCustomersGroup.get(i).setCustomers(customers);
//            }
//        }
//    }
//
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
