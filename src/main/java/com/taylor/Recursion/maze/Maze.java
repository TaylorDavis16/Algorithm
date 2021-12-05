package com.taylor.Recursion.maze;

public class Maze {
    private int length;
    private int width;
    private char[][] maze;

    public Maze(int length, int width) {
        if (length<1 || width<1)
            throw new RuntimeException("Length<1 or Width<1");
        this.length = length;
        this.width = width;
        maze =new char[length][width];
        for (int i=0;i<length;i++)
            for (int j=0;j<width;j++){
                if (i==0 || i==length-1 || j==0 || j==width-1)
                    maze[i][j]='+';
                else maze[i][j]='0';
            }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public char[][] getMaze() {
        return maze;
    }

    public void setMaze(char[][] maze) {
        this.maze = maze;
    }

    public void setValue(int x, int y, char value){
        maze[x][y]= (x> maze.length-1 && y> maze[0].length-1) ? maze[maze.length-1][maze[0].length-1] : value;
    }

    public void show(){
        System.out.print("   ");
        for (int i=0;i<width;i++){
            if (i<10)
            System.out.print(i+"  ");
            else System.out.print(i+" ");
        }
        System.out.println();
        for (int i=0;i<length;i++){
            System.out.print(i+"  ");
            for (int j=0;j<width;j++){
                System.out.print(maze[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
