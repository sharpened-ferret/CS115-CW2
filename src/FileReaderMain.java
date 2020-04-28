/**
 * Test file for FileReader
 * @author Neil Woodhouse - 851182
 */
public class FileReaderMain {
    public static void main(String[] args) {
        System.out.println("Tests reading profiles from file");
        System.out.println(FileReader.readProfileSet("data/profiles_01.txt"));
    }
}
