package module5_6;

/**
 * Author: Logan McClellan
 * Date: 11/21/2022
 * Implements a word frequency counter using a binary search tree and a heap.
 */
public class WordCounter {
    public static BST<String, Integer> bst = new BST<String, Integer>();
    /**
     * Counts the occurences of each word in the array
     * @param words
     */
    public static void countWords(String [] words) {
        int count = 0;
        for(String word: words) {
            if(word.length() > 0) {
                if (!bst.contains(word)) {
                    count = 1;
                    bst.put(word, count);
                } else {
                    count = bst.get(word);
                    bst.put(word, ++count);
                }
            }
        }
        ascendingOrder();
        descendingOrder();
    }

    /**
     * Prints the Binary Search Tree in Ascending Order by word alphabetically
     */
    public static void ascendingOrder() {
        System.out.println("Printing in Ascending Order by word");
        bst.printInOrder();
    }

    /**
     * Prints the Binary Search Tree in Descending Order by count using a Max Heap
     */
    public static void descendingOrder() {
        System.out.println("Printing in Descending Order by count");
        MaxHeap<Integer, String> maxHeap = new MaxHeap<>(bst.size());
        for(String s: bst.keys()) {
            maxHeap.enqueue(bst.get(s), s);
        }

        while(!maxHeap.isEmpty()) {
            String s = maxHeap.dequeue();
            System.out.println(s + " => " + bst.get(s));
        }
    }

    public static void main(String [] args) {
        String input = "input.txt";
        WordCounter.countWords(InputReader.parseInputFile(input));
    }
}
