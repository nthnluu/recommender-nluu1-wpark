package sol;

import src.INode;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Leaf sampleLeaf1 = new Leaf("titty");
        Leaf sampleLeaf2 = new Leaf(false);

        LinkedList<Edge> edges1 = new LinkedList<>();
        Edge sampleEdge = new Edge(true, sampleLeaf1);
        Edge sampleEdge1 = new Edge(false, sampleLeaf2);
        edges1.add(sampleEdge);
        edges1.add(sampleEdge1);
        INode sampleTree = new Node("highFiber", edges1);

        Edge sampleEdge2 = new Edge("green", sampleLeaf2);
        Edge sampleEdge3 = new Edge("blue", sampleTree);

        LinkedList<Edge> edges = new LinkedList<>();
        edges.add(sampleEdge2);
        edges.add(sampleEdge3);

        INode sampleTree1 = new Node("color", edges);


        SampleRow row = new SampleRow("blue", true);
        LinkedList<SampleRow> rows = new LinkedList<>();
        rows.add(row);

        SampleRow row1 = new SampleRow("green", true);

        rows.add(row);
        rows.add(row1);

        LinkedList<String> attributes = new LinkedList<>();
        attributes.add("color");
        attributes.add("highFiber");
        ListObjsData<SampleRow> dataset = new ListObjsData<SampleRow>(attributes, rows);
        TreeGenerator<SampleRow> generator = new TreeGenerator<SampleRow>(dataset);


        System.out.println(dataset.partition("color").size());
        System.out.println(dataset.partition("color").get(0).allSameValue("color"));
//        System.out.println(dataset.allSameValue("color"));
//        System.out.println(dataset.size());
//        System.out.println(dataset.partition("color").get(0).allSameValue("color"));
//        System.out.println(generator.buildClassifier("color"));
//        System.out.println(sampleTree.lookupDecision(row));
    }
}
