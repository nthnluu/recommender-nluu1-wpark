package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;
import src.INode;

import java.util.LinkedList;

public class Node<T extends IAttributeDatum> implements INode {
    String attribute;
    LinkedList<Edge> edges;
    public IAttributeDataset<T> subset;


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

        // return the most common value, the attribute wasn't on an edge
        return this.subset.mostCommonValue(this.attribute);
    }

    @Override
    public void printNode(String leadspace) {
        System.out.println(leadspace + "[Attribute " + this.subset.size() + " rows: " + attribute + "]");

        for (Edge edge: edges) {
            System.out.println(leadspace + "--> (" + edge.value + ")");
            edge.descendent.printNode(leadspace.concat("         "));
        }
    }
}
