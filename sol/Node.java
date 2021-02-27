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
     * @param attr attribute of the node
     * @param edges edge of the node
     * @param subset subsets of the attribute
     */
    public Node(String attr, LinkedList<Edge> edges, IAttributeDataset<T> subset) {
        this.attribute = attr;
        this.edges = edges;
        this.subset = subset;
    }

    @Override
    public Object lookupDecision(IAttributeDatum attrVals) {
        Object attrVal = attrVals.getValueOf(this.attribute);


        for (Edge edge : edges) {
            if (edge.value.equals(attrVal)) {
                return edge.descendent.lookupDecision(attrVals);
            }
        }

        // the attribute wasn't on an edge, return the edge with the most common value
        for (Edge edge : edges) {
            if (edge.value.equals(this.subset.mostCommonValue(this.attribute))) {
                return edge.descendent.lookupDecision(attrVals);
            }
        }

        return this.subset.mostCommonValue(this.attribute);
    }

    /**
     * Prints the Node
     * @param leadspace the input of the value
     */
    @Override
    public void printNode(String leadspace) {
        System.out.println(leadspace + "[Attribute " + this.subset.size() + " rows: " + attribute + "]");

        for (Edge edge: edges) {
            System.out.println(leadspace + "--> (" + edge.value + ")");
            edge.descendent.printNode(leadspace.concat("         "));
        }
    }
}
