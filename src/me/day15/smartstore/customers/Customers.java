package me.day15.smartstore.customers;

import me.day13.polymorphism.ancestor.D;

import java.util.Arrays;

public class Customers { // 싱글톤
    private static Customers allCustomers;
    private static final int DEFAULT_SIZE = 10;
    protected Customer[] customers;
    private int size;
    private int capacity;


    protected Customers() {
        customers = new Customer[DEFAULT_SIZE];
        capacity = DEFAULT_SIZE;
    }

    public static Customers getInstance() {
        if (allCustomers == null) {
            allCustomers = new Customers();
        }
        return allCustomers;
    }
    public int size() { return size; }

    public int capacity() { return capacity; }

    public boolean isEmpty() { return size == 0; }

    public void set(int i, Customer customer) { // i 번째 원소를 customer 로 수정
        if (!(i >= 0 && i < size)) return;
        if (customer == null) return;

        customers[i] = customer;
    }

    public Customer get(int i) { // i 번째 원소 반환
        if (!(i >= 0 && i < size)) return null;

        return customers[i];
    }

    public int indexOf(Customer customer) { // customer 원소 인덱스 반환
        if (customer == null || customer.getSerialNO() == null || customer.getSerialNO().equals("")) return -1; // 객체를 찾지 못함

        for (int i = 0; i < size; i++) {
            if (customers[i] == null || customers[i].getSerialNO() == null || customers[i].getSerialNO().equals("")) continue;
            if (customers[i].getSerialNO().equals(customer.getSerialNO())) return i;
        }
        return -1; // 객체를 찾지 못함
    }


    public void add(Customer customer) { // 가장 마지막에 원소 추가
        if (customer == null) return;

        if (size < capacity) {
            customers[size] = customer;
            size++;
        } else {
            grow(); // doubling
            add(customer);
        }

    }
    public void add(int i, Customer customer) { // i 번째 원소 추가
        if (!(i >= 0 && i < size)) return;
        if (customer == null) return;

        if (size < capacity) {
            for (int j = size - 1; j >= i; j--) {
                customers[j + 1] = customers[j];
            }
            customers[i] = customer;
            size++;
        } else {
            grow();
            add(i, customer);
        }
    }


    public void pop() { // 가장 마지막의 원소 삭제
        customers[size - 1] = null;
        size--;
    }

    public void pop(int i) { // i 번째 원소 삭제
        if (!(i >= 0 && i < size)) return;

        customers[i] = null; // 명시적으로 원소 삭제되었다고 표시하기 위함 (어차피 i + 1에 의해 덮어씌워짐)

        for (int j = i + 1; j < size; j++) {
            customers[j - 1] = customers[j];
        }
        customers[size - 1] = null;
        size--;
    }

    public void pop(Customer customer) { // customer 원소 삭제
        if (customer == null) return;

        pop(indexOf(customer));
    }

    public void trimToSize() { // 실제 객체 수만큼 객체 배열의 크기를 변경
        Customer[] newCustomers = new Customer[size];
        for (int i = 0; i < size; i++) {
            newCustomers[i] = customers[i];
        }

        customers = newCustomers;
        capacity = size;
    }

    public void grow() { // 배열의 크기를 더블링하는 함수
        Customer[] temp = new Customer[size];
        for (int i = 0; i < size; i++) {
            temp[i] = customers[i];
        }

        capacity *= 2;

        Customer[] newCustomers = new Customer[capacity];
        for (int i = 0; i < Math.min(size, capacity); i++) {
            newCustomers[i] = temp[i];
        }

        customers = newCustomers;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.printf("No.  %4d => %s\n", (i + 1), customers[i]);
        }
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < size; i++) {
            str += customers[i] + "\n";
        }
        return str;
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
    // 6) grow (doubling)
}
