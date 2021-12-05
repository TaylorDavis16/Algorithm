package com.taylor.Queue.queue;

public class QueueFullException extends Exception{
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public QueueFullException() {
        super("This queue is already full");
    }

    public QueueFullException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
