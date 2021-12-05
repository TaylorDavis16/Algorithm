package com.taylor.LinkedList.List;


import com.taylor.LinkedList.Entity.Celebrity;

/**
 * Unfinished!
 */
public class DoublePeopleList implements PeopleList<Celebrity>{
    private Celebrity head;
    private int size;

    public DoublePeopleList() {
        head=new Celebrity(0,0,"Head","Head");
        size=0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(Celebrity person) {
        if (person==null)
            return false;
        Celebrity temp=head;
        if (person.getId()<0)
            return false;
        if (person.getId()==0) {
            while (temp.getNextPerson() != null) {
                temp = (Celebrity) temp.getNextPerson();
            }
            int id=temp.getId()+1;
            person.setId(id);
            person.setPrePerson(temp);
            size++;
            temp.setNextPerson(person);
            return true;
        }
        while (temp.getNextPerson()!=null){
            if (temp.getNextPerson().getId()==person.getId()){
                return false;
            }
            if (temp.getNextPerson().getId()<person.getId()){
                temp= (Celebrity) temp.getNextPerson();
            }
            else break;
        }
        Celebrity next= (Celebrity) temp.getNextPerson();
        temp.setNextPerson(person);
        person.setPrePerson(temp);
        person.setNextPerson(next);
        if (next!=null)
            next.setPrePerson(person);
        size++;
        return true;
    }

    @Override
    public Celebrity remove() {
        Celebrity temp=head;
        Celebrity before=temp;
        while (temp.getNextPerson()!=null){
            before= temp;
            temp= (Celebrity) temp.getNextPerson();
        }
        if (temp.equals(head))
            return null;
        else {
            before.setNextPerson(null);
            size--;
            return temp;
        }
    }


    @Override
    public Celebrity remove(int id) {
        return null;
    }

    @Override
    public Celebrity remove(String name) {
        return null;
    }

    @Override
    public Celebrity get() {
        return null;
    }

    @Override
    public Celebrity get(int id) {
        return null;
    }

    @Override
    public Celebrity get(String name) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
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
