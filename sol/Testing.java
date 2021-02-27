package sol;

import src.IAttributeDataset;
import tester.Tester;

import java.util.LinkedList;

public class Testing {
    public Testing() {

    }
    public ListObjsData<SampleRow> setupBasicDataset() {
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
        return dataset;
    }
    public ListObjsData<SampleRow> setupSameDataset() {
        LinkedList<SampleRow> rows = new LinkedList<>();

        SampleRow spinach = new SampleRow("spinach", "green", true, true, false);
        SampleRow kale = new SampleRow("kale", "green", true, true, true);
        SampleRow peas = new SampleRow("peas", "green", true, true, true);
        SampleRow carrot = new SampleRow("carrot", "orange", true, false, false);
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
        return dataset;
    }

    public ListObjsData<SampleRow> setupEqualDataset() {
        LinkedList<SampleRow> rows = new LinkedList<>();

        SampleRow spinach = new SampleRow("spinach", "orange", false, true, false);
        SampleRow kale = new SampleRow("kale", "green", true, true, true);
        SampleRow peas = new SampleRow("peas", "green", true, true, true);
        SampleRow carrot = new SampleRow("carrot", "orange", true, false, false);


        rows.add(spinach);
        rows.add(kale);
        rows.add(peas);
        rows.add(carrot);

        LinkedList<String> attributes = new LinkedList<>();
        attributes.add("color");
        attributes.add("lowCarb");
        attributes.add("highFiber");
        attributes.add("likeToEat");

        ListObjsData<SampleRow> dataset = new ListObjsData<SampleRow>(attributes, rows);
        return dataset;
    }
    public ListObjsData<SampleRow> setupEmptyDataset() {
        LinkedList<SampleRow> rows = new LinkedList<>();

        LinkedList<String> attributes = new LinkedList<>();

        ListObjsData<SampleRow> dataset = new ListObjsData<SampleRow>(attributes, rows);
        return dataset;
    }

    public LinkedList<String> setupAttributeList() {
        LinkedList<String> attributes = new LinkedList<>();
        attributes.add("color");
        attributes.add("lowCarb");
        attributes.add("highFiber");
        attributes.add("likeToEat");

        return attributes;
    }

    public LinkedList<SampleRow> setupRowList() {
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
        return rows;
    }

    public void testGetAttributes(Tester t) {
        ListObjsData<SampleRow> data = setupBasicDataset();
        ListObjsData<SampleRow> emptyData = setupEmptyDataset();
        //tests on full dataset
        t.checkExpect(data.getAttributes(), setupAttributeList());
        //tests on empty dataset
        t.checkExpect(emptyData.getAttributes(), new LinkedList());
    }

    public void testAllSameValue(Tester t) {
        ListObjsData<SampleRow> data = setupBasicDataset();
        ListObjsData<SampleRow> emptyData = setupEmptyDataset();
        ListObjsData<SampleRow> sameData = setupSameDataset();
        //tests on dataset of differing values for lowCarb
        t.checkExpect(data.allSameValue("lowCarb"), false);
        //tests on empty dataset
        t.checkExpect(emptyData.allSameValue("color"), false);
        //tests on dataset of same values of lowCarb
        t.checkExpect(sameData.allSameValue("lowCarb"), true);
    }

    public void testSize(Tester t) {
        ListObjsData<SampleRow> data = setupBasicDataset();
        ListObjsData<SampleRow> emptyData = setupEmptyDataset();
        //test on full dataset
        t.checkExpect(data.size(), 5);
        //test on empty dataset
        t.checkExpect(emptyData.size(), 0);
    }

    public void testPartition(Tester t) {
        LinkedList<SampleRow> rows = new LinkedList<>();
        LinkedList<SampleRow> rows1 = new LinkedList<>();
        SampleRow spinach = new SampleRow("spinach", "green", true, true, false);
        SampleRow kale = new SampleRow("kale", "green", true, true, true);
        SampleRow peas = new SampleRow("peas", "green", false, true, true);
        SampleRow carrot = new SampleRow("carrot", "orange", false, false, false);
        SampleRow lettuce = new SampleRow("lettuce", "green", true, false, true);

        rows.add(spinach);
        rows.add(kale);
        rows1.add(peas);
        rows1.add(carrot);
        rows.add(lettuce);

        LinkedList<String> attributes = new LinkedList<>();
        attributes.add("color");
        attributes.add("highFiber");
        attributes.add("likeToEat");

        ListObjsData<SampleRow> dataset = new ListObjsData<SampleRow>(attributes, rows);
        ListObjsData<SampleRow> dataset1 = new ListObjsData<SampleRow>(attributes, rows1);
        LinkedList<IAttributeDataset> result = new LinkedList<>();
        result.add(dataset);
        result.add(dataset1);
        ListObjsData<SampleRow> data = setupBasicDataset();
        ListObjsData<SampleRow> data1 = setupEmptyDataset();
        //tests on full dataset
        t.checkExpect(data.partition("lowCarb"), result);
        //tests on empty dataset
        t.checkExpect(data1.partition("lowCarb"), new LinkedList());
    }

    public void testGetSharedValue(Tester t) {
        ListObjsData<SampleRow> data = setupBasicDataset();
        ListObjsData<SampleRow> emptyData = setupEmptyDataset();
        //tests on full dataset
        t.checkExpect(data.getSharedValue("lowCarb"), true);
        //tests on empty dataset
        t.checkExpect(emptyData.getSharedValue("color"), null);
    }

    public void testMostCommonValue(Tester t) {
        ListObjsData<SampleRow> data = setupBasicDataset();
        ListObjsData<SampleRow> emptyData = setupEmptyDataset();
        ListObjsData<SampleRow> equalData = setupEqualDataset();
        //tests on full dataset
        t.checkExpect(data.mostCommonValue("lowCarb"), true);
        //tests on empty dataset
        t.checkExpect(emptyData.mostCommonValue("lowCarb"), null);
        //tests on dataset where values have equal amount of both
        t.checkExpect(equalData.mostCommonValue("color"), "orange");
    }

    public void testGetValueOf(Tester t) {
        SampleRow spinach = new SampleRow("spinach", "green", true, true, false);
        SampleRow kale = new SampleRow(null, null, true, true, true);
        //tests on row
        t.checkExpect(spinach.getValueOf("color"), "green");
    }


    public static void main(String[] args) { Tester.run(new Testing());
    }
}
