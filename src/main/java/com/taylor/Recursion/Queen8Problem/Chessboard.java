package com.taylor.Recursion.Queen8Problem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * chessboard(the array) the index represents row, the respective value represents column
 */
public class Chessboard {
    private int MAX_QUEEN_NUMBER;
    private int[] chessboard;
    private ArrayList<int[]> resultBox;
    private int judgeTime;
    private int checkTime;

    public Chessboard() {
        this(8);
    }

    public Chessboard(int MAX_QUEEN_NUMBER) {
        this.MAX_QUEEN_NUMBER = MAX_QUEEN_NUMBER;
        chessboard=new int[MAX_QUEEN_NUMBER];
        resultBox=new ArrayList<>(this.MAX_QUEEN_NUMBER*20);
        judgeTime=0;
        checkTime=0;
    }

    private void check(int queen){//Queen represents the queen th queen is being put into the chessboard
        checkTime++;
        if (queen>MAX_QUEEN_NUMBER){
            System.out.println("Yes!!!!!!!!!!!!!1");
//            resultBox.add(chessboard.clone());
            return;
        }
        for (int i=0;i<MAX_QUEEN_NUMBER;i++){//MAX_QUEEN_NUMBER=The number of column
            chessboard[queen-1]=i+1;
            System.out.println(Arrays.toString(chessboard));
            if (judge(queen)){
                check(queen+1);
            }
        }
    }

    private boolean judge(int queen){//Value between 1 and 8
        judgeTime++;
        for (int i=0;i<queen-1;i++){//If horizontal and vertical interval are the same, then they are in the diagonal
            if (chessboard[i]==chessboard[queen-1] || Math.abs(queen-1-i)==Math.abs(chessboard[queen-1]-chessboard[i]))
                return false;
        }
        return true;
    }

    public void operator(){
        check(1);
//        resultBox.forEach(ints -> System.out.println(Arrays.toString(ints)));
        System.out.println("Number of results: "+resultBox.size());
        System.out.println("Check "+checkTime+" times!");
        System.out.println("Judge "+judgeTime+" times!");
    }

    public ArrayList<int[]> getResultBox() {
        return resultBox;
    }
}
