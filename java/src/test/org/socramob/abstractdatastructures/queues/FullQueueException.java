package org.socramob.abstractdatastructures.queues;

public class FullQueueException extends RuntimeException {
    public FullQueueException() {
        super("Queue is full");
    }
}
