/**
 * Test Class for BSTNode
 * @author Neil Woodhouse - 851182
 */
public class BSTNodeMain {
    public static void main(String[] args) {
        String[] profile1Interests = {"Stargazing", "Photonic Anti-telephone"};
        String[] profile1Activities = {"D&D", "Transforming into a toaster"};
        Profile profile1 = new Profile("Being", "Human", 1, 1, 1,
                "1@1.com", profile1Interests , profile1Activities);

        String[] profile2Interests = {};
        String[] profile2Activities = {};
        Profile profile2 = new Profile("Person", "Test", 31, 3, 2109,
                "at@.at", profile2Interests, profile2Activities);

        //Test Node Constructor
        BSTNode node0 = new BSTNode(profile1);
        BSTNode node1 = new BSTNode(profile2);


        //Test Node Getters and Setters
        System.out.println("Left Node: " + node0.getL());
        System.out.println("Right Node: " + node0.getR());

        node0.setL(node1);
        System.out.println("\nSet Left Node.");
        System.out.println("Left Node: " + node0.getL());
        System.out.println("Right Node: " + node0.getR());
    }
}
