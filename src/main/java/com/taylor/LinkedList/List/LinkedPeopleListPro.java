package com.taylor.LinkedList.List;




import com.taylor.LinkedList.Entity.People;

import java.io.*;

public class LinkedPeopleListPro<T extends People> implements PeopleList<T> {
    private Node<T> head;
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<E> implements Serializable{
        E person;
        Node<E> pre;
        Node<E> next;

        public Node(Node<E> pre, E person, Node<E> next) {
            this.person = person;
            this.pre = pre;
            this.next = next;
        }
    }

    public LinkedPeopleListPro() {
        People head=new People(0, 0, "Head");
        this.head = new Node(null, head ,null);
        size=0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void linkedFirst(T t){

    }


    @Override
    public boolean add(T person) {
        if (person==null)
            return false;
        Node<T> temp = head;
        if (person.getId()<0 || "Head".equals(person.getName()))
            return false;
        if (person.getId()==0){
            if (last==null){
                person.setId(1);
                head.next= new Node<>(head,person,null);
                first=head.next;
                last=first;
            }
            else{
                person.setId(last.person.getId()+1);
                last.next=new Node<>(last,person,null);
                last=last.next;
            }
        }
        else{//id>0
            if (last==null){//No element
                head.next= new Node<>(head,person,null);
                first=head.next;
                last=first;
            }
            else {
                while (temp.next!=null){
                    T nextPerson=temp.next.person;
                    if (nextPerson.compareTo(person)==0){
                        return false;
                    }
                    if (nextPerson.compareTo(person)<0){
                        temp = temp.next;
                    }
                    else break;
                }
                if (temp.equals(head)){
                    Node<T> next=temp.next;
                    temp.next=new Node<>(temp,person,next);
                    first=temp.next;
                    if (next!=null){
                        next.pre=first;
                    }
                    else last=first;
                }
                else if (temp.equals(first)){
                    Node<T> next=temp.next;
                    temp.next=new Node<>(temp,person,next);
                    if (next!=null){
                        next.pre=first.next;
                    }
                    else last=first.next;
                }
                else if (temp.equals(last)){
                    Node<T> newNode=new Node<>(temp,person,temp.next);
                    temp.next=newNode;
                    last=newNode;
                }
                else {
                    Node<T> next=temp.next;
                    temp.next= new Node<>(temp,person,next);
                    if (temp.next.next.equals(last))
                        last.pre=temp.next;
                }
            }
        }
        size++;
        return true;
    }


    public boolean addAll(LinkedPeopleListPro<? extends T> list) throws IOException, ClassNotFoundException {
        if (list==null)
            return false;
        if (this.getClass()!=list.getClass())
            return false;
        LinkedPeopleListPro<? extends T> copy = list.copy();
        while (!copy.isEmpty()){
            this.add(copy.removeFirst());
        }
        return true;
    }

    public boolean addFirst(T person){
        if (person==null || person.getId()<0 || "Head".equals(person.getName()) || this.contains(person.getId()))
            return false;
        Node<T> newNode=new Node<>(head,person,first);
        head.next=newNode;
        if (first==null){
            first=newNode;
            last=newNode;
        }
        else first.pre=newNode;
        size++;
        return true;
    }

    @Override
    public T remove() {
        System.out.println(head.next==null);
        if (size==0 && head.next==null)
            return null;
        T person=last.person;
        if (last.equals(first)){
            first=null;
            last=null;
            head.next=null;
        }
        else {
            last=last.pre;
            last.next=null;
        }
        size--;
        return person;
    }

    @Override
    public T remove(int id) {
        Node<T> temp=head;
        if (id<=0)
            return null;
        while (temp.next!=null){
            if (temp.next.person.getId()==id){
                return getT(temp);
            }
            temp=temp.next;
        }
        return null;
    }

    @Override
    public T remove(String name) {
        if ("Head".equals(name))
            return null;
        Node<T> temp=head;
        while (temp.next!=null){
            if (name==null){
                if (temp.next.person.getName()==null){
                    return getT(temp);
                }
            }
            else if (name.equals(temp.next.person.getName())){
                return getT(temp);
            }
            temp = temp.next;
        }
        return null;
    }

    public T removeFirst(){
        if (size==0 && first==null)
            return null;
        Node<T> temp=head;
        return temp.next==null? null : getT(temp);
    }

    private T getT(Node<T> temp) {//Remove the person who next to temp
        T result= temp.next.person;
        Node<T> after=temp.next.next;
        temp.next=after;
        if (after!=null){
            after.pre=temp;
        }
        last =temp.equals(head) ? null : temp;
        first = temp.equals(head) ? null : first;
        size--;
        return result;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(T[] a){
        T[] peopleArray=(T[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(),size);//Make a new list of celebrities
        Node<T> temp= head.next;
        int i=0;
        while (temp!=null){
            peopleArray[i++]=temp.person;
            temp= temp.next;
        }
        return peopleArray;
    }

    @Override
    public T get() {
        if (size==0 && head.next==null)
            return null;
        else return last.person;
    }

    @Override
    public T get(int id) {
        if (id<=0)
            return null;
        Node<T> temp=head;
        while (temp.next!=null){
            if (temp.next.person.getId()==id)
                return temp.next.person;
            temp =  temp.next;
        }
        return null;
    }

    private Node<T> getCopyLast(LinkedPeopleListPro<T> copy){
        Node<T> temp=copy.head;
        while (temp.next!=null){
            temp =  temp.next;
        }
        if (temp.equals(copy.head))
            return copy.head;
        else return temp;
    }

    @Override
    public T get(String name) {
        if ("Head".equals(name))
            return null;
        Node<T> temp=head;
        while (temp.next!=null){
            if (name==null){
                if (temp.next.person.getName()==null)
                    return temp.next.person;
            }
            else if (name.equals(temp.next.person.getName()))
                return temp.next.person;
            temp = temp.next;
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
        Node<T> temp=head;
        while (temp.next!=null){
            if (name==null){
                if (temp.next.person.getName()==null)
                    return true;
            }
            else if (name.equals(temp.next.person.getName()))
                return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
    public boolean contains(int id) {
        if (id<=0)
            return false;
        Node<T> temp=head;
        while (temp.next!=null){
            if (temp.next.person.getId()==id)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public void show(){
        Node<T> temp=first;
        System.out.println("----------------------------");
        while (temp!=null){
            T person= temp.person;
            System.out.println(person.toString());
            temp=temp.next;
        }
    }


    public void reverse(){
        if (head.next!=null && head.next.next!=null){
            Node<T> temp=head.next;
            temp.pre=null;
            while (temp.next!=null){
                Node<T> value=temp;
                Node<T> box=temp.next;
                temp=temp.next;//B
                value.next=value.pre;
                value.pre=box;
            }
            temp.next=temp.pre;
            temp.pre=head;
            head.next=temp;

            temp=first;
            first=last;
            last=temp;
        }
    }

    private Node<T> reverseFromHead(Node<T> node){
        if (node==null || node.next==null)
            return node;
        Node<T> temp= node.next;
        node.next=null;
        Node<T> result=reverseFromHead(temp);
        temp.next=result;
        return result;
    }


    public LinkedPeopleListPro<T> copy() throws IOException, ClassNotFoundException {
        LinkedPeopleListPro<T> copy=new LinkedPeopleListPro<>();
        if (size==0 && first==null && last==null)
            return copy;
        Node<T> temp=head.next;
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        while (temp!=null){
            oos.writeObject(temp);
            temp=temp.next;
            copy.size++;
        }
        ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois=new ObjectInputStream(bis);
        Node<T> newNode= (Node<T>) ois.readObject();
        copy.head.next=newNode;
        newNode.pre=copy.head;
        copy.first=newNode;
        copy.last=getCopyLast(copy);
        return copy;
    }

    private void clearFirst(){
        first.pre=null;
        first.next=null;
    }

    private void  clearLast(){
        last.pre=null;
        last.next=null;
    }


}

