package com.taylor.LinkedList.Entity;

import java.util.Objects;

public class Celebrity extends People implements Comparable<People> {
    private int id;
    private int age;
    private String name;
    private String nickname;

    public Celebrity() {
    }

    public Celebrity(int id) {
        super(id);
        this.id = id;
    }

    public Celebrity(String name) {
        super(name);
        this.name = name;
    }

    public Celebrity(String name, String nickname) {
        super(name);
        this.name = name;
        this.nickname = nickname;
    }

    public Celebrity(int age, String name, String nickname) {
        super(name);
        this.age = age;
        this.name = name;
        this.nickname = nickname;
    }

    public Celebrity(int id, int age, String name, String nickname) {
        super(id, age, name);
        this.id = id;
        this.age = age;
        this.name = name;
        this.nickname = nickname;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Celebrity{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Celebrity celebrity = (Celebrity) o;
        return id == celebrity.id &&
                age == celebrity.age &&
                Objects.equals(name, celebrity.name) &&
                Objects.equals(nickname, celebrity.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, age, name, nickname);
    }
}
