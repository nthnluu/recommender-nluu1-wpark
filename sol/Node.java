package sol;

import src.IAttributeDatum;
import src.INode;

import java.util.LinkedList;

public class Node implements INode {
    String attribute;
    LinkedList<Edge> edges;


    public Node(String attr, LinkedList<Edge> edges) {
        this.attribute = attr;
        this.edges = edges;
    }

    @Override
    public Object lookupDecision(IAttributeDatum attrVals) {
        Object attrVal = attrVals.getValueOf(this.attribute);

        for (Edge edge : edges) {
            if (edge.value.equals(attrVal)) {
                return edge.descendent.lookupDecision(attrVals);
            }
        }

        // TODO: return the most common value, the attribute wasn't on an edge
        return null;
    }

    @Override
    public void printNode(String leadspace) {
//        System.out.println(attribute);
//
//        for (Edge edge: edges) {
//            edge.descendent.printNode();
//        }


    }
}
