package com.taylor.AlterArray;

public class ArrayAlter <T>{
    public Object[][] toParseArray(T[][] array){
        int number=0;
        Object o=0;
        int row=array.length;
        int column=array[0].length;
        Object[][] result=new Object[row*column+1][3];//Max length=row*column
        int k=1;
        result[0][0]=row;
        result[0][1]=column;
        for(int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                result[k][0]=i;
                result[k][1]=j;
                result[k][2] = (array[i][j] != null && !o.equals(array[i][j])) ? array[i][j] : null;
                k++;
                number++;
            }
        }
        result[0][2]=number;
        return result;
    }

    public void showParseArray(Object[][] array){
        int row=(int)array[0][0]*(int)array[0][1];
        System.out.println("Row:"+array[0][0]+" Column:"+array[0][1]+" Number:"+array[0][2]);
        for(int i=1;i<=row;i++){
            if (array[i][2]==null)
                continue;
                System.out.println("["+array[i][0]+","+array[i][1]+"]="+(T)array[i][2]);
        }
        System.out.println("-----------------------------------");
        System.out.println("End");
    }

//    public T[][] toFormalArray(Object[][] array){
//        int row=(int)array[0][0];
//        int column=(int)array[0][1];
//        int number=(int)array[0][2];
//        System.out.println(row+" "+column+" "+number);
//        System.out.println(array.length);
//        Object[][] result=new Object[row][column];
//        ArrayList<T> arrayList=new ArrayList<>(row);
//        ArrayList<T[]> list=new ArrayList<>(column);
//        for (int i=1;i<array.length-1;i++){
//            System.out.println(result[(int)array[i][0]][(int)array[i][1]]);
////                        =(T)array[i][2];
//        }
//        return (T[][])result;
//    }

    public void showFormalArray(T[][] array){
        for (T[] t1 :array){
            for(T t2:t1){
                System.out.printf("%10s",t2);
            }
            System.out.println();
        }
    }
}
