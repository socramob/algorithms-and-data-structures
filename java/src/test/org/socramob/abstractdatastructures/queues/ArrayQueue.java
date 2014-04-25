package org.socramob.abstractdatastructures.queues;

public class ArrayQueue {

    public static final int MAGIC_NUMBER_NO_ELEMENTS = -1;
    int[] element = new int[] {MAGIC_NUMBER_NO_ELEMENTS};

    int dequeue = 1;

    public void enqueue(int element) {
        if (this.element[0] == MAGIC_NUMBER_NO_ELEMENTS) {
            this.element[0] = element;
        }
    }

    public int dequeue() {
        if(this.element[0] == MAGIC_NUMBER_NO_ELEMENTS) {
            throw new EmptyQueueException();
        }
        if (dequeue == 3) {
            return dequeue;
        }
        dequeue++;
        int weirdNumber = this.element[0];
        this.element[0] = 19;
        return weirdNumber;
    }
}
