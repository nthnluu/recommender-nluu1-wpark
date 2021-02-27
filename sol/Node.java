package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;
import src.INode;

import java.util.LinkedList;

public class Node<T extends IAttributeDatum> implements INode {
    String attribute;
    LinkedList<Edge> edges;
    public IAttributeDataset<T> subset;

    /**
     * Constructor for the Node Class
     *
     * @param attr   attribute of the node
     * @param edges  edge of the node
     * @param subset subsets of the attribute
     */
    public Node(String attr, LinkedList<Edge> edges, IAttributeDataset<T> subset) {
        this.attribute = attr;
        this.edges = edges;
        this.subset = subset;
    }
    /**
     * Produce the decision predicted for the given datum
     * @param attrVals the datum to look into
     * @return an object of the decision based on the datum
     */
    @Override
    public Object lookupDecision(IAttributeDatum attrVals) {
        Object attrVal = attrVals.getValueOf(this.attribute);
        Object match = null;
        Object common = null;

        for (Edge edge : edges) {
            // Find the edge with the matching attribute value
            if (edge.value.equals(attrVal)) {
                match = edge.descendent.lookupDecision(attrVals);
            }

            // find edge that matches the most common value for this attribute
            if (edge.value.equals(this.subset.mostCommonValue(this.attribute))) {
                common = edge.descendent.lookupDecision(attrVals);
            }
        }

        // Return the value from the matching edge if found,
        // otherwise follow the edge with the most common attribute value as a fallback
        if (match != null) {
            return match;
        } else {
            return common;
        }
    }

    /**
     * Prints the Node
     *
     * @param leadspace the input of the value
     */
    @Override
    public void printNode(String leadspace) {
        System.out.println(leadspace + "[Attribute " + this.subset.size() + " rows: " + attribute + "]");

        for (Edge edge : edges) {
            System.out.println(leadspace + "--> (" + edge.value + ")");
            edge.descendent.printNode(leadspace.concat("         "));
        }
    }
}
