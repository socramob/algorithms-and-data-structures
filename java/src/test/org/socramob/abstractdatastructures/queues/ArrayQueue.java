package org.socramob.abstractdatastructures.queues;

public class ArrayQueue {

    public static final int MAGIC_NUMBER_NO_ELEMENTS = -1;
    private int enqueueIndex = 0;
    int[] element = new int[3];

    int dequeueIndex = 0;

    public ArrayQueue(int size) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public void enqueue(int element) {
        this.element[enqueueIndex++] = element;
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new EmptyQueueException();
        }
        return this.element[dequeueIndex++];
    }

    public boolean isEmpty() {
        return dequeueIndex >= enqueueIndex;
    }
}
