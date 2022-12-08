package me.day25.smartstore.customers;

import me.day25.smartstore.groups.Group;
import me.day25.smartstore.groups.GroupType;
import me.day25.smartstore.groups.Groups;

import java.util.Arrays;

public class Customers { // singleton
    private static Customers allCustomers;
    protected final Groups allGroups = Groups.getInstance();

    protected static int DEFAULT_SIZE = 10;
    protected int size;
    protected int count;
    protected Customer[] customers;

    public static Customers getInstance() {
        if (allCustomers == null) {
            allCustomers = new Customers();
        }
        return allCustomers;
    }

    public Customers() {
        customers = new Customer[DEFAULT_SIZE];
        size = DEFAULT_SIZE;
    }

    public int getCount() {
        return count;
    }

    public void setCustomers(Customer[] customers) {
        customers = customers;
    }

    public Customer[] getCustomers() {
        int realCount = 0;

        for(int i = 0; i < customers.length; i++) {
            realCount++;
        }

        return Arrays.copyOf(customers, realCount);
    }

    public void setCount(int count) {
        count = count;
    }

    public int length() {
        return customers.length;
    }

    private boolean isNull() {
        return customers == null;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void add(Customer customer) {
        if (count < size) {
            customers[count] = customer;
            ++count;
        } else {
            extend(customer);
        }

    }

    public void add(int index, Customer customer) {
        if (index < count) {
            if (count < size) {
                Customer customer1 = customers[index];

                for (int i = customers.length - 1; i >= index; i--) {
                    customers[i + 1] = customers[i];
                }

                customers[index] = customer;
                ++count;
            } else {
                extend(index, customer);
            }

        }
    }

    public void extend(int index, Customer customer) {
        Customer[] copy = Arrays.copyOf(customers, customers.length);
        size *= 2;
        customers = new Customer[size];

        System.arraycopy(copy, 0, customers, 0, copy.length);

        count = copy.length;
        add(index, customer);
    }

    public void extend(Customer customer) {
        Customer[] copy = Arrays.copyOf(customers, customers.length);
        size *= 2;
        customers = new Customer[size];

        System.arraycopy(copy, 0, customers, 0, copy.length);

        count = copy.length;
        add(customer);
    }

    public int pop(int index) {
        if (count == 0) {
            return -1;
        } else if (index >= 0 && index < count) {
            customers[index] = null;

            for(int i = index + 1; i < count; ++i) {
                customers[i - 1] = customers[i];
            }

            --count;
            return 1;
        } else {
            return -1;
        }
    }

    public int pop() {
        if (count == 0) {
            return -1;
        } else {
            customers[count - 1] = null;
            count--;
            return 1;
        }
    }

    public Customer get(int i) {
        return i < count ? customers[i] : null;
    }

    public void set(int i, Customer customer) {
        customers[i] = customer;
    }

    public Customers findCustomers(GroupType type) {
        Customers custs = new Customers();
        if (custs != null) {
            for(int i = 0; i < count; ++i) {
                Customer cust = get(i);
                if (cust != null) {
                    Group grp = cust.getGroup();
                    if (type.equals(GroupType.NONE)) {
                        if (grp == null || grp.getType() == null || grp.getType().equals(GroupType.NONE)) {
                            custs.add(cust);
                        }
                    } else if (grp != null && grp.getType().equals(type)) {
                        custs.add(cust);
                    }
                }
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
        if (groups != null) {
            for (int i = 0; i < count; ++i) {
                Customer cust = customers[i];
                cust.setGroup(groups.findGroupFor(cust));
            }

        }
    }

    public void print() {
        for (int i = 0; i < count; i++) {
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
            classifiedCustomers.setCount(customers.length);
            classifiedCustomers.setCustomers(customers);

            classifiedCustomersGroup.set(i, classifiedCustomers);
        }
        return classifiedCustomersGroup;
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < count; ++i) {
            str = str + customers[i].toString() + "\n";
        }

        return str;
    }
}
