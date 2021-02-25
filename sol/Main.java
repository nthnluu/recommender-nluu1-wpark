package sol;

import src.INode;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<SampleRow> rows = new LinkedList<>();

        SampleRow iPhone8 = new SampleRow("iPhone 8", "Touch ID", true, true);
        rows.add(iPhone8);

        SampleRow iPhone8Plus = new SampleRow("iPhone 8 Plus", "Touch ID", true, true);
        rows.add(iPhone8Plus);

        SampleRow iPhoneXS = new SampleRow("iPhone XS", "Face ID", false, false);
        rows.add(iPhoneXS);

        SampleRow iPhoneXSMax = new SampleRow("iPhone XS Max", "Face ID", true, false);
        rows.add(iPhoneXSMax);


        LinkedList<String> attributes = new LinkedList<>();
        attributes.add("modelName");
        attributes.add("isPlus");
        attributes.add("hasHomeButton");
        attributes.add("authMethod");


        ListObjsData<SampleRow> dataset = new ListObjsData<SampleRow>(attributes, rows);
        TreeGenerator<SampleRow> generator = new TreeGenerator<SampleRow>(dataset);

        generator.buildClassifier("modelName");
        generator.printTree();
    }
}
