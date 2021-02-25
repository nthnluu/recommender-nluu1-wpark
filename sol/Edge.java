package sol;

import src.INode;

public class Edge {
    Object value;
    INode descendent;

    public Edge(Object value, INode descendent) {
        this.value = value;
        this.descendent = descendent;
    }

}
