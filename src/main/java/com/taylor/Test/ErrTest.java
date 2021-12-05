package com.taylor.Test;

public class ErrTest {
    public static void main(String[] args) {

        printOut("1");
        printErr("a");
        printOut("b");
        printErr("c");
        printOut("d");
        printOut("2");
    }
    public synchronized static void printErr(String string){
        System.err.print(string);
    }
    public synchronized static void printOut(String string){
        System.out.print(string);
    }

}
