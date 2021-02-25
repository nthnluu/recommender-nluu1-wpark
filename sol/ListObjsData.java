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

    @Override
    public LinkedList<String> getAttributes() {
        return this.attributes;
    }

    @Override
    public boolean allSameValue(String ofAttribute) {
        // TODO: Implement.

        boolean res = true;

        for (T row : this.rows) {
            if (this.rows.getFirst().getValueOf(ofAttribute) != row.getValueOf(ofAttribute)) {
                res = false;
                break;
            }
        }

        return res;
    }

    @Override
    public int size() {
        return rows.size();
    }

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
            for (T row : rows) {
                if (row.getValueOf(onAttribute).equals(currRow.getValueOf(onAttribute))) {
                    // Add row to newRows and remove it from the rows to consider
                    newRows.add(row);
                    rows.remove(row);
                }
            }

            // Remove the current attribute from the related attributes
            LinkedList<String> newAttributes = new LinkedList<>(this.attributes);
            newAttributes.removeIf(s -> s.equals(onAttribute));

            // Create a new dataset to hold the newly partitioned rows
            ListObjsData<T> newDataset = new ListObjsData<>(newAttributes, newRows);
            result.add(newDataset);
        }

        return result;
    }

    @Override
    public Object getSharedValue(String ofAttribute) {
        return this.rows.getFirst().getValueOf(ofAttribute);
    }

    @Override
    public Object mostCommonValue(String ofAttribute) {
        // TODO: Implement.
        return null;
    }
}
