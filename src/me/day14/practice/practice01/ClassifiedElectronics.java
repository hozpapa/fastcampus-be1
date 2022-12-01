package me.day14.practice.practice01;

import java.util.Arrays;
import java.util.Objects;

// ClassifiedElectronics is a kind of Electronics
public class ClassifiedElectronics extends Electronics {
    private Electronic.Company company;

    public ClassifiedElectronics() {
    }

    public ClassifiedElectronics(Electronic.Company company) {
        this.company = company;
    }

    public Electronic.Company getCompany() {
        return company;
    }

    public void setCompany(Electronic.Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassifiedElectronics that = (ClassifiedElectronics) o;
        return company == that.company;
    }

    @Override
    public int hashCode() {
        return Objects.hash(company);
    }

    @Override
    public String toString() {
        return "ClassifiedElectronics{" +
                "company=" + company +
                ", electronics=" + super.toString() +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
