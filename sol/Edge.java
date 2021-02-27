package sol;

import src.INode;

public class Edge {
    Object value;
    INode descendent;

    /**
     * Constructor for Edge Class
     * @param value - the value of the edge
     * @param descendent - the next case
     */
    public Edge(Object value, INode descendent) {
        this.value = value;
        this.descendent = descendent;
    }

}
