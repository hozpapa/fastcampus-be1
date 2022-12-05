package me.day14.practice.practice01;

import java.util.Objects;

public class Electronics {

    protected Electronic[] electronics;
    protected static final int DEFAULT_SIZE = 10;
    protected int size;
    protected int capacity;


    protected Electronics() {
        electronics = new Electronic[DEFAULT_SIZE];
        capacity = DEFAULT_SIZE;
    }

    public Electronics(Electronic[] electronics) {
        this.electronics = electronics;

        capacity = electronics.length;
        size = electronics.length;
    }

    public int size() { return size; }

    public int capacity() { return capacity; }

    public boolean isEmpty() { return size == 0; }

    private boolean isNullOrEmpty(Object object) {
        if (object == null || Objects.equals(object, "")) return true;
        return false;
    }

    public void set(int i, Electronic electronic) { // i 번째 원소를 customer 로 수정
        if (!(i >= 0 && i < size)) return;
        if (electronic == null) return;

        electronics[i] = electronic;
    }

    public Electronic get(int i) { // i 번째 원소 반환
        if (!(i >= 0 && i < size)) return null;

        return electronics[i];
    }

    public int indexOf(Electronic electronic) { // electronic 원소 인덱스 반환
        if (electronic == null || isNullOrEmpty(electronic.getProductNo())) return -1; // 객체를 찾지 못함

        for (int i = 0; i < size; i++) {
            if (electronics[i] == null || isNullOrEmpty(electronics[i].getProductNo())) continue;
            if (electronics[i].getProductNo().equals(electronic.getProductNo())) return i;
        }
        return -1; // 객체를 찾지 못함
    }


    public void add(Electronic electronic) { // 가장 마지막에 원소 추가
        if (electronic == null) return;

        if (size < capacity) {
            electronics[size] = electronic;
            size++;
        } else {
            grow(); // doubling
            add(electronic);
        }

    }
    public void add(int i, Electronic electronic) { // i 번째 원소 추가
        if (!(i >= 0 && i <= size)) return;
        if (electronic == null) return;

        if (size < capacity) {
            for (int j = size - 1; j >= i; j--) {
                electronics[j + 1] = electronics[j];
            }
            electronics[i] = electronic;
            size++;
        } else {
            grow();
            add(i, electronic);
        }
    }


    public void pop() { // 가장 마지막의 원소 삭제
        electronics[size - 1] = null;
        size--;
    }

    public void pop(int i) { // i 번째 원소 삭제
        if (!(i >= 0 && i < size)) return;

        electronics[i] = null; // 명시적으로 원소 삭제되었다고 표시하기 위함 (어차피 i + 1에 의해 덮어씌워짐)

        for (int j = i + 1; j < size; j++) {
            electronics[j - 1] = electronics[j];
        }
        electronics[size - 1] = null;
        size--;
    }

    public void pop(Electronic electronic) { // electronic 원소 삭제
        if (electronic == null) return;

        pop(indexOf(electronic));
    }

    public void trimToSize() { // 실제 객체 수만큼 객체 배열의 크기를 변경
        Electronic[] newElectronics = new Electronic[size];
        for (int i = 0; i < size; i++) {
            newElectronics[i] = electronics[i];
        }

        electronics = newElectronics;
        capacity = size;
    }

    public void grow() { // 배열의 크기를 더블링하는 함수
        Electronic[] temp = new Electronic[size];
        for (int i = 0; i < size; i++) {
            temp[i] = electronics[i];
        }

        capacity *= 2;

        Electronic[] newElectronics = new Electronic[capacity];
        for (int i = 0; i < Math.min(size, capacity); i++) {
            newElectronics[i] = temp[i];
        }

        electronics = newElectronics;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.printf("No.  %4d => %s\n", (i + 1), electronics[i]);
        }
    }

    public Electronic findByProductNo(String productNo) {
        if (isNullOrEmpty(productNo)) return null; // 객체를 찾지 못함

        for (int i = 0; i < size; i++) {
            if (electronics[i] == null || isNullOrEmpty(electronics[i].getProductNo())) continue;
            if (electronics[i].getProductNo().equals(productNo)) return electronics[i];
        }
        return null; // 객체를 찾지 못함
    }

    // **
    public Electronics[] groupByCompanyName() {
        Electronics[] groups = { new Electronics(), new Electronics(), new Electronics() };

        for (int i = 0; i < Electronic.Company.values().length; i++) { // SAMSUNG (0), LG (1), APPLE (2) (enumerate)
            for (int j = 0; j < electronics.length; j++) {
                if (isNullOrEmpty(electronics[j].getCompanyName())) continue;
                if (Electronic.Company.values()[i] == electronics[j].getCompanyName()) {
                    groups[i].add(electronics[j]);
                }
            }
        }
        return groups;
    }

    public ClassifiedElectronicsGroup groupByCompanyName2() {
        ClassifiedElectronicsGroup classifiedElectronicsGroup = new ClassifiedElectronicsGroup();

        for (int i = 0; i < Electronic.Company.values().length; i++) { // SAMSUNG (0), LG (1), APPLE (2) (enumerate)
            for (int j = 0; j < electronics.length; j++) {
                if (isNullOrEmpty(electronics[j].getCompanyName())) continue;
                if (classifiedElectronicsGroup.get(i).getCompany() == electronics[j].getCompanyName()) {
                    classifiedElectronicsGroup.get(i).add(electronics[j]);
                }
            }
            //classifiedElectronicsGroup.get(i).trimToSize();
        }
        return classifiedElectronicsGroup;
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < size; i++) {
            str += electronics[i] + "\n";
        }
        return str;
    }
}
