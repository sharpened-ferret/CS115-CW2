/**
 * Test class for BST.printAlphabetical()
 * @author Neil Woodhouse - 851182
 */
public class AlphaMain {
    public static void main(String[] args) {
        BST tree = FileReader.readProfileSet("data/profiles_01.txt");

        System.out.println("Tests for Alphabetic Sorting by Last Name");
        tree.printAlphabetical();
    }
}
