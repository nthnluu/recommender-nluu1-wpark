package sol;

import src.IAttributeDatum;

public class SampleRow implements IAttributeDatum {
    String name;
    String color;
    boolean lowCarb;
    boolean highFiber;
    boolean likeToEat;

    /**
     * Constructor for SampleRow Class
     * @param name - name attribute
     * @param color - color attribute
     * @param lowCarb - lowCarb attribute
     * @param highFiber - highFiber attribute
     * @param likeToEat - likeToEat attribute
     */
    public SampleRow(String name, String color, boolean lowCarb, boolean highFiber, boolean likeToEat) {
        this.name = name;
        this.color = color;
        this.lowCarb = lowCarb;
        this.highFiber = highFiber;
        this.likeToEat = likeToEat;
    }

    /**
     * Gets value of attribute
     * @param attributeName
     * @return the value of attribute
     */
    @Override
    public Object getValueOf(String attributeName) {
        Object val;
        if ("name".equals(attributeName)) {
            val = this.name;
        } else if ("color".equals(attributeName)) {
            val = this.color;
        } else if ("lowCarb".equals(attributeName)) {
            val = this.lowCarb;
        } else if ("highFiber".equals(attributeName)) {
            val = this.highFiber;
        } else if ("likeToEat".equals(attributeName)) {
            val = this.likeToEat;
        } else {
            val = null;
        }

        return val;
    }
}
