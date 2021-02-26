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
    INode decisionTree = null;

    /**
     * Constructor for this class.
     *
     * @param initTrainingData - IAttributeDataset of the data table
     */
    public TreeGenerator(IAttributeDataset<T> initTrainingData) {
        this.dataset = initTrainingData;
    }


    private INode generateTree(IAttributeDataset<T> dataset, String targetAttribute) {
        // Remove the target attribute from the dataset's attributes to consider
        LinkedList<String> attributesToConsider = new LinkedList<>(dataset.getAttributes());
        attributesToConsider.removeIf(s -> s.equals(targetAttribute));

        // Check if there are attributes to consider
        if (attributesToConsider.size() > 0) {
            // Get the next attribute to consider
            String attrToConsider = attributesToConsider.getFirst();

            // Partition dataset based on current attribute
            LinkedList<IAttributeDataset<T>> subsets = dataset.partition(attrToConsider);
            LinkedList<Edge> edges = new LinkedList<>();

            // For each subset, generate edges
            for (IAttributeDataset<T> subset : subsets) {
                Edge newEdge = null;

                if (subset.allSameValue(targetAttribute)) {
                    // Subset has all the same value for the target attribute, add leaf
                    newEdge = new Edge(subset.getSharedValue(attrToConsider), new Leaf(subset.getSharedValue(targetAttribute)));
                } else {
                    // Create edge based on common value in subset, set descendent to generated tree based on subset
                    newEdge = new Edge(subset.getSharedValue(attrToConsider), this.generateTree(subset, targetAttribute));
                }

                // Add edge to edge list
                edges.add(newEdge);
            }

            return new Node<T>(attrToConsider, edges, dataset);
        } else {
            // return leaf if no attributes left
            return new Leaf(dataset.mostCommonValue(targetAttribute));
        }
    }

    @Override
    public INode buildClassifier(String targetAttr) {
        INode newTree = this.generateTree(this.dataset, targetAttr);
        this.decisionTree = newTree;
        return this.decisionTree;
    }

    @Override
    public Object lookupRecommendation(IAttributeDatum forVals) {
        if (this.decisionTree != null) {
            return this.decisionTree.lookupDecision(forVals);
        } else {
            throw new RuntimeException("No tree created yet! RUN buildClassifier() first!");
        }
    }

    @Override
    public void printTree() {
        this.decisionTree.printNode("");
    }
}