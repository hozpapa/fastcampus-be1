package me.day14.practice.practice01;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class MobileElectronic extends Electronic {
    public enum CommunicationMethod { FIVE_G, FOUR_G, THREE_G }

    private CommunicationMethod communicationMethod;
    private Double weight;

    public MobileElectronic() {}

    public MobileElectronic(String productNo) {
        super(productNo);
    }

    public MobileElectronic(String productNo, String modelName) {
        super(productNo, modelName);
    }

    public MobileElectronic(String productNo, String modelName, Company companyName) {
        super(productNo, modelName, companyName);
    }

    public MobileElectronic(String productNo, String modelName, Company companyName, LocalDate dateOfMade) {
        super(productNo, modelName, companyName, dateOfMade);
    }

    public MobileElectronic(String productNo, String modelName, Company companyName, LocalDate dateOfMade, AuthMethod[] authMethod) {
        super(productNo, modelName, companyName, dateOfMade, authMethod);
    }

    public MobileElectronic(String productNo, CommunicationMethod communicationMethod, Double weight) {
        super(productNo);
        this.communicationMethod = communicationMethod;
        this.weight = weight;
    }

    public MobileElectronic(String productNo, String modelName, CommunicationMethod communicationMethod, Double weight) {
        super(productNo, modelName);
        this.communicationMethod = communicationMethod;
        this.weight = weight;
    }

    public CommunicationMethod getCommunicationMethod() {
        return communicationMethod;
    }

    public void setCommunicationMethod(CommunicationMethod communicationMethod) {
        this.communicationMethod = communicationMethod;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MobileElectronic that = (MobileElectronic) o;
        return communicationMethod == that.communicationMethod && weight.equals(that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), communicationMethod, weight);
    }

    @Override
    public String toString() {
        return "MobileElectronic{" +
                "communicationMethod=" + communicationMethod +
                ", weight=" + weight +
                ", productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}
