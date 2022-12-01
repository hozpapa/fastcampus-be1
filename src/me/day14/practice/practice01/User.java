package me.day14.practice.practice01;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private LocalDate userBirthDate;
    private Electronics electronicDevice;

    public User() {}

    public User(String userId, String userPassword, String userEmail) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, LocalDate userBirthDate) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
    }

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, LocalDate userBirthDate, Electronics electronicDevice) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.electronicDevice = electronicDevice;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(LocalDate userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public Electronics getElectronicDevice() {
        return electronicDevice;
    }

    public void setElectronicDevice(Electronics electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userPhoneNumber, user.userPhoneNumber) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userBirthDate, user.userBirthDate) && Objects.equals(electronicDevice, user.electronicDevice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, electronicDevice);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDate=" + userBirthDate +
                ", electronicDevice=" + electronicDevice +
                '}';
    }
}
