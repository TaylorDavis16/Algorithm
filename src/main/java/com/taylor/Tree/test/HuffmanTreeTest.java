package com.taylor.Tree.test;


import com.taylor.LinkedList.Entity.Celebrity;
import com.taylor.Tree.HuffmanTree;

public class HuffmanTreeTest {
    public static void main(String[] args) {
        Integer[] integers={13,7,8,3,29,6,1};
        HuffmanTree<Integer> integerHuffmanTree=new HuffmanTree<Integer>(integers, Integer::sum);
        integerHuffmanTree.build();
        integerHuffmanTree.preOrderTraverse();

        Celebrity c1=new Celebrity(13);
        Celebrity c2=new Celebrity(7);
        Celebrity c3=new Celebrity(8);
        Celebrity c4=new Celebrity(3);
        Celebrity c5=new Celebrity(29);
        Celebrity c6=new Celebrity(6);
        Celebrity c7=new Celebrity(1);
        Celebrity[] celebrities={c1,c2,c3,c4,c5,c6,c7};
        HuffmanTree<Celebrity> celebrityHuffmanTree=new HuffmanTree<Celebrity>(celebrities, (t1, t2) -> new Celebrity(t1.getId()+t2.getId()));
        celebrityHuffmanTree.build();
        celebrityHuffmanTree.preOrderTraverse();

    }
}
