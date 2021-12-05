package com.taylor.Tree.Zip;



import com.taylor.Tree.HuffmanTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Zip {

    public static void compress(String string){
        if (string==null || string.length()==0)
            return;
        byte[] bytes = string.getBytes();
        Map<Byte,Integer> map=new HashMap<>(100);
        for (byte b:bytes){
            Integer number = map.get(b);
            map.put(b,number==null ? 1 : number+1);
        }

        Set<Map.Entry<Byte, Integer>> entries = map.entrySet();
        Datum[] data=new Datum[entries.size()];
        int i=0;
        for (Map.Entry<Byte, Integer> entry : entries) {
            data[i++]=new Datum(entry.getKey(),entry.getValue());
        }
        HuffmanTree<Datum> huffmanTree=new HuffmanTree<Datum>(data,((t1, t2) -> new Datum(t1.getNumber()+t2.getNumber())));
        huffmanTree.build();
        huffmanTree.preOrderTraverse();
        ArrayList<String> result = huffmanTree.preOrderSaveData(new Predicate<Datum>() {
            @Override
            public boolean test(Datum datum) {
                return datum.getCharacter() != 0;
            }
        }, new Consumer<Datum>() {
            @Override
            public void accept(Datum datum) {
                datum.getBuilder().append(0);
            }
        }, new Consumer<Datum>() {
            @Override
            public void accept(Datum datum) {
                datum.getBuilder().append(1);
            }
        });
        System.out.println(result);
    }

//    public static String decompress(String string){
//
//    }
}
