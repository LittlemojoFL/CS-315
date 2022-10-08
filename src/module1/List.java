package module1;

public interface List<Item> {
    public Item getAt(int loc);

    public Item deleteAt(int loc);

    public void addToHead(String item);

    public void addToTail(String item);

    public void addAt(int loc, Item item);

    public void printFwd();

    public void printRev();

    public boolean isEmpty();

}
