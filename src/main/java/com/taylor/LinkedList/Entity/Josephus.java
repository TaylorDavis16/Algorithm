package com.taylor.LinkedList.Entity;

public class Josephus extends People{
    private int index;
    public Josephus() {
    }

    public Josephus(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Josephus{" +
                "index=" + index +
                '}';
    }
}
