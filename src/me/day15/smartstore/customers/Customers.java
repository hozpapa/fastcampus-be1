package me.day15.smartstore.customers;

public class Customers { // 싱글톤
    private static Customers allCustomers;
    private static final int DEFAULT_SIZE = 10;
    protected Customer[] customers = new Customer[DEFAULT_SIZE];


    protected Customers() {}
    public static Customers getInstance() {
        if (allCustomers == null) {
            allCustomers = new Customers();
        }
        return allCustomers;
    }

    // size: 실제 객체 수
    // capacity: 배열에 저장할 수 있는 배열 크기
    // size <= capacity

    // Customer 여러명을 저장하는 객체 배열 => Customers
    // 1) add
    // 2) set
    // 3) remove
    // 4) size
    // 5) trimToSize
}
