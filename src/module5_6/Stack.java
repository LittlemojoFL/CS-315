package module5_6;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    DLList list = new DLList<>();

    public Stack() {

    }

    public void push(Item item) {
        list.addToHead(item);
    }

    public Item pop() {
        return (Item) list.deleteAt(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public Iterator<Item> iterator() {
        return new StackIterator<>();
    }

    class StackIterator<Item> implements Iterator<Item> {
        int index;

        public StackIterator() {
            index = list.size();
        }

        // returns true if there is another item in the stack
        public boolean hasNext() {
            return index - 1 >= 0;
        }

        // returns the next item in the stack
        public Item next() {
            return (Item) list.getAt(--index);
        }

    }

    public String toString() {

        String result = "";

        Iterator iterator = iterator();

        while (iterator.hasNext()) {
            result += iterator.next() + ", ";
        }

        return result;

    };
}
