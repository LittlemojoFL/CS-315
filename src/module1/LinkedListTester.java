package module1;
import module1.LinkedList;

public class LinkedListTester {
    LinkedList list = new LinkedList();
    public static void main(String[] args) {
        new LinkedListTester();
    }

    public LinkedListTester() {
//        list.addToHead(new Node());
        list.addUnique("x");
        list.addUnique("y");
        list.addUnique("z");
//        list.addUnique("x");
        list.printFwd();
    }
}




