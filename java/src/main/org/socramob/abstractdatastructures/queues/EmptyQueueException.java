package org.socramob.abstractdatastructures.queues;

public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException() {
        super("This queue is empty!");
    }

}
