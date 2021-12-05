package com.taylor.LinkedList.List;//package LinkedList.List;
//
//import LinkedList.Zip.Celebrity;
//
//public class CelebrityList extends LinkedPeopleList<Celebrity> {
//    private Celebrity head;
//    private int size;
//
//    public CelebrityList() {
//        head=new Celebrity(0,0,"Head","Head");
//        size=0;
//    }
//
//    @Override
//    public int size() {
//        return this.size;
//    }
//
//    @Override
//    public boolean add(Celebrity person) {
//        if (person==null)
//            return false;
//        Celebrity temp = head;
//        if (person.getId()<0)
//            return false;
//        if (person.getId()==0){
//            while (temp.getNextPerson()!=null){
//                temp=(Celebrity) temp.getNextPerson();
//            }
//            int id=temp.getId()+1;
//            person.setId(id);
//            size++;
//            temp.setNextPerson(person);
//            return true;
//        }
//
//        while (temp.getNextPerson()!=null){
//            if (temp.getNextPerson().getId()==person.getId()){
//                return false;
//            }
//            if (temp.getNextPerson().getId()<person.getId()){
//                temp= (Celebrity) temp.getNextPerson();
//            }
//            else break;
//        }
//        Celebrity next= (Celebrity) temp.getNextPerson();
//        temp.setNextPerson(person);
//        person.setNextPerson(next);
//        size++;
//        return true;
//    }
//
//
////    public <T extends PeopleList<Celebrity>> boolean addAll(T list) {
////        if (list==null)
////            return false;
////        if (this.getClass()!=list.getClass())
////            return false;
////        CelebrityList copy = list.copy();
////        while (!copy.isEmpty()){
////            this.add(copy.reverseRemove());
////        }
////        return true;
////    }
//
//    private boolean addFirst(Celebrity person){
//        if (person==null || person.getId()<=0)
//            return false;
//        Celebrity temp= (Celebrity) head.getNextPerson();
//        head.setNextPerson(person);
//        person.setNextPerson(temp);
//        size++;
//        return true;
//    }
//
//    @Override
//    public Celebrity remove() {
//        Celebrity temp=head;
//        Celebrity before=temp;
//        while (temp.getNextPerson()!=null){
//            before= temp;
//            temp= (Celebrity) temp.getNextPerson();
//        }
//        if (temp.equals(head))
//            return null;
//        else {
//            before.setNextPerson(null);
//            size--;
//            return temp;
//        }
//    }
//
//    @Override
//    public Celebrity remove(int id) {
//        Celebrity temp=head;
//        if (id<=0)
//            return null;
//        while (temp.getNextPerson()!=null){
//            if (temp.getNextPerson().getId()==id){
//                Celebrity result= (Celebrity) temp.getNextPerson();
//                temp.setNextPerson(temp.getNextPerson().getNextPerson());
//                size--;
//                return result;
//            }
//
//            temp= (Celebrity) temp.getNextPerson();
//        }
//        return null;
//    }
//
//    @Override
//    public Celebrity remove(String name) {
//        if ("Head".equals(name))
//            return null;
//        Celebrity temp=head;
//        while (temp.getNextPerson()!=null){
//            if (name==null){
//                if (temp.getNextPerson().getName()==null){
//                    Celebrity result = (Celebrity) temp.getNextPerson();
//                    temp.setNextPerson(result.getNextPerson());
//                    size--;
//                    return result;
//                }
//            }
//            else if (name.equals(temp.getNextPerson().getName())){
//                Celebrity result = (Celebrity) temp.getNextPerson();
//                temp.setNextPerson(result.getNextPerson());
//                size--;
//                return result;
//            }
//            temp= (Celebrity) temp.getNextPerson();
//        }
//        return null;
//    }
//
//    private Celebrity reverseRemove(){
//        Celebrity temp=null;
//        if (head.getNextPerson()!=null){
//            temp= (Celebrity) head.getNextPerson();
//            head.setNextPerson(temp.getNextPerson());
//            size--;
//        }
//        return temp;
//    }
//
//    public Celebrity[] toArray(){//Core. Real copy process.
//        Celebrity[] celebrities=new Celebrity[size];//Make a new list of celebrities
//        Celebrity[] formal=new Celebrity[size];//Keep those previous celebrities
//        int i=0;
//        while (!this.isEmpty()){
//            Celebrity celebrity=this.reverseRemove();
//            formal[i]=celebrity;
//            celebrities[i++]=new Celebrity(celebrity.getId(),celebrity.getAge(),celebrity.getName(),celebrity.getNickname());
//        }
//        while (i>0){
//            this.addFirst(formal[--i]);
//        }
//        return celebrities;
//    }
//
//    @Override
//    public Celebrity get() {
//        Celebrity temp=head;
//        while (temp.getNextPerson()!=null){
//            temp = (Celebrity) temp.getNextPerson();
//        }
//        if (temp.equals(head))
//            return null;
//        else return temp;
//    }
//
//    @Override
//    public Celebrity get(int id) {
//        if (id<=0)
//            return null;
//        Celebrity temp=head;
//        while (temp.getNextPerson()!=null){
//            if (temp.getNextPerson().getId()==id)
//                return (Celebrity) temp.getNextPerson();
//            temp= (Celebrity) temp.getNextPerson();
//        }
//        return null;
//    }
//
//    @Override
//    public Celebrity get(String name) {
//        if ("Head".equals(name))
//            return null;
//        Celebrity temp=head;
//        while (temp.getNextPerson()!=null){
//            if (name==null){
//                if (temp.getNextPerson().getName()==null)
//                    return (Celebrity) temp.getNextPerson();
//            }
//            else if (name.equals(temp.getNextPerson().getName()))
//                return (Celebrity) temp.getNextPerson();
//            temp= (Celebrity) temp.getNextPerson();
//        }
//        return null;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return size==0;
//    }
//
//    @Override
//    public boolean contains(String name) {
//        if ("Head".equals(name))
//            return false;
//        Celebrity temp=head;
//        while (temp.getNextPerson()!=null){
//            if (name==null){
//                if (temp.getNextPerson().getName()==null)
//                    return true;
//            }
//            else if (name.equals(temp.getNextPerson().getName()))
//                return true;
//            temp= (Celebrity) temp.getNextPerson();
//        }
//        return false;
//    }
//
//    @Override
//    public boolean contains(int id) {
//        if (id<=0)
//            return false;
//        Celebrity temp=head;
//        while (temp.getNextPerson()!=null){
//            if (temp.getNextPerson().getId()==id)
//                return true;
//            temp= (Celebrity) temp.getNextPerson();
//        }
//        return false;
//    }
//
//    public void show(){
//        Celebrity temp=head;
//        while (temp.getNextPerson()!=null){
//            temp= (Celebrity) temp.getNextPerson();
//            System.out.println(temp.toString());
//        }
//    }
//
////    public CelebrityList reverse(){
////        CelebrityList list=new CelebrityList();
////        while (this.head.getNextPerson()!=null){
////            Celebrity temp= (Celebrity) list.head.getNextPerson();
////            Celebrity value= (Celebrity) this.head.getNextPerson();
////            this.head.setNextPerson(value.getNextPerson());
////            list.head.setNextPerson(value);
////            value.setNextPerson(temp);
////            list.size++;
////        }
////        return list;
////    }
//
//
//    public CelebrityList copy() {
//        int i=size;
//        Celebrity[] celebrities=this.toArray();
//        CelebrityList list1=new CelebrityList();
//        while (i>0){
//            list1.addFirst(celebrities[--i]);
//        }
//        return list1;
//    }
//
//}
