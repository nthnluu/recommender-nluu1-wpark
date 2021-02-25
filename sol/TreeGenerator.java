package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;
import src.IGenerator;
import src.INode;

import java.util.LinkedList;
import java.util.Random;

/*
 * Class for creating and interacting with a decision tree given a dataset.
 *
 * T is the type of object that we are trying to classify.
 * (like src.Vegetable)
 */
public class TreeGenerator<T extends IAttributeDatum> implements IGenerator {
    IAttributeDataset<T> dataset;
    /**
     * Constructor for this class.
     *
     * @param initTrainingData - IAttributeDataset of the data table
     */
    public TreeGenerator(IAttributeDataset<T> initTrainingData) {
        // TODO: Implement.
        this.dataset = initTrainingData;
    }



    @Override
    public INode buildClassifier(String targetAttr) {
        // TODO: Implement.
        LinkedList<String> attributes = new LinkedList<>();

        for (String attribute : dataset.getAttributes()) {
            if (!attribute.equals(targetAttr)) {
                attributes.add(attribute);
            }
        }

        while (attributes.size() > 0) {
            String currAttribute = attributes.pop();
            System.out.println(currAttribute);
        }

        System.out.println(attributes);

        dataset.getAttributes();
        return null;
    }

    @Override
    public Object lookupRecommendation(IAttributeDatum forVals) {
        // TODO: Implement.
        return null;
    }

    @Override
    public void printTree() {
        // TODO: Implement.
    }
}