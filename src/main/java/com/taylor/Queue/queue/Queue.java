package com.taylor.Queue.queue;

public interface Queue {
    /**
     *
     * @param value Value that you want to add into this queue
     * @return
     *
     */
    void add(int value) throws QueueFullException;

    /**
     * Get the first value from the queue
     * @return The value
     */
    int get();

    /**
     * Check if this queue is empty
     * @return True if this queue is empty; False otherwise
     */
    boolean isEmpty();

    /**
     * Inspect the first value of this queue
     * @return The value
     */
    int peek();

    /**
     * Count the number of element of this queue
     * @return The number of element of this queue
     */
    int count();

    /**
     * Formatting this queue.Print the content of this queue in the screen in a format of [element1,element2,...]
     */
    void show();

}
