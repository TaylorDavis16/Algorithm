package com.taylor.AlterArray;

public class ArrayAlterTest {
    public static void main(String[] args) {
        Integer[][] a=new Integer[10][3];
        a[1][0]=6;
        a[8][0]=16;
        a[9][2]=666;
        ArrayAlter<Integer> IAlter=new ArrayAlter<>();
        Object[][] aParse=IAlter.toParseArray(a);
        IAlter.showParseArray(aParse);


        ArrayAlter<String> SAlter=new ArrayAlter<>();
        String[][] strings=new String[5][5];
        strings[1][3]="Taylor";
        strings[1][4]="Swift";
        strings[3][1]="Mariah";
        strings[3][2]="Carey";
        Object[][] sParse=SAlter.toParseArray(strings);
        SAlter.showParseArray(sParse);


        ArrayAlter<Double> DAlter=new ArrayAlter<>();
        Double[][] doubles=new Double[6][6];
        doubles[0][1]=0.16;
        doubles[1][2]=1.60;
        doubles[2][3]=16.0;
        doubles[3][4]=160.0;
        doubles[4][5]=1600.0;
        Object[][] dParse=DAlter.toParseArray(doubles);
        DAlter.showParseArray(dParse);
    }
}
