/**
 * Test Class for BST
 * @author Neil Woodhouse - 851182
 */
public class BSTMain {
    public static void main(String[] args) {
        Profile person1 = new Profile("Jackson", "Peter", 12, 3, 1967,
                "some@email.com", new String[]{}, new String[]{});
        Profile person2 = new Profile("Aaron", "Jones", 9, 12, 1907,
                "someother@email.net", new String[]{}, new String[]{});
        Profile person3 = new Profile("Zacharia", "Adam", 1, 9, 2107,
                "someother@email.ac", new String[]{}, new String[]{});

        BST treeTest = new BST();
        //Insertion Test
        treeTest.insertProfile(person1);
        treeTest.insertProfile(person2);
        treeTest.insertProfile(person3);
        System.out.println(treeTest);

        //Tree search test
        System.out.println("\nSearch Test: " + treeTest.treeSearch("Jackson", "peter") + "\n");

        //Profile array output test
        Profile[] allProfiles = treeTest.getProfiles();
        System.out.println("Array Output Test: ");
        for (Profile profile : allProfiles) {
            System.out.println(profile);
        }
    }
}
