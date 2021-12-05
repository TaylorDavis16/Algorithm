package com.taylor.LinkedList.Entity;

import java.util.Calendar;
import java.util.Objects;

public class Customer extends People {
    private int id;
    private int age;
    private String name;
    private String gender;
    private double balance;
    private Calendar birthday;

    public Customer() {
        super();
    }

    public Customer(int id) {
        super(id);
        this.id=id;
    }

    public Customer(String name) {
        super(name);
        this.name=name;
    }

    public Customer(int id, int age, String name) {
        super(id, age, name);
        this.id=id;
        this.age=age;
        this.name=name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", balance=" + balance +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                age == customer.age &&
                name.equals(customer.name) &&
                gender.equals(customer.gender) &&
                birthday.equals(customer.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, age, name, gender, birthday);
    }
}
