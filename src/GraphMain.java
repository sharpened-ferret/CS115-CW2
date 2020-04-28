/**
 * Test class for Graph
 * @author Neil Woodhouse - 851182
 */
public class GraphMain {
    public static void main(String[] args) {
        //Loads test data from file
        BST tree = FileReader.readProfileSet("data/profiles_01.txt");
        Graph graph = new Graph("data/graph_01.txt", tree);

        //Tests Friend Recommendations
        Profile[] allProfiles = tree.getProfiles();
        BST[] friendRecommendationTrees = graph.friendRecommendations(allProfiles);

        //Outputs suggested friends result
        for (int i = 0; i < allProfiles.length; i++) {
            System.out.println("Recommended Friends for " + allProfiles[i].getFirstName() + " "
                    + allProfiles[i].getLastName()+": ");
            friendRecommendationTrees[i].printAlphabetical();
        }

    }
}
