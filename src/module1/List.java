/*
Author: Logan McClellan
Date: 10/10/2022

Interface from: https://github.com/richss/cs315-alg-and-ds-java/blob/master/cs315-supplement/src/m1-lists/List.java
 */
package module1;

public interface List{
    Node getAt(int loc);

    Node deleteAt(int loc);

    void addToHead(String item);

    void addToTail(String item);

    void addAt(int loc, String item);

    void printFwd();

    void printRev();

    boolean isEmpty();

}
