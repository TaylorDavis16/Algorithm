package com.taylor.Recursion.HanoiTower;

public class Hanoi {
    int plate;
    int moveTime;
    public Hanoi(int plate) {
        this.plate=plate;
    }
    public void move(){
        if (plate==0){
            System.out.println("There are no plate!");
            return;
        }
        move(plate,1,2,3);
    }

    private void move(int n, int p1, int p2, int p3){
        moveTime++;
        if (n==1){
//            System.out.println("Moving plate from "+p1+" to "+p3);
        }
        else {
            move(n-1,p1,p3,p2);
//            System.out.println("Moving plate from "+p1+" to "+p3);
            move(n-1,p2,p1,p3);
        }
    }

    public int getPlate() {
        return plate;
    }

    public void setPlate(int plate) {
        this.plate = plate;
    }

    public int getMoveTime() {
        return moveTime;
    }

    public void setMoveTime(int moveTime) {
        this.moveTime = moveTime;
    }
}
