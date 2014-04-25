package org.socramob.abstractdatastructures.queues;

public class ArrayQueue {

    public static final int DEFAULT_CAPACITY = 3;
    private final int[] elements;
    private int dequeueIndex = 0;
    private int enqueueIndex = 0;
    private int num_elements = 0;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.elements = new int[capacity];
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new FullQueueException();
        }
        this.elements[enqueueIndex] = element;
        incrementNumberOfElements();
        incrementEnqueueIndex();
    }

    public boolean isFull() {
        return num_elements == elements.length;
    }

    private void incrementNumberOfElements() {
        num_elements++;
    }

    private void incrementEnqueueIndex() {
        enqueueIndex = (enqueueIndex+1) % elements.length;
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new EmptyQueueException();
        }
        int dequeuedElement = this.elements[dequeueIndex];

        decrementNumberOfElements();
        incrementDequeueIndex();

        return dequeuedElement;
    }

    public boolean isEmpty() {
        return num_elements == 0;
    }

    private void decrementNumberOfElements() {
        num_elements--;
    }

    private void incrementDequeueIndex() {
        dequeueIndex = (dequeueIndex+1) % elements.length;
    }
}
