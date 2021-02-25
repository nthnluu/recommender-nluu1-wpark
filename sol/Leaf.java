package sol;

import src.IAttributeDatum;
import src.INode;

public class Leaf implements INode {
    Object value = null;

    public Leaf(Object value) {
        this.value = value;
    }

    @Override
    public Object lookupDecision(IAttributeDatum attrVals) {
        return value;
    }

    @Override
    public void printNode(String leadspace) {
        System.out.println(leadspace + value);
    }
}
