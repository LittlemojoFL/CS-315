/*
Author: Logan McClellan
Date: 10/10/2022

Implementation of interface from page 121 of Sedgewick's Algorithims 4th Edition
 */
package module1;

public class Stack {
    LinkedList list = new LinkedList();

    public Stack() {

    }

    public void push(String item) {
        list.addToHead(item);
    }

    public Node pop() {
        return list.deleteAt(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public String toString() {
        String line = "{";
        for(int count = 0; count < size(); count++)
            line += list.getAt(count) + (count == size()-1 ? "" :", ");
        line += "}";
        return line;
    }

}
