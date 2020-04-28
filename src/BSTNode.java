/**
 * This class allows for the creation of BSTNode objects, which contain a Profile data object, along with a link to a
 * left node and a right node.
 * @author Neil Woodhouse - 851182
 */
public class BSTNode {
    private Profile data;
    private BSTNode l;
    private BSTNode r;

    /**
     * @param data the Profile stored in this node
     */
    public BSTNode(Profile data) {
        this.data = data;
    }

    /**
     * @return the Profile stored in this node
     */
    public Profile getProfile() {
        return data;
    }

    /**
     * @param l the node to be referenced by the left link
     */
    public void setL(BSTNode l) {
        this.l = l;
    }

    /**
     * @param r the node to be referenced by the right link
     */
    public void setR(BSTNode r) {
        this.r = r;
    }

    /**
     * @return the node referenced by the left link
     */
    public BSTNode getL() {
        return l;
    }

    /**
     * @return the node referenced by the right link
     */
    public BSTNode getR() {
        return r;
    }

    /**
     * toString method for testing
     * @return a formatted string containing data about the node
     */
    @Override
    public String toString() {
        return "BSTNode{" +
                "data=" + data +
                ", l=" + l +
                ", r=" + r +
                '}';
    }
}
