package com.taylor.Hash.Test;


import com.taylor.Hash.HashPeopleTable;
import com.taylor.LinkedList.Entity.Celebrity;
import com.taylor.LinkedList.Entity.Customer;
import com.taylor.LinkedList.Entity.People;
import com.taylor.LinkedList.Entity.PeopleBox;

public class HashPeopleTableTest {
    public static void main(String[] args) {
        HashPeopleTable<People> peopleTable=new HashPeopleTable<>(3);
        HashPeopleTable<Celebrity> celebrityTable=new HashPeopleTable<>(4);
        HashPeopleTable<Customer> customerTable=new HashPeopleTable<>(2);
        for (People person : PeopleBox.peopleBox) {
            peopleTable.add(person);
        }
        for (Celebrity celebrity : PeopleBox.celebrityBox) {
            celebrityTable.add(celebrity);
        }
        for (Customer customer : PeopleBox.customerBox) {
            customerTable.add(customer);
        }
        //---------------------------------------------------
//        peopleTable.traverse();
//        celebrityTable.traverse();
//        customerTable.traverse();
        System.out.println(peopleTable.getById(5));
        System.out.println(peopleTable.getById(16));
        System.out.println(peopleTable.getByName("E"));
        System.out.println("--------------------------");
        System.out.println(celebrityTable.getById(13));
        System.out.println(celebrityTable.getByName("JayChou"));
        System.out.println(celebrityTable.getByName("xxx"));
        System.out.println("--------------------------");
        System.out.println(customerTable.getById(34));
        System.out.println(customerTable.getById(32));
        System.out.println(customerTable.getByName("Amy"));
        System.out.println("--------------------------");

    }
}
