package sol;

import src.INode;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<SampleRow> rows = new LinkedList<>();

        SampleRow spinach = new SampleRow("spinach", "green", true, true, false);
        SampleRow kale = new SampleRow("kale", "green", true, true, true);
        SampleRow peas = new SampleRow("peas", "green", false, true, true);
        SampleRow carrot = new SampleRow("carrot", "orange", false, false, false);
        SampleRow lettuce = new SampleRow("lettuce", "green", true, false, true);

        rows.add(spinach);
        rows.add(kale);
        rows.add(peas);
        rows.add(carrot);
        rows.add(lettuce);

        LinkedList<String> attributes = new LinkedList<>();
        attributes.add("color");
        attributes.add("lowCarb");
        attributes.add("highFiber");
        attributes.add("likeToEat");

        ListObjsData<SampleRow> dataset = new ListObjsData<SampleRow>(attributes, rows);
        TreeGenerator<SampleRow> generator = new TreeGenerator<SampleRow>(dataset);

        generator.buildClassifier("likeToEat");
        generator.printTree();
        System.out.println(generator.lookupRecommendation(carrot));

    }
}
