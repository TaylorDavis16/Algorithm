package com.taylor.LinkedList.Entity;

import java.util.Objects;

public class People implements Comparable<People>,java.io.Serializable{
    int id;
    int age;
    String gender;
    String name;
    People nextPerson;
    People prePerson;

    public People() {
    }

    public People(int id) {
        this.id = id;
    }

    public People(String name) {
        this.name = name;
    }

    public People(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People getNextPerson() {
        return nextPerson;
    }

    public void setNextPerson(People nextPerson) {
        this.nextPerson = nextPerson;
    }

    public People getPrePerson() {
        return prePerson;
    }

    public void setPrePerson(People prePerson) {
        this.prePerson = prePerson;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return id == people.id &&
                age == people.age &&
                Objects.equals(name, people.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name);
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(People o) {
        return this.id==o.id ? this.name.compareTo(o.name)==0 ? this.age-o.age : this.name.compareTo(o.name) : this.id-o.id;
    }
}
