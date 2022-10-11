/*
Author: Logan McClellan
Date: 10/10/2022

Implementation of interface from page 121 of Sedgewick's Algorithims 4th Edition
 */
package module1;

public class QueueTester {
    public static void main(String[] args) {
        new QueueTester();
    }

    public QueueTester() {
        Queue queue = new Queue();
        System.out.println("Queue empty: " + queue.isEmpty());
        System.out.println("Enqueuing x,y,z");
        queue.enqueue("x");
        queue.enqueue("y");
        queue.enqueue("z");
        System.out.println(queue);
        System.out.println("Queue empty: " + queue.isEmpty());

        System.out.println("Queue size: " + queue.size());
        System.out.println("Dequeueing first two elements.");
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        System.out.println("Queue size: " + queue.size());
        queue.dequeue();
        System.out.println(queue);
    }
}
