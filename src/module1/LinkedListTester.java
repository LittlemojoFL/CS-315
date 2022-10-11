/*
Author: Logan McClellan
Date: 10/10/2022

Tester for interface from source: https://github.com/richss/cs315-alg-and-ds-java/blob/master/cs315-supplement/src/m1-lists/List.java
 */
package module1;
import module1.LinkedList;

public class LinkedListTester {
    LinkedList list = new LinkedList();
    public static void main(String[] args) {
        new LinkedListTester();
    }

    public LinkedListTester() {
        System.out.println("List is empty: " + list.isEmpty());
        list.addToTail("x");
        list.addToTail("y");
        list.addToTail("z");
        list.addToHead("h");
        list.addToHead("g");
        list.addAt((3), "i");
        list.addAt(9, "9");
        System.out.println("List size: " + list.size());
        System.out.println("6 elements successful, 1 failure");
        list.printFwd();
        list.printRev();

        System.out.println("\nElement at 3: " + list.getAt(3));

        System.out.print("\nDeleting element 3: ");
        list.deleteAt(3);
        list.printFwd();
        list.printRev();

        System.out.print("\nDeleting element 9: ");
        list.deleteAt(9);
        list.printFwd();
        list.printRev();

        System.out.print("\nDeleting element 0: ");
        list.deleteAt(0);
        list.printFwd();
        list.printRev();
        System.out.println("List is empty: " + list.isEmpty());
    }
}




