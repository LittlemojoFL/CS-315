package module5_6;
public class DLList<Item> implements List<Item> {

    Node head = null;
    Node tail = null;

    public DLList() {

    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        Node cur = head;

        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        return count + 1;
    }

    public void printRev() {

        if (tail == null) {
            System.out.println("Empty");
            return;
        }

        int count = 0;
        Node cur = tail;

        while (cur.prev != null) {
            System.out.print(cur.data + ", ");

            cur = cur.prev;
        }

        System.out.println(cur);
    }

    public void printFwd() {

        if (head == null) {
            System.out.println("Empty");
            return;
        }

        int count = 0;
        Node cur = head;

        while (cur.next != null) {
            System.out.print(cur.data + ", ");

            cur = cur.next;
        }

        System.out.println(cur);

    }

    public void addToHead(Item item) {

        Node toAdd = new Node(item);

        if (head == null) {
            head = toAdd;
            tail = toAdd;
        } else {

            head.prev = toAdd;
            toAdd.next = head;

            head = toAdd;

        }

    }

    public void addToTail(Item item) {

        Node toAdd = new Node(item);

        if (head == null) {
            head = toAdd;
            tail = toAdd;
        } else {

            tail.next = toAdd;
            toAdd.prev = tail;

            tail = toAdd;

        }

    }

    public Item getAt(int loc) {

        if (head == null) {
            return null;
        }

        int count = 0;
        Node cur = head;

        while (cur.next != null && count < loc) {
            cur = cur.next;
            count++;
        }

        return (Item) cur.data;

    }

    public Item deleteAt(int loc) {

        if (head == null) {
            return null;
        }

        int count = 0;
        Node cur = head;

        while (cur.next != null && count < loc) {
            cur = cur.next;
            count++;
        }

        Node toReturn = cur;

        if (cur == head) {
            if (cur == tail) {
                head = null;
                tail = null;
            } else {
                head.next.prev = null;
                head = head.next;
            }

        } else if (cur == tail) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {

            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;

        }

        return (Item) cur.data;
    }

    public void addAt(int loc, Item item) {

        if (loc == 0) {
            addToHead(item);
            return;
        }

        if (head == null) {
            return;
        }

        int count = 0;
        Node cur = head;

        while (cur.next != null && count < loc) {
            cur = cur.next;
            count++;
        }

        if (tail == cur) {
            addToTail(item);
            return;
        }

        Node toAdd = new Node(item);

        cur.prev.next = toAdd;
        cur.prev = toAdd;
        toAdd.next = cur;
    }

}

class Node<Item> {

    Node next = null;
    Node prev = null;
    Item data;

    public Node(Item data) {
        this.data = data;
    }

    public String toString() {
        return data.toString();
    };

}