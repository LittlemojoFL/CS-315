/*
Author: Logan McClellan
Date: 10/10/2022

Implementation of interface from page 121 of Sedgewick's Algorithims 4th Edition
 */
package module1;

public class StackTester {
    public static void main(String[] args) {
        new StackTester();
    }

    public StackTester() {
        Stack s = new Stack();
        System.out.println("Testing push()");
        s.push("1");
        s.push("2");
        s.push("test");
        System.out.println(s);

        System.out.println("Size: " + s.size());

        System.out.println("\nTesting pop().");
        System.out.println(s.pop());
        System.out.println(s);
        System.out.println("Size: " + s.size());

        System.out.println("\nTesting isEmpty()");
        System.out.println("Expecting: false");
        System.out.println(s.isEmpty());

        System.out.println("Popping remaining items");
        System.out.println(s);
        s.pop();
        s.pop();

        System.out.println("Expecting: false");
        System.out.println(s.isEmpty());
        System.out.println(s);


    }
}
