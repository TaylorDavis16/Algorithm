package com.taylor.LinkedList.List;


import com.taylor.LinkedList.Entity.Josephus;

/**
 * Unfinished!
 */
public class CirclePeopleList implements PeopleList<Josephus> {
    private Josephus head;
    private int size;

    public CirclePeopleList() {
        head = new Josephus(0);
        size=0;
    }

    public CirclePeopleList(int[] list) {
        if (list!=null){
            head = new Josephus(list[0]);
            head.setNextPerson(head);
            size=list.length;
            for (int i=list.length-1;i>0;i--) {
                Josephus temp= (Josephus) head.getNextPerson();
                Josephus josephus=new Josephus(list[i]);
                head.setNextPerson(josephus);
                josephus.setNextPerson(temp);
            }
        }
    }

    public void simulate(int start, int interval){
        Josephus[] result=this.removeAll(start,interval);
        for (Josephus josephus : result) {
            System.out.println(josephus);
        }
    }

    public void simulate(int interval){
        simulate(1,interval);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Josephus person) {
        if (person==null)
            return false;
        Josephus temp=head;

        return false;
    }

    @Override
    public Josephus remove() {
        if (size==0)
            return null;
        Josephus result= (Josephus) head.getNextPerson();
        if (result==head){
            size--;
            return head;
        }

        head.setNextPerson(head.getNextPerson().getNextPerson());
        size--;
        return result;
    }

    public Josephus[] removeAll(int start,int interval){
        if (interval<0)
            throw new RuntimeException("Interval less than 0!");
        if (start<1 || start>size)
            throw new RuntimeException("Start point beyond range!");
        Josephus[] results=new Josephus[size];
        int index=0;
        if (start==1){
            start+=size;
        }
        while (start>2){
            head= (Josephus) head.getNextPerson();
            start--;
        }
        Josephus first= (Josephus) head.getNextPerson();
        results[index++]=first;
        head.setNextPerson(first.getNextPerson());
        first.setNextPerson(null);
        size--;
        Josephus temp=head;
        while (!isEmpty()){
            interval%=size;
            int i=interval;
            while (i>0){
                temp= (Josephus) temp.getNextPerson();
                i--;
            }
            Josephus result= (Josephus) temp.getNextPerson();
            results[index++]=result;
            temp.setNextPerson(result.getNextPerson());
            result.setNextPerson(null);
            size--;
        }
        return results;
    }

    @Override
    public Josephus remove(int index) {
        return null;
    }

    @Override
    public Josephus remove(String name) {
        return null;
    }

    @Override
    public Josephus get() {
        return null;
    }

    @Override
    public Josephus get(int id) {
        return null;
    }

    @Override
    public Josephus get(String name) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(String name) {
        return false;
    }

    @Override
    public boolean contains(int id) {
        return false;
    }
}
