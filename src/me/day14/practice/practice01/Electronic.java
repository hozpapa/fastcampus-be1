package me.day14.practice.practice01;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    public enum Company { SAMSUNG, LG, APPLE } // 전자제품을 정의하기 위해 필요
    public enum AuthMethod { FINGERPRINT, PATTERN, PIN, FACE } // 전자제품을 인증하기 위해 필요

    protected String productNo;
    protected String modelName;
    protected Company companyName;
    protected LocalDate dateOfMade;
    protected AuthMethod[] authMethod;

    public Electronic() {
    }

    public Electronic(String productNo) {
        this.productNo = productNo;
    }

    public Electronic(String productNo, String modelName) {
        this.productNo = productNo;
        this.modelName = modelName;
    }

    public Electronic(String productNo, String modelName, Company companyName) {
        this.productNo = productNo;
        this.modelName = modelName;
        this.companyName = companyName;
    }

    public Electronic(String productNo, String modelName, Company companyName, LocalDate dateOfMade) {
        this.productNo = productNo;
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
    }

    public Electronic(String productNo, String modelName, Company companyName, LocalDate dateOfMade, AuthMethod[] authMethod) {
        this.productNo = productNo;
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethod = authMethod;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Company getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Company companyName) {
        this.companyName = companyName;
    }

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public AuthMethod[] getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(AuthMethod[] authMethod) {
        this.authMethod = authMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName) && companyName == that.companyName && Objects.equals(dateOfMade, that.dateOfMade) && Arrays.equals(authMethod, that.authMethod);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, modelName, companyName, dateOfMade);
        result = 31 * result + Arrays.hashCode(authMethod);
        return result;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}
