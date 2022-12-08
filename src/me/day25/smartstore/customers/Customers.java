package me.day25.smartstore.customers;

import me.day25.smartstore.groups.Group;
import me.day25.smartstore.groups.GroupType;
import me.day25.smartstore.groups.Groups;

import java.util.Arrays;

public class Customers { // singleton


    ////////////// singleton ////////////////
    private static Customers allCustomers;

    public static Customers getInstance() {
        if (allCustomers == null) {
            allCustomers = new Customers();
        }
        return allCustomers;
    }
    /////////////////////////////////////////

    private final Groups allGroups = Groups.getInstance();

    protected static int DEFAULT_SIZE = 10;
    protected int capacity;
    protected int size;
    protected Customer[] customers;

    public Customers() {
        customers = new Customer[DEFAULT_SIZE];
        capacity = DEFAULT_SIZE;
    }


    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public Customer[] getCustomers() {
        int realCount = 0;

        for(int i = 0; i < customers.length; i++) {
            realCount++;
        }

        return Arrays.copyOf(customers, realCount);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int capacity() { return capacity; }
    public int size() {
        return size;
    }

    private boolean isNull() {
        return customers == null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Customer customer) {
        if (size < capacity) {
            customers[size] = customer;
            size++;
        } else {
            extend(customer);
        }

    }

    public void add(int index, Customer customer) {
        if (index < size) {
            if (size < capacity) {
                Customer customer1 = customers[index];

                for (int i = customers.length - 1; i >= index; i--) {
                    customers[i + 1] = customers[i];
                }

                customers[index] = customer;
                size++;
            } else {
                extend(index, customer);
            }

        }
    }

    public void extend(int index, Customer customer) {
        Customer[] copy = Arrays.copyOf(customers, customers.length);
        capacity *= 2;
        customers = new Customer[capacity];

        System.arraycopy(copy, 0, customers, 0, copy.length);

        size = copy.length;
        add(index, customer);
    }

    public void extend(Customer customer) {
        Customer[] copy = Arrays.copyOf(customers, customers.length);
        capacity *= 2;
        customers = new Customer[capacity];

        System.arraycopy(copy, 0, customers, 0, copy.length);

        size = copy.length;
        add(customer);
    }

    public int pop(int index) {
        if (size == 0) {
            return -1;
        } else if (index >= 0 && index < size) {
            customers[index] = null;

            for(int i = index + 1; i < size; ++i) {
                customers[i - 1] = customers[i];
            }

            --size;
            return 1;
        } else {
            return -1;
        }
    }

    public int pop() {
        if (size == 0) {
            return -1;
        } else {
            customers[size - 1] = null;
            size--;
            return 1;
        }
    }

    public Customer get(int i) {
        return i < size ? customers[i] : null;
    }

    public void set(int i, Customer customer) {
        customers[i] = customer;
    }

    public Customers findCustomers(GroupType type) {
        Customers custs = new Customers();
        if (custs == null) return null;

        for(int i = 0; i < size; ++i) {
            Customer cust = get(i);
            if (cust == null) return null;

            Group grp = cust.getGroup();
            if (type.equals(GroupType.NONE)) {
                if (grp == null || grp.getType() == null || grp.getType().equals(GroupType.NONE)) {
                    custs.add(cust);
                }
            } else if (grp != null && grp.getType().equals(type)) {
                custs.add(cust);
            }

        }


        return custs;
    }

    public Customers findCustomers(Group grp) {

        if (grp != null) {
            if (grp.getType() != null) {
                return findCustomers(grp.getType());
            } else {
                System.out.println("Customers.findCustomers Error : No group type.");
                return null;
            }
        } else {
            System.out.println("Customers.findCustomers Error : No group.");
            return null;
        }
    }

    public void refresh(Groups groups) {
        if (groups == null) return;

        System.out.println(size);
        for (int i = 0; i < size; i++) {
            Customer cust = customers[i];
            cust.setGroup(groups.findGroupFor(cust));
        }

    }

    public void print() {
        for (int i = 0; i < size; i++) {
            if (customers[i] != null) {
                System.out.printf("No.  %4d => %s\n", (i + 1), customers[i]);
            }
        }
    }

    public ClassifiedCustomersGroup classify() {
        ClassifiedCustomersGroup classifiedCustomersGroup = ClassifiedCustomersGroup.getInstance();

        for (int i = 0; i < allGroups.length(); ++i) {
            Group grp = allGroups.get(i);
            Customer[] customers = grp.getCustomers(allCustomers).getCustomers();
            //System.out.println(Arrays.toString(customers));

            ClassifiedCustomers classifiedCustomers = new ClassifiedCustomers();
            classifiedCustomers.setGroup(grp);
            classifiedCustomers.setSize(customers.length);
            classifiedCustomers.setCustomers(customers);

            classifiedCustomersGroup.set(i, classifiedCustomers);
        }
        return classifiedCustomersGroup;
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < size; ++i) {
            str = str + customers[i].toString() + "\n";
        }

        return str;
    }
}
