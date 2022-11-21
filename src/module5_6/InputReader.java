package module5_6;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InputReader {

    /**
     * Parses the input file so that you can add all the items found in the list in alphabetical order by title.
     */
    public static String [] parseInputFile(String file)
    {
        ArrayList<String> words = new ArrayList<String>();

        String instr;
        int i=0;
        try {
            //Create input reader
            BufferedReader in = new BufferedReader(new FileReader(file));
            while (in.ready()) {
                instr = in.readLine().replaceAll("[^\\w\\s]", "");
                instr = instr.replaceAll("[\\r]", "");
                instr = instr.replaceAll("[\\n]", "");
                String [] linedata = instr.split(" ");

                for (int j=0; j < linedata.length; j++) {
                    words.add(linedata[j].toLowerCase());
                }


            }
        } catch (IOException io) {
            System.err.println("Error in Parsing file.");
            io.printStackTrace();
        }
        return words.toArray(new String[words.size()]);
    }

    public static void main(String [] args) {

        Path current = Paths.get("input.txt");
        String inputFile = current.toAbsolutePath().toString();
        System.out.println(inputFile);
        for(int i = 0; i < inputFile.length(); i++)
            if(inputFile.charAt(i) == '\\')
                inputFile = inputFile.substring(0, i) + "\\" + inputFile.substring(i++);

        System.out.println(inputFile);
        String [] words  = InputReader.parseInputFile(inputFile);

        for (int i=0; i < words.length; i++) {
            System.out.println(words[i]);
        }

    }

}
