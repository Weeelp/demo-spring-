package com.base.demo_spring4.model;

import jakarta.persistence.*;

@Table(name="users")
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name="id")
  private long userId;
  @Column(name="firstname")
  private String firstname;
  @Column(name="password")
  private String password;
  @Column(name="phone_number")
  private String phone;
  @Column(name="role")
  private String role;
  public User() {
  }

  public User(String firstname, String password, String phone) {
    this.firstname = firstname;
    this.password = password;
    this.phone = phone;
  }

  public User(long userId, String firstname, String password, String phone) {
    this.userId = userId;
    this.firstname = firstname;
    this.password = password;
    this.phone = phone;
  }

  public User(String firstname, String password, String phone, String role) {
    this.firstname = firstname;
    this.password = password;
    this.phone = phone;
    this.role = role;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long id) {
    this.userId = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("User{");
    sb.append("id=").append(userId);
    sb.append(", firstname='").append(firstname).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", phone='").append(phone).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
