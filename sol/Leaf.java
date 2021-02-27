package sol;

import src.IAttributeDatum;
import src.INode;

public class Leaf implements INode {
    Object value = null;

    /**
     * Constructor for the Leaf Class
     * @param value value of the leaf
     */
    public Leaf(Object value) {
        this.value = value;
    }

    /**
     * Produce the decision predicted for the given datum
     * @param attrVals the datum to look into
     * @return an object of the decision based on the datum
     */
    @Override
    public Object lookupDecision(IAttributeDatum attrVals) {
        return value;
    }

    /**
     * Prints the tree
     * @param leadspace the input of the value
     */
    @Override
    public void printNode(String leadspace) {
        System.out.println(leadspace + "*" + value + "*");
    }
}
