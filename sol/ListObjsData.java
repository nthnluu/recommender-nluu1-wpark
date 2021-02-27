package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;

import java.util.LinkedList;

/*
 * Class for a specific representation of rows in a data table. This uses a list
 * of objects (one object per row).
 * The type T is the object that forms the "rows" of the data table
 */
public class ListObjsData<T extends IAttributeDatum>
        implements IAttributeDataset<T> {

    LinkedList<String> attributes = null;
    LinkedList<T> rows = null;

    /**
     * Constructor for the ListObjsData class
     *
     * @param attributes - a list of valid attributes for the T object
     * @param rows       - a list of objects (rows)
     */
    public ListObjsData(LinkedList<String> attributes, LinkedList<T> rows) {
        this.rows = rows;
        this.attributes = attributes;
    }

    /**
     * All the attributes in the dataset
     * @return list of attributes in the dataset
     */
    @Override
    public LinkedList<String> getAttributes() {
        return this.attributes;
    }

    /**
     * Checks if all attributes are the same value
     * @param ofAttribute attribute to search for
     * @return boolean if valeus are all same
     */
    @Override
    public boolean allSameValue(String ofAttribute) {
        return this.partition(ofAttribute).size() == 1;
    }

    /**
     * returns the rows of the dataset
     * @return int of row size
     */
    @Override
    public int size() {
        return rows.size();
    }

    /**
     * Partitions rows into subsets such that each value has same value
     * @param onAttribute attribute to partition by
     * @return list of subset depending on the attribute
     */
    @Override
    public LinkedList<IAttributeDataset<T>> partition(String onAttribute) {
        LinkedList<T> rows = new LinkedList<>(this.rows);
        LinkedList<IAttributeDataset<T>> result = new LinkedList<>();

        while (rows.size() > 0) {
            // Create a new list to hold the rows with matching attribute values
            LinkedList<T> newRows = new LinkedList<>();

            // Pop a row off the rows list
            T currRow = rows.pop();

            // Add the currRow to the newRows list
            newRows.add(currRow);

            // Find all rows with matching attribute values to currRow
            rows.removeIf(row -> {
                if (row.getValueOf(onAttribute).equals(currRow.getValueOf(onAttribute))) {
                    newRows.add(row);
                    return true;
                }
                return false;
            });

            // Remove the current attribute from the related attributes
            LinkedList<String> newAttributes = new LinkedList<>(this.attributes);
            newAttributes.removeIf(s -> s.equals(onAttribute));

            // Create a new dataset to hold the newly partitioned rows
            ListObjsData<T> newDataset = new ListObjsData<>(newAttributes, newRows);
            result.add(newDataset);
        }

        return result;
    }

    /**
     * Get the value for attribute (common for all rows)
     * @param ofAttribute attribute to search for
     * @return the first value of attribute
     */
    @Override
    public Object getSharedValue(String ofAttribute) {
        if (this.size() == 0) {
            return null;
        } else {
            return this.rows.getFirst().getValueOf(ofAttribute);
        }
    }

    /**
     * get the most common value for attribute
     * @param ofAttribute attribute to search for
     * @return the most common value of the attribute
     */
    @Override
    public Object mostCommonValue(String ofAttribute) {
        // Partition the dataset with the target attribute
        if (this.size() == 0) {
            return null;
        }
        LinkedList<IAttributeDataset<T>> partitioned = this.partition(ofAttribute);

        // Keep track of the largest dataset size and the largest dataset
        int largestDatasetSize = 0;
        IAttributeDataset<T> largestDataset = null;

        // Find the largest dataset
        for (IAttributeDataset<T> dataset : partitioned) {
            if (dataset.size() > largestDatasetSize) {
                largestDataset = dataset;
                largestDatasetSize = dataset.size();
            }
        }

        if (largestDataset != null) {
            // Return the common value for the given attribute of the largest dataset
            return largestDataset.getSharedValue(ofAttribute);
        } else {
            throw new RuntimeException("We couldn't find values for the specified attribute!");
        }
    }
}
