package org.socramob.abstractdatastructures.queues;

public class ArrayQueue {

    int[] elements;
    int nextEnqueueIndex = 0;
    int nextDequeueIndex = 0;

    public ArrayQueue() {
        this.elements = new int[3];
    }

    public void enqueue(int element) {
        elements[nextEnqueueIndex++] = element;
    }

    public int dequeue() {
        if(nextDequeueIndex >= nextEnqueueIndex) {
            throw new EmptyQueueException();
        }

        return elements[nextDequeueIndex++];
    }

}
