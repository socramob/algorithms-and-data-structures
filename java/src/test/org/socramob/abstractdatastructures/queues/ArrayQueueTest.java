package org.socramob.abstractdatastructures.queues;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ArrayQueueTest {

    @Test
    public void should_return_the_element() {
        ArrayQueue queue = new ArrayQueue();

        queue.enqueue(17);

        assertThat(queue.dequeue(), is(equalTo(17)));
    }

    @Test
    public void should_return_the_element_even_if_its_not_17() {
        ArrayQueue queue = new ArrayQueue();

        queue.enqueue(18);

        assertThat(queue.dequeue(), is(equalTo(18)));
    }

    @Test
    public void should_return_the_first_inserted_element() {
        ArrayQueue queue = new ArrayQueue();

        queue.enqueue(18);
        queue.enqueue(19);

        assertThat(queue.dequeue(), is(equalTo(18)));
    }

    @Test
    public void should_return_the_second_inserted_element_after_deque() {
        ArrayQueue queue = new ArrayQueue();

        queue.enqueue(18);
        queue.enqueue(19);
        queue.dequeue();

        assertThat(queue.dequeue(), is(equalTo(19)));
    }


    @Test(expected = EmptyQueueException.class)
    public void should_return_an_exception_on_empty_dequeue() {
        ArrayQueue queue = new ArrayQueue();

        queue.dequeue();
    }

    @Test
    public void should_not_throw_an_exception_when_the_queue_is_not_empty() {
        ArrayQueue queue = new ArrayQueue();

        queue.enqueue(0);

        assertThat(queue.dequeue(), is(equalTo(0)));
    }

    @Test
    public void should_return_the_third_element_after_two_calls_to_dequeue() {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.dequeue();
        queue.dequeue();
        assertThat(queue.dequeue(), is(equalTo(3)));
    }

    @Test(expected = FullQueueException.class)
    public void should_throw_exception_when_queue_full() {
        ArrayQueue queue = new ArrayQueue(4);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
    }

}
