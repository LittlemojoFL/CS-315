package module5_6;
/**
 * Implements a word frequency counter using a binary search tree and a heap.
 */

public class WordCounter {
    /**
     * Stores the words in a BST
     * @param words
     */
    public static void countWords(String [] words) {
        //First, we Heapify the words in the string to sort them into alphabetical order.
        Heap.sort(words);
        for(String s: words) System.out.println(s);

        //Second, we store the words in the BST with the count of how many of the word exist
        BST<String, Integer> st = new BST<String, Integer>();
        int count = 0;
        String curWord = "";
        for(int i = 0; i < words.length; i++) {
            if(curWord.equals(""))
                curWord = words[i];
            if(words[i].equals(curWord)) {
                count++;
                continue;
            }
            //If the word at this index is a different word from the previous index
            //we add the curWord to the BST, and then start with a new word
            if(!(words[i].equals(curWord))) {

                st.put(curWord, count);
                curWord = words[i];
                count = 1;
            }
        }
        System.out.println("Printing in Ascending Order by word");
        for (String s : st.levelOrder())
            System.out.println(s + " " + st.get(s));

        System.out.println();
    }



    public static void main(String [] args) {
        String input = "input.txt";
        WordCounter.countWords(InputReader.parseInputFile(input));
    }
}
