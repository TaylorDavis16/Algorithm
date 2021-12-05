package com.taylor.LinkedList.List;


import com.taylor.LinkedList.Entity.People;

public interface PeopleList<E extends People>{

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    int size();
    /**
     * A
     * @param person The person you want to add into
     * @return True if operation successfully, false otherwise
     */
    boolean add(E person);

    /**
     * Remove the last person of list
     * @return The person if it exist, or null otherwise
     */
    E remove();

//    /**
//     * Adding all the elements of other list to this list
//     * @param list Other list
//     * @param <T> The list extends from PeopleList
//     * @return True if operation successful, false otherwise
//     */
//    default <T extends PeopleList<E>> boolean addAll(T list){
//        return false;
//    }

    /**
     * Remove the person out of list according to id
     * @param id The id of this person
     * @return The person if it exist, or null otherwise
     */
    E remove(int id);

    /**
     * Remove the person out of list according to name
     * @param name The name of this person
     * @return The person if it exist, or null otherwise
     */
    E remove(String name);

    /**
     * Get the first person from this list
     * @return This person if founded, or null otherwise
     */
    E get();

    /**
     * Get a certain person by his/her id
     * @param id This person's id
     * @return This person if founded, or null otherwise
     */
    E get(int id);

    /**
     * Get a certain person by his/her name
     * @param name This person's name
     * @return This first person in this list if founded, or null otherwise
     */
    E get(String name);

    /**
     * To check if this list is empty
     * @return True if it is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * To check if this list contains a certain person
     * @param name The person's name to be checked
     * @return True if it contains this person, false otherwise
     */
    boolean contains(String name);

    /**
     * To check if this list contains a certain person
     * @param id The person's id to be checked
     * @return True if it contains this person, false otherwise
     */
    boolean contains(int id);

//    /**
//     * Reverse the list
//     * @return True if reverse successfully, false otherwise
//     */
//    <T extends PeopleList<E>> PeopleList<E> reverse(T list);
//
//    /**
//     * Copy a list exact the same like this
//     * @return The copy one
//     */
//    <T extends PeopleList<E>> PeopleList<E> copy(T list);

}
