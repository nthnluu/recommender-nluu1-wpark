package sol;

import src.IAttributeDatum;

public class SampleRow implements IAttributeDatum {
    String modelName;
    String authMethod;
    boolean isPlus;
    boolean hasHomeButton;
    boolean hasFaceId;

    public SampleRow(String modelName, String authMethod, boolean isPlus, boolean hasHomeButton) {
        this.modelName = modelName;
        this.authMethod = authMethod;
        this.isPlus = isPlus;
        this.hasHomeButton = hasHomeButton;
    }

    @Override
    public Object getValueOf(String attributeName) {
        Object val;
        if ("authMethod".equals(attributeName)) {
            val = this.authMethod;
        } else if ("modelName".equals(attributeName)) {
            val = this.modelName;
        } else if ("isPlus".equals(attributeName)) {
            val = this.isPlus;
        } else if ("hasHomeButton".equals(attributeName)) {
            val = this.hasHomeButton;
        } else if ("hasFaceId".equals(attributeName)) {
            val = this.hasFaceId;
        } else {
            val = null;
        }

        return val;
    }
}
