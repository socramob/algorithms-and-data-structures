package org.socramob.abstractdatastructures.queues;

public class ArrayQueue {

    public static final int DEFAULT_CAPACITY = 3;

    private final int[] elements;
    private int dequeueIndex = 0;
    private int enqueueIndex = 0;

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
        this.elements[getNormalizedEnqueueIndex()] = element;
        enqueueIndex++;
    }

    private int getNormalizedEnqueueIndex() {
        return enqueueIndex % this.elements.length;
    }

    private boolean isFull() {
        return getSize() == this.elements.length;
    }

    private int getSize() {
        return (enqueueIndex-dequeueIndex);
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new EmptyQueueException();
        }
        int elementToDequeue = this.elements[getNormalizedDequeueIndex()];
        dequeueIndex++;

        if(hasResettableIndices()) {
            resetIndices();
        }

        return elementToDequeue;
    }

    private boolean hasResettableIndices() {
        return dequeueIndex > this.elements.length;
    }

    private void resetIndices() {
        dequeueIndex = dequeueIndex % this.elements.length;
        enqueueIndex = enqueueIndex % this.elements.length;
    }

    private int getNormalizedDequeueIndex() {
        return dequeueIndex % this.elements.length;
    }

    public boolean isEmpty() {
        return dequeueIndex >= enqueueIndex;
    }
}
