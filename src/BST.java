import java.util.ArrayList;

/**
 * This class allows the creation of Binary Search Trees, containing Profile objects.
 * All profiles can be exported as an array, the tree may be printed alphabetically sorted,
 * or it may be searched by Profile name attributes.
 * @author Neil Woodhouse - 851182
 */
public class BST {
    private BSTNode root;

    //Stores all profiles added to the tree - for acquiring a profile array to test Task 2.6
    private ArrayList<Profile> profiles = new ArrayList<>();

    /**
     * Constructor for new trees
     */
    public BST() {}

    /**
     * Inserts a new profile at its correct position in the tree
     * @param p the profile to be inserted to the tree
     */
    public void insertProfile(Profile p) {
        profiles.add(p);
        BSTNode node = new BSTNode(p);
        if (root == null) {
            root = node;
        }
        else {
            recursiveInsertion(root, node);
        }
    }

    /**
     * @param currentNode the existing node that code is currently running on
     * @param insertionNode the new node being inserted
     */
    private void recursiveInsertion(BSTNode currentNode, BSTNode insertionNode) {
        String insertionName = insertionNode.getProfile().getLastName();
        String currentName = currentNode.getProfile().getLastName();

        //Compares the last names of the profiles for the two nodes, to decide on placement for the insertion node
        int comparisonValue = insertionName.compareToIgnoreCase(currentName);

        //If the last name for the new profile is less than, or equal to the last name for the current profile
        //then it is inserted to the left node
        if (comparisonValue < 1) {
            if (currentNode.getL() == null) {
                currentNode.setL(insertionNode);
            }
            else {
                recursiveInsertion(currentNode.getL(), insertionNode);
            }
        }
        //Otherwise, it is inserted to the right node reference
        else {
            if (currentNode.getR() == null) {
                currentNode.setR(insertionNode);
            }
            else {
                recursiveInsertion(currentNode.getR(), insertionNode);
            }
        }
    }

    /**
     * Prints all nodes in alphabetical order by last name
     */
    public void printAlphabetical() {
        printAlphabetical(root);
        System.out.println("\n");
    }

    /**
     * Prints all nodes in alphabetical order by last name
     * @param node the starting node
     */
    private void printAlphabetical(BSTNode node) {
        if (node != null) {
            if (node.getL() != null) {
                this.printAlphabetical(node.getL());
            }
            Profile currentProfile = node.getProfile();
            System.out.printf("%s %s %s, ", currentProfile.getFirstName(), currentProfile.getLastName(),
                    currentProfile.getDateOfBirth());
            if (node.getR() != null) {
                this.printAlphabetical(node.getR());
            }
        }
    }

    /**
     * @param lastName the last name to be searched for
     * @param firstName the first name to be searched for
     * @return the profile of the search subject, or null if they do not exist in the tree
     */
    public Profile treeSearch(String lastName, String firstName) {
        return treeSearch(lastName, firstName, root);
    }

    /**
     * @param lastName the last name to be searched for
     * @param firstName the first name to be searched for
     * @param currentNode the starting node for the search, or the current node when recursing
     * @return the profile of the search subject, or null if they do not exist in the tree
     */
    private Profile treeSearch(String lastName, String firstName, BSTNode currentNode) {
        if (currentNode == null) {
            return null;
        }
        Profile currentProfile = currentNode.getProfile();
        int comparisonResult = lastName.compareToIgnoreCase(currentProfile.getLastName());

        if (comparisonResult < 0) {
            return treeSearch(lastName, firstName, currentNode.getL());
        }
        else if (comparisonResult == 0) {
            //Checks First Name also matches
            if (currentProfile.getFirstName().equalsIgnoreCase(firstName)) {
                return currentProfile;
            }
            //If not, calls left branch (since matching last names are assigned to the left of their existing last name)
            else {
                return treeSearch(lastName, firstName, currentNode.getL());
            }
        }
        else {
            return treeSearch(lastName, firstName, currentNode.getR());
        }
    }

    /**
     * Added to access a profile array for Task 2.6
     * @return all profiles contained in the tree
     */
    public Profile[] getProfiles() {
        return profiles.toArray(new Profile[0]);
    }

    /**
     * toString method for testing
     * @return a formatted string containing data about the tree
     */
    @Override
    public String toString() {
        return "BST{" +
                "root=" + root +
                '}';
    }
}
