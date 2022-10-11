/*
Author: Logan McClellan
Date: 10/10/2022

Implementation of interface from source: https://github.com/richss/cs315-alg-and-ds-java/blob/master/cs315-supplement/src/m1-lists/List.java
 */
package module1;

public class LinkedList<Item> {
    Node head;

    public LinkedList() {

    }
    public Node getAt(int loc) {
        int count = 0;
        Node n = head;
        while(count < loc && n.next != null) {
            n = n.next;
            count++;
        }
        if(count == loc)
            return n;
        else if(n.next == null)
            System.out.println("Invalid index: " + loc);
        return null;
    }

    /*
    Inputs: index of the node to delete
    Outputs: the node that has been deleted
    Description: Traverses through list until reaching the node at index loc
     */
    public Node deleteAt(int loc) {
        if(head == null)
            return null;
        Node n = head;
        int count = 0;
        if(loc == 0) {
            head = n.next;
            return n;
        }
        while(count < loc && n.next != null) {
            n = n.next;
            count++;
        }
        if(count != loc && n.next == null) {
            System.out.println("Index out of bounds. Failed to delete node at " + loc + ".");
            return null;
        } else {
            getAt(loc-1).next = n.next;
            return n;
        }
    }

    /*
    Inputs: the item for the node.
    Outputs: void.
    Description: Adds a node with the inputted item to the head of the list.
     */
    public void addToHead(String item) {
        Node n = new Node(item);
        Node temp = head;
        n.next = temp;
        head = n;
    }

    /*
    Inputs: the item for the node.
    Outputs: void.
    Description: Adds a node with the inputted item to the tail of the list.
     */
    public void addToTail(String item) {
        Node n = new Node(item);
        if(head == null)
            head = n;
        else {
            Node tail = head;
            while(tail.next != null)
                tail = tail.next;
            tail.next = n;
        }
    }

    /*
    Inputs: the index to add a node to, the item for the node.
    Outputs: void.
    Description: Adds a node with the inputted item to the head of the list.
     */
    public void addAt(int loc, String item) {
        int count = 0;
        Node n = head;
        while(count < loc-1 && n.next != null) {
            n = n.next;
            count++;
        }
        if(count == loc-1) {
            Node temp = n.next;
            n.next = new Node(item);
            n.next.next = temp;
        }
        if(count != loc-1 && n.next == null) {
            System.out.println("Invalid index: " + loc);
        }
    }


    /*
    Inputs: void.
    Outputs: void.
    Description: Prints the linked list in order from head to tail;
     */
    public void printFwd() {
        if(head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node n = head;
        System.out.print("{");
        while(n != null) {
            System.out.print(n.item + (n.next == null ? "" : ", "));
            n = n.next;
        }
        System.out.println("}");
    }

    /*
    Inputs: void.
    Outputs: void.
    Description: Prints the linked list in reverse by getting the size of the array, and then using getAt to get the
                 list from tail to head.
     */
    public void printRev() {
        if(head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("{");
        for(int count = size()-1; count >= 0; count--)
            System.out.print(getAt(count) + (count == 0  ? "" : ", "));
        System.out.println("}");
    }

    /*
    Input: void
    Output: boolean
    Checks if head is null, and thus the list is empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    /*
    Input: void.
    Output: int.
    Traverses through list to find the size of the linkedlist
     */
    public int size() {
        if(head == null)
            return 0;
        Node n = head;
        int count = 0;
        while(n.next != null) {
            n = n.next;
            count++;
        }
        return count + 1;
    }
}

class Node {
    String item;
    Node next;
    public Node (String item) {
        this.item = item;
        next = null;
    }

    public String toString() {
        return item;
    }
}