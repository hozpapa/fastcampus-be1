package me.day19.practice.practice01;

import me.day14.practice.practice01.Electronic;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class NonMobileElectronic extends Electronic {
    private String address;

    public NonMobileElectronic() {
    }

    public NonMobileElectronic(String address) {
        this.address = address;
    }

    public NonMobileElectronic(String productNo, String modelName) {
        super(productNo, modelName);
    }

    public NonMobileElectronic(String productNo, String modelName, Company companyName) {
        super(productNo, modelName, companyName);
    }

    public NonMobileElectronic(String productNo, String modelName, Company companyName, LocalDate dateOfMade) {
        super(productNo, modelName, companyName, dateOfMade);
    }

    public NonMobileElectronic(String productNo, String modelName, Company companyName, LocalDate dateOfMade, AuthMethod[] authMethod) {
        super(productNo, modelName, companyName, dateOfMade, authMethod);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NonMobileElectronic that = (NonMobileElectronic) o;
        return Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address);
    }

    @Override
    public String toString() {
        return "NonMobileElectronic{" +
                "address='" + address + '\'' +
                ", productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}
