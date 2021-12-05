package com.taylor.Hash;


import com.taylor.LinkedList.Entity.People;
import com.taylor.LinkedList.List.LinkedPeopleList;

public class HashPeopleTable<T extends People> {
    private LinkedPeopleList<T>[] peopleLists;
    private int size;
    private int number=0;

    public HashPeopleTable(int size) {
        this.size = size;
        peopleLists=new LinkedPeopleList[size];
        for (int i=0;i<size;i++)
            peopleLists[i]=new LinkedPeopleList<>();
    }

    public void traverse(){
        for (LinkedPeopleList<T> peopleList : peopleLists) {
            peopleList.show();
        }
    }

    public void add(T t){
        int listNo=hashValue(t.getId());
        peopleLists[listNo].add(t);
        number++;
    }

    public T getById(int id){
        int listNo=hashValue(id);
        return peopleLists[listNo].get(id);
    }

    public T getByName(String name){
        for (LinkedPeopleList<T> peopleList : peopleLists) {
            if (peopleList.contains(name))
                return peopleList.get(name);
        }
        return null;
    }

    public int hashValue(int id){
        return id%size;
    }

    public int getNumber() {
        return number;
    }
}
