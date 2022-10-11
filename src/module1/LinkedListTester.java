package module1;
import module1.LinkedList;

public class LinkedListTester {
    LinkedList list = new LinkedList();
    public static void main(String[] args) {
        new LinkedListTester();
    }

    public LinkedListTester() {
//        list.addToHead(new Node());
        list.addToTail("x");
        list.addToTail("y");
        list.addToTail("z");
        list.addToHead("h");
        list.addToHead("g");
        list.addAt((3), "i");
        list.addAt(9, "9");
//        list.addUnique("x");
        list.printFwd();
        list.printRev();
    }
}




