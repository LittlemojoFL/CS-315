package module1;

public interface List<Item> {
    Node getAt(int loc);

    Node deleteAt(int loc);

    void addToHead(String item);

    void addToTail(String item);

    void addAt(int loc, String item);

    void printFwd();

    void printRev();

    boolean isEmpty();

}
