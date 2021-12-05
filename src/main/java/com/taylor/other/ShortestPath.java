package com.taylor.other;
//Failed
public class ShortestPath {
    private int block;
    private int path;
    int[][] pathBox;

    public ShortestPath(int block, int path) {
        this.block = block;
        this.path = path;
        pathBox=new int[block][block-1];
    }

    public static void main(String[] args) {
        ShortestPath path=new ShortestPath(3,6);

    }


    public void addPath(int block1,int block2,int time){
        pathBox[block1][block2]=time;
        path++;
    }

    public void findShortestPath(){
        for (int i=0;i<pathBox.length;i++){
        }
    }
}
