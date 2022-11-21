package module5_6;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    DLList list = new DLList<>();

    public Queue() {

    }

    public void enqueue(Item item) {
        list.addToTail(item);
    }

    public Item dequeue() {
        return (Item) list.deleteAt(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public String toString() {

        String result = "";

        Iterator iterator = iterator();

        while (iterator.hasNext()) {
            result += iterator.next() + ", ";
        }

        return result;

    };

    public Iterator<Item> iterator() {
        return new QueueIterator<>();
    };

    // custom iterator class for the queue
    class QueueIterator<Item> implements Iterator<Item> {

        int index;

        public QueueIterator() {
            index = -1;
        }

        // returns true if there is a next element
        public boolean hasNext() {
            return index + 1 < list.size();
        }

        // returns the next element
        public Item next() {
            return (Item) list.getAt(++index);
        }

    }
}
