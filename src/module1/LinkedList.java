package module1;

public class LinkedList implements List{
    Node head;

    public Object getAt(int loc) {
        int count = 0;

        return null;
    }

    public Object deleteAt(int loc) {
        return null;
    }

    public void addToHead(String item) {
        Node n = new Node();
        n.item = "x";
        n.next = head;
    }

    public void addToTail(String item) {

    }

    public void addUnique(String val) {
        Node cur = head;
        while (cur != null) {
            if (cur.item == val)
                return;
            cur = cur.next;
        }
        Node newNode = new Node();
        newNode.item = val;
        newNode.next = null;
        if (head == null)
            head = newNode;

    }

    public void addAt(int loc, Object o) {
        int count = 0;
        Node n = head;
        while(count < loc) {
            n = n.next;
        }

    }

    public void printFwd() {
//        if(head == null) {
//            System.out.println("{} = No values in list.");
//            return;
//        }
        Node n = head;
        System.out.print("{");
        while(n != null) {
            System.out.print("" + n.item + (n.next == null ? "}" : ", "));
            n = n.next;
        }
//        System.out.println(head.item + (head.next != null ? ", " + head.next.item: "}"));



    }

    public void printRev() {
//        if(tail == null) {
//            System.out.println("{} = No values in list.");
//            return;
//        }
//        Node n = tail;
//        System.out.print("{");
//        while(n != null) {
//            System.out.println("" + n.item + (n.prev == null ? "}":","));
//            n = n.prev;
//        }
    }

    public void printTest() {

    }

    public boolean isEmpty() {
        return head == null;
    }
}

class Node {
    String item;
    Node next;
    Node prev;
}



