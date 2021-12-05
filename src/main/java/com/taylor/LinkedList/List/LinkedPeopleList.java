package com.taylor.LinkedList.List;


import com.taylor.LinkedList.Entity.People;

import java.io.*;

public class LinkedPeopleList<T extends People> implements PeopleList<T> {
    private People head;
    private int size;
    public LinkedPeopleList() {
        head = new People(0,0,"Head");
        size=0;
    }

    @Override
    public int size() {
        return this.size;
    }


    @Override
    public boolean add(T person) {
        if (person==null)
            return false;
        People temp = head;
        if (person.getId()<0)
            return false;
        if (person.getId()==0){
            while (temp.getNextPerson()!=null){
                temp=temp.getNextPerson();
            }
            int id=temp.getId()+1;
            person.setId(id);
            size++;
            temp.setNextPerson(person);
            return true;
        }

        while (temp.getNextPerson()!=null){
            if (temp.getNextPerson().getId()==person.getId()){
                return false;
            }
            if (temp.getNextPerson().getId()<person.getId()){
                temp = temp.getNextPerson();
            }
            else break;
        }
        People next = temp.getNextPerson();
        temp.setNextPerson(person);
        person.setNextPerson(next);
        size++;
        return true;
    }


    public boolean addAll(LinkedPeopleList<? extends T> list) throws IOException, ClassNotFoundException {
        if (list==null)
            return false;
        if (this.getClass()!=list.getClass())
            return false;
        LinkedPeopleList<? extends T> copy = list.copy();
        while (!copy.isEmpty()){
            this.add(copy.reverseRemove());
        }
        return true;
    }

    public boolean addFirst(T person){
        if (person==null || person.getId()<=0)
            return false;
        People temp = head.getNextPerson();
        head.setNextPerson(person);
        person.setNextPerson(temp);
        size++;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove() {
        People temp=head;
        People before=temp;
        while (temp.getNextPerson()!=null){
            before= temp;
            temp = temp.getNextPerson();
        }
        if (temp.equals(head))
            return null;
        else {
            before.setNextPerson(null);
            size--;
            return (T)temp;
        }
    }

    @Override
    public T remove(int id) {
        People temp=head;
        if (id<=0)
            return null;
        while (temp.getNextPerson()!=null){
            if (temp.getNextPerson().getId()==id){
                T result= (T) temp.getNextPerson();
                temp.setNextPerson(temp.getNextPerson().getNextPerson());
                size--;
                return result;
            }

            temp = temp.getNextPerson();
        }
        return null;
    }

    @Override
    public T remove(String name) {
        if ("Head".equals(name))
            return null;
        People temp=head;
        while (temp.getNextPerson()!=null){
            if (name==null){
                if (temp.getNextPerson().getName()==null){
                    T result = (T) temp.getNextPerson();
                    temp.setNextPerson(result.getNextPerson());
                    size--;
                    return result;
                }
            }
            else if (name.equals(temp.getNextPerson().getName())){
                T result = (T) temp.getNextPerson();
                temp.setNextPerson(result.getNextPerson());
                size--;
                return result;
            }
            temp = temp.getNextPerson();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private T reverseRemove(){
        T temp=null;
        if (head.getNextPerson()!=null){
            temp= (T) head.getNextPerson();
            head.setNextPerson(temp.getNextPerson());
            size--;
        }
        return temp;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(T[] a){
        T[] peopleArray=(T[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(),size);//Make a new list of celebrities
        T temp= (T) head.getNextPerson();
        int i=0;
        while (temp!=null){
            peopleArray[i++]=temp;
            temp= (T) temp.getNextPerson();
        }
        return peopleArray;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get() {
        People temp=head;
        while (temp.getNextPerson()!=null){
            temp =  temp.getNextPerson();
        }
        if (temp.equals(head))
            return null;
        else return (T)temp;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int id) {
        if (id<=0)
            return null;
        People temp=head;
        while (temp.getNextPerson()!=null){
            if (temp.getNextPerson().getId()==id)
                return (T) temp.getNextPerson();
            temp =  temp.getNextPerson();
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(String name) {
        if ("Head".equals(name))
            return null;
        People temp=head;
        while (temp.getNextPerson()!=null){
            if (name==null){
                if (temp.getNextPerson().getName()==null)
                    return (T) temp.getNextPerson();
            }
            else if (name.equals(temp.getNextPerson().getName()))
                return (T) temp.getNextPerson();
            temp = temp.getNextPerson();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(String name) {
        if ("Head".equals(name))
            return false;
        People temp=head;
        while (temp.getNextPerson()!=null){
            if (name==null){
                if (temp.getNextPerson().getName()==null)
                    return true;
            }
            else if (name.equals(temp.getNextPerson().getName()))
                return true;
            temp = temp.getNextPerson();
        }
        return false;
    }

    @Override
    public boolean contains(int id) {
        if (id<=0)
            return false;
        People temp=head;
        while (temp.getNextPerson()!=null){
            if (temp.getNextPerson().getId()==id)
                return true;
            temp = temp.getNextPerson();
        }
        return false;
    }

    public void show(){
        People temp=head;
        System.out.println("----------------------------");
        while (temp.getNextPerson()!=null){
            temp= (T) temp.getNextPerson();
            System.out.println(temp.toString());
        }
    }

    public void reverse(){
        if (this.head!=null){
            T result=reverseFromHead((T) this.head.getNextPerson());
            head.setNextPerson(result);
        }
    }

    private T reverseFromHead(T person){
        if (person==null || person.getNextPerson()==null)
            return person;
       T temp= (T) person.getNextPerson();
       person.setNextPerson(null);
       T result=reverseFromHead(temp);
       temp.setNextPerson(person);
       return result;
    }


    public LinkedPeopleList<T> copy() throws IOException, ClassNotFoundException {
        LinkedPeopleList<T> copy=new LinkedPeopleList<>();
        if (this.head.getNextPerson()==null)
            return copy;
        People temp=head.getNextPerson();
        People newList=copy.head;
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        while (temp!=null){
            oos.writeObject(temp);
            temp=temp.getNextPerson();
            copy.size++;
        }
        ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois=new ObjectInputStream(bis);
        T person= (T) ois.readObject();
        newList.setNextPerson(person);
        return copy;
    }
}
