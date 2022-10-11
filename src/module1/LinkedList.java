package module1;

public class LinkedList implements List{
    Node head;

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

    public Node deleteAt(int loc) {
        return null;
    }

    public void addToHead(String item) {
        System.out.println("Adding \"" + item + "\" to head.");
        Node n = new Node(item);
        if(head == null)
            head = n;
        else {
            Node temp = head;
            n.next = temp;
            head = n;
        }
    }

    public void addToTail(String item) {
        System.out.println("Adding \"" + item + "\" to tail.");
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

    public void addAt(int loc, String o) {
        System.out.println("Adding \"" + o + "\" at index " + loc + ".");
        int count = 0;
        Node n = head;
        while(count < loc-1 && n.next != null) {
            n = n.next;
            count++;
        }
        if(count == loc-1) {
            Node temp = n.next;
            n.next = new Node(o);
            n.next.next = temp;
        }
        if(count != loc-1 && n.next == null) {
            System.out.println("Invalid index: " + loc);
        }
    }

    public void printFwd() {
        Node n = head;
        System.out.print("{");
        while(n != null) {
            System.out.print("" + n.item + (n.next == null ? "}\n" : ", "));
            n = n.next;
        }
    }

    /*
    Get the length of the full list
    Get the node at the last index
    put node into new list
    print new list forwards
     */
    public void printRev() {
        //Count length of list
        Node n = head;
        int count = 0;
        while(n.next != null) {
            n = n.next;
            count++;
        }
        Node newHead = getAt(count);
        for( ; count >= 0;count--) {
            Node next = getAt(count);
            System.out.println("node at: " + count + " = " + next.item);
            newHead.next = next;
//            if(count-1 == -1)
//                newHead.next = null;
        }
        System.out.println("{");
        while(newHead.next != null) {
            System.out.print("" + newHead.item + (newHead.next == null ? "}\n" : ", "));
            newHead = newHead.next;
            count++;
//            if(newHead.item.equals("g"))
//                break;
//            if(count >= 10)
//                break;
        }

    }

    public boolean isEmpty() {
        return head == null;
    }
}

class Node {
    String item;
    Node next;

    public Node (String item) {
        this.item = item;
        next = null;
    }
}



