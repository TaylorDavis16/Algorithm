package com.taylor.Tree.Zip;

public class Datum implements Comparable<Datum>{
    private byte character;
    private int number;
    private StringBuilder builder;

    public Datum() {
    }

    public Datum(byte character) {
        this.character = character;
    }

    public Datum(int number) {
        this.number = number;
    }

    public Datum(byte character, int number) {
        builder=new StringBuilder();
        this.character = character;
        this.number = number;
    }

    public int getCharacter() {
        return character;
    }

    public void setCharacter(byte character) {
        this.character = character;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(Datum o) {
        return this.number - o.number;
    }

    public String getCode() {
        return builder.toString();
    }

    public StringBuilder getBuilder(){
        return builder;
    }

    @Override
    public String toString() {
        if (number==0)
            return null;
        if (builder==null)
            return character+"="+number;
        return character+"-"+getCode()+"="+number;
    }
}
