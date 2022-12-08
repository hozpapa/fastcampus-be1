package me.day25.smartstore.customers;

import me.day25.smartstore.groups.Group;

import java.util.Objects;

public class Customer implements Comparable<Customer> {
    private String serialNO;
    private String name;
    private String userID;
    private Integer spentTime;
    private Integer totalPay;
    private Group group;
    private static int AUTO_GENERATOR = 0;

    public Customer() {
        ++AUTO_GENERATOR;
        this.serialNO = String.format("%04d", AUTO_GENERATOR);
    }

    public Customer(String name, String userID, int spentTime, int totalPay) {
        ++AUTO_GENERATOR;
        this.serialNO = String.format("%04d", AUTO_GENERATOR);
        this.name = name;
        this.userID = userID;
        this.spentTime = spentTime;
        this.totalPay = totalPay;
    }

    public String getSerialNO() {
        return serialNO;
    }

    private void setSerialNO(String serialNO) {
        this.serialNO = serialNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Integer getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(Integer spentTime) {
        this.spentTime = spentTime;
    }

    public Integer getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Integer totalPay) {
        this.totalPay = totalPay;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


    @Override
    public int compareTo(Customer o) {
        if (name.compareTo(o.name) < 0) return -1;
        else if (name.compareTo(o.name) == 0) return userID.compareTo(o.userID);
        else return 1;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(serialNO, customer.serialNO) && Objects.equals(name, customer.name) && Objects.equals(userID, customer.userID) && Objects.equals(spentTime, customer.spentTime) && Objects.equals(totalPay, customer.totalPay) && Objects.equals(group, customer.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNO, name, userID, spentTime, totalPay, group);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "serialNO='" + serialNO + '\'' +
                ", name='" + name + '\'' +
                ", userID='" + userID + '\'' +
                ", spentTime=" + spentTime +
                ", totalPay=" + totalPay +
                ", group=" + group +
                '}';
    }
}
