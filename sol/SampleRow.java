package sol;

import src.IAttributeDatum;

public class SampleRow implements IAttributeDatum {
    String color;
    boolean highFiber;

    public SampleRow(String color) {
        this.color = color;
        this.highFiber = true;
    }

    @Override
    public Object getValueOf(String attributeName) {
        Object val;
        if ("color".equals(attributeName)) {
            val = this.color;
        } else if ("highFiber".equals(attributeName)) {
            val = this.highFiber;
        } else {
            val = "blue";
        }

        return val;
    }
}
