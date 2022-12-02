package me.day20.generic.bound;


import me.day20.generic.bound.item.Item;

import java.util.Arrays;
import java.util.Objects;

public class Gifts<T extends Item> {

    private static final int DEFAULT_SIZE = 10;
    private int capacity;

    private T[] gifts;
    private int size;

    public Gifts() {
        gifts = (T[]) new Item[DEFAULT_SIZE];
        this.capacity = DEFAULT_SIZE;
    }

    public Gifts(int capacity) {
        gifts = (T[]) new Item[capacity];
        this.capacity = capacity;
    }

    public T get(int i) {
        return gifts[i];
    }

    public void set(int i, T element) {
        // TODO: set(int i, T element) method implementation
    }


    public void add(T element) {
        if (size < capacity) {
            gifts[size] = element;
            size++;
        } else {
            T[] origin = Arrays.copyOf(gifts, size);
            capacity *= 2;
            gifts = Arrays.copyOf(origin, capacity);
            add(element);
        }
    }

    public void add(int i, T element) {
        // TODO: add(int i, T element) method implementation
    }

    public void clear() {
        // TODO: clear() method implementation
    }

    public void pop() {
        // TODO: pop() method implementation
    }

    public void remove(int i ) {
        // TODO: remove(int i) method implementation
    }

    public void remove(T element) {
        int elementIndex = -1;
        for (int i = 0; i < size; i++) {
            if (gifts[i] != null) {
                if (gifts[i].equals(element)) {
                    elementIndex = i;
                }
            }
        }
        if (elementIndex == -1) {
            System.out.println(element + " can't be found.");
        } else {
            gifts[elementIndex] = null;
            for (int i = elementIndex+1; i < size; i++) {
                gifts[i-1] = gifts[i];
            }
            size--;

            System.out.println(element + " removed successfully.");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] getGifts() {
        return gifts;
    }

    public void setGifts(T[] gifts) {
        this.gifts = gifts;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gifts<?> that = (Gifts<?>) o;
        return capacity == that.capacity && size == that.size && Arrays.equals(gifts, that.gifts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(capacity, size);
        result = 31 * result + Arrays.hashCode(gifts);
        return result;
    }

    @Override
    public String toString() {
        return "RandomGiftBox{" +
                "capacity=" + capacity +
                ", gifts=" + Arrays.toString(gifts) +
                ", size=" + size +
                '}';
    }
}
