import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class allows properly-formatted files to be read, to create a tree structure, containing profiles for all
 * of the individuals described in the file.
 */
public class FileReader {
    /**
     * This method reads a file containing profile information and generates a tree containing all the profiles
     * from the file
     * @param filename the file name of the profile file to be read
     * @return a tree containing profile nodes, sorted alphabetically, with the lowest values to the left
     */
    public static BST readProfileSet(String filename) {
        BST tree = new BST();

        Scanner in = null;
        try {
            File input = new File(filename);
            in = new Scanner(input);
        } catch (FileNotFoundException e) {
            System.out.println("Error: The Specified File could not be Found. The program will now terminate.");
            System.exit(0);
        }

        while (in.hasNextLine()) {
            String currentLine = in.nextLine();
            Profile currentProfile = lineHandler(currentLine);
            tree.insertProfile(currentProfile);
        }

        return tree;
    }

    /**
     * This method takes a line from the file and generates a profile object for it
     * @param line a line, from file, containing the information for a single profile
     * @return a profile object for the input data
     */
    private static Profile lineHandler(String line) {
        String[] splitLine = line.split(",");

        String lastName = splitLine[0];
        String firstName = splitLine[1];
        int birthDay = Integer.parseInt(splitLine[2]);
        int birthMonth = Integer.parseInt(splitLine[3]);
        int birthYear = Integer.parseInt(splitLine[4]);
        String email = splitLine[5];
        String[] interests = arrayHandler(splitLine[6]);
        String[] activities = arrayHandler(splitLine[7]);

        Profile outputProfile = new Profile(lastName, firstName, birthDay, birthMonth, birthYear,
                email, interests, activities);
        return outputProfile;
    }

    /**
     * The method splits the inputs for 'interests' and 'activities' into string arrays
     * @param arrayString a string containing multiple, colon-separated, values
     * @return a string array containing the separated values from the input
     */
    private static String[] arrayHandler(String arrayString) {
        String[] arrayOutput = arrayString.split(";");
        return  arrayOutput;
    }
}
