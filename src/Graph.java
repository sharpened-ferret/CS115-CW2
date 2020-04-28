import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class allows the creation of graphs, allowing for friendships to be loaded from file, and for
 * friend recommendations to be generated for all Profiles contained in the graph.
 * @author Neil Woodhouse - 851182
 */
public class Graph {
    BST tree;

    /**
     * Constructor for new graphs. Accepts files in the format '[firstname1] [lastname1],[firstname2] [lastname2]'
     * with one pair per line.
     * @param filename the name of the input file for loading friendships
     * @param tree the input tree of Profiles
     */
    public Graph(String filename, BST tree) {
        this.tree = tree;

        Scanner in = null;
        try {
            File input = new File(filename);
            in = new Scanner(input);
        } catch (FileNotFoundException e) {
            System.out.println("Error: The Specified File could not be Found. The program will now terminate.");
            System.exit(0);
        }

        while (in.hasNextLine()) {
            String[] names = in.nextLine().split(",");
            String[] name1 = names[0].split(" ");
            String[] name2 = names[1].split(" ");
            try {
                addFriendship(name1[0], name1[1], name2[0], name2[1]);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Skipping Name - Illegal Format: " +
                        "Expected Format '<firstName> <lastName>,<firstName> <lastName>'");
            }
        }
    }

    /**
     * Updates both friend's profiles, to record their friendship
     * @param firstName1 the first name of the first friend
     * @param lastName1 the last name of the first friend
     * @param firstName2 the first name of the second friend
     * @param lastName2 the last name of the second friend
     */
    private void addFriendship(String firstName1, String lastName1, String firstName2, String lastName2) {
        Profile profile1 = tree.treeSearch(lastName1, firstName1);
        Profile profile2 = tree.treeSearch(lastName2, firstName2);
        if (profile1 != null && profile2 != null) {
            profile1.addFriend(profile2);
            profile2.addFriend(profile1);
        }
        else {
            throw new IllegalArgumentException("Error: All names entered must correspond to existing profiles.");
        }
    }

    /**
     * @param users an array of all users in the graph
     * @return an array of BSTs, with one tree for each Profile in the graph,
     * containing their personal friend recommendations.
     *
     * A friend will be recommended if they are the friend of an existing friend
     */
    public BST[] friendRecommendations(Profile[] users) {
        BST[] recommendationTrees = new BST[users.length];
        //Loops through all profiles in the input array
        for (int i = 0; i < users.length; i++) {
            recommendationTrees[i] = new BST();
            ArrayList<Profile> invalidSuggestions = new ArrayList<>();
            invalidSuggestions.add(users[i]);

            //Loops through all friends of the current profile, then their friends,
            //and adds all unique entries to the recommendation tree
            for (int j = 0; j < users[i].numOfFriends(); j++) {
                Profile currentFriend = users[i].getFriend(j);
                for (int k = 0; k < currentFriend.numOfFriends(); k++) {
                    Profile suggestion = currentFriend.getFriend(k);

                    //Checks if the current Profile is a new suggestion, to prevent repeats
                    if (!users[i].hasFriend(suggestion) && !invalidSuggestions.contains(suggestion)) {
                        invalidSuggestions.add(suggestion);
                        recommendationTrees[i].insertProfile(suggestion);
                    }
                }
            }
        }
        return recommendationTrees;
    }


}
