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
     * @param attributes - a list of valid attributes for the T object
     * @param rows - a list of objects (rows)
     */
    public ListObjsData(LinkedList<String> attributes, LinkedList<T> rows) {
        this.rows = rows;
        this.attributes = attributes;
    }

    @Override
    public LinkedList<String> getAttributes() {
        // TODO: Implement.
        return this.attributes;
    }

    @Override
    public boolean allSameValue(String ofAttribute) {
        // TODO: Implement.
        return false;
    }

    @Override
    public int size() {
        // TODO: Implement.
        return rows.size();
    }

    @Override
    public LinkedList<IAttributeDataset<T>> partition(String onAttribute) {
        // TODO: Implement.
        return null;
    }

    @Override
    public Object getSharedValue(String ofAttribute) {
        // TODO: Implement.
        return null;
    }

    @Override
    public Object mostCommonValue(String ofAttribute) {
        // TODO: Implement.
        return null;
    }
}
