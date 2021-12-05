package com.taylor.Recursion.maze;

//Still need to improve
public class PathInvestigator {
    private char[][] maze;
    private int endX;
    private int endY;

    public PathInvestigator(char[][] maze, int endX, int endY) {
        this.maze =maze;
        this.endX = endX;
        this.endY = endY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public char[][] getMaze() {
        return maze;
    }

    public void setMaze(char[][] maze) {
        this.maze = maze;
    }

    public boolean detect(int x, int y){
        if (x<1 || y<1 || x>maze.length-1 || y> maze[0].length-1)
            return false;
        if (maze[endX][endY]== 'P')
            return true;
        if (maze[x][y]=='0'){
            maze[x][y]='P';
            if (detect(x,y-1)){//left
                return true;
            }
            else if (detect(x-1,y)){//up
                return true;
            }
            else if (detect(x+1,y)){//down
                return true;
            }
            else if (detect(x,y+1)){//right
                return true;
            }
            else{
                maze[x][y]='X';
                return false;
            }
        }
        else return false;
    }

    public boolean smartDetect(int x, int y){//x,y represent the beginning the coordinate of starting point
        //Strategy: down -> right -> left -> up
        if (x<1 || y<1 || x>maze.length-1 || y> maze[0].length-1)
            return false;
        if (maze[endX][endY]== '-')
            return true;
        if (maze[x][y]=='0'){
            maze[x][y]='-';
            //Insert algorithm to define searching direction
            boolean result=false;
            if (endX<x){//上面
                if (endY<y){

                    if (smartDetect(x,y-1)){//left
                        return true;
                    }
                    else if (smartDetect(x-1,y)){//up
                        return true;
                    }
                    else if (smartDetect(x+1,y)){//down
                        return true;
                    }
                    else if (smartDetect(x,y+1)){//right
                        return true;
                    }
                    else{
                        maze[x][y]='X';
                        return false;
                    }
                }
                else if (endY==y){
                    if (smartDetect(x-1,y)){//up
                        return true;
                    }else if (smartDetect(x,y-1)){//left
                        return true;
                    }
                    else if (smartDetect(x,y+1)){//right
                        return true;
                    }
                    else if (smartDetect(x+1,y)){//down
                        return true;
                    }
                    else{
                        maze[x][y]='X';
                        return false;
                    }
                }
                else {//endY>y
                    if (smartDetect(x,y+1)){//right
                        return true;
                    }
                    else if (smartDetect(x-1,y)){//up
                        return true;
                    }
                    else if (smartDetect(x+1,y)){//down
                        return true;
                    }
                    else if (smartDetect(x,y-1)){//left
                        return true;
                    }
                    else{
                        maze[x][y]='X';
                        return false;
                    }
                }
            }
            else if (endX==x){//同一行
                if (endY<y){
                    if (smartDetect(x,y-1)){//left
                        return true;
                    }
                    else if (smartDetect(x-1,y)){//up
                        return true;
                    }
                    else if (smartDetect(x+1,y)){//down
                        return true;
                    }
                    else if (smartDetect(x,y+1)){//right
                        return true;
                    }
                    else{
                        maze[x][y]='X';
                        return false;
                    }
                }
                else if (endY==y)
                    return true;
                else {
                    if (smartDetect(x,y+1)){//right
                        return true;
                    }
                    else if (smartDetect(x-1,y)){//up
                        return true;
                    }
                    else if (smartDetect(x+1,y)){//down
                        return true;
                    }
                    else if (smartDetect(x,y-1)){//left
                        return true;
                    }
                    else{
                        maze[x][y]='X';
                        return false;
                    }
                }
            }
            else {//endX>x 下面
                if (endY>y){
                    if (smartDetect(x,y+1)){//right
                        return true;
                    }
                    else if (smartDetect(x+1,y)){//down
                        return true;
                    }
                    else if (smartDetect(x-1,y)){//up
                        return true;
                    }
                    else if (smartDetect(x,y-1)){//left
                        return true;
                    }
                    else{
                        maze[x][y]='X';
                        return false;
                    }
                }
                else if (endY==y){
                    if (smartDetect(x+1,y)){//down
                        return true;
                    }
                    else if (smartDetect(x,y-1)){//left
                        return true;
                    }
                    else if (smartDetect(x,y+1)){//right
                        return true;
                    }
                    else if (smartDetect(x-1,y)){//up
                        return true;
                    }
                    else{
                        maze[x][y]='X';
                        return false;
                    }
                }
                else {//endY<y
                    if (smartDetect(x,y-1)){//left
                        return true;
                    }
                    else if (smartDetect(x+1,y)){//down
                        return true;
                    }
                    else if (smartDetect(x,y+1)){//right
                        return true;
                    }
                    else if (smartDetect(x-1,y)){//up
                        return true;
                    }
                    else{
                        maze[x][y]='X';
                        return false;
                    }
                }
            }
        }
        else return false;
    }
}
