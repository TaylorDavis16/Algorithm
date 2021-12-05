package com.taylor.LinkedList.List;

public interface List<E> {
    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    int size();
    /**
     * A
     * @param e The element you want to add into
     * @return True if operation successfully, false otherwise
     */
    boolean add(E e);

    /**
     * Remove the last element of list
     * @return The element if it exist, or null otherwise
     */
    E remove();

    /**
     * Adding all the elements of other list to this list
     * @param list Other list
     * @param <T> The list extends from PeopleList
     * @return True if operation successful, false otherwise
     */
    <T extends List<E>> boolean addAll(T list);

    /**
     * Remove the element out of list according to id
     * @param id The id of this element
     * @return The element if it exist, or null otherwise
     */
    E remove(int id);

    /**
     * Remove the element out of list according to name
     * @param name The name of this element
     * @return The element if it exist, or null otherwise
     */
    E remove(String name);

    /**
     * Get the first element from this list
     * @return This element if founded, or null otherwise
     */
    E get();

    /**
     * Get a certain element by index
     * @param index This element's index
     * @return This element if founded, or null otherwise
     */
    E get(int index);

    /**
     * Get a certain element by his/her name
     * @param element This element's name
     * @return This first element in this list if founded, or null otherwise
     */
    E get(E element);

    /**
     * To check if this list is empty
     * @return True if it is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * To check if this list contains a certain element
     * @param element The element's name to be checked
     * @return True if it contains this element, false otherwise
     */
    boolean contains(E element);

    /**
     * Reverse the list
     * @return Reversed list of this list if reverse successfully
     */
    <T extends List<E>> T reverse();

    /**
     * Copy a list exact the same like this
     * @return The copy one
     */
    <T extends List<E>> T copy();
}
