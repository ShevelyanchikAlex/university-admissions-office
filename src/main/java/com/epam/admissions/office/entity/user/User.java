package com.epam.admissions.office.entity.user;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private int userId;
    private String name;
    private String surname;
    private String passwordHash;
    private String email;
    private String passportId;
    private UserStatus userStatus;
    private UserRole userRole;


    public User() {
    }

    public User(int userId, String name, String surname, String passwordHash, String email, String passportId,
                UserStatus userStatus, UserRole userRole) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.passwordHash = passwordHash;
        this.email = email;
        this.passportId = passportId;
        this.userStatus = userStatus;
        this.userRole = userRole;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(passwordHash, user.passwordHash) && Objects.equals(email, user.email) && Objects.equals(passportId, user.passportId) && userStatus == user.userStatus && userRole == user.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, surname, passwordHash, email, passportId, userStatus, userRole);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", email='" + email + '\'' +
                ", passportId='" + passportId + '\'' +
                ", userStatus=" + userStatus +
                ", userRole=" + userRole +
                '}';
    }

}