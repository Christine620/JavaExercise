package com.zyt.p2.bean;

/**
 * ClassName:    CustomerList
 * Package:    com.zyt.p2.service
 * Description: Customer为实体对象，用来封装客户信息
 * Datetime:    2020/9/17   10:43
 * Author:   XXXXX@XX.com
 */
public class Customer{

    private String name;
    private char gender;
    private int age;
    private String phone;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Customer() {
//    }

    public Customer(String name, char gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }


}