package com.taylor.Recursion.maze;

public class Test {
    public static void main(String[] args) {
        Maze maze1=new Maze(8,20);
        Maze maze2=new Maze(8,20);
        maze1.setValue(1,5,'+');
        maze1.setValue(2,6,'+');
        maze1.setValue(3,7,'+');
        maze1.setValue(3,8,'+');
        maze1.setValue(4,10,'+');
        maze1.setValue(3,10,'+');
        maze1.setValue(2,10,'+');
        maze1.setValue(2,16,'+');
        maze1.setValue(2,17,'+');
        maze1.setValue(3,17,'+');
        maze1.show();
        System.out.println("-----------------------------");
        PathInvestigator investigator=new PathInvestigator(maze1.getMaze(),3,16);
        if (!investigator.smartDetect(1,1))
            System.out.println("Fail to detect this path!");
        maze1.show();
    }
}
