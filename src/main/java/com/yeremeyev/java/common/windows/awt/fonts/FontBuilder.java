package com.yeremeyev.java.common.windows.awt.fonts;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class FontBuilder {
    private static final int DEFAULT_FONT_SIZE = 12;
    private static final String DEFAULT_FONT_NAME = "Segoe UI";

    private Map<TextAttribute, Object> attributes;

    public FontBuilder() {
        attributes = new HashMap<>();

        withFamily(DEFAULT_FONT_NAME);
        withSize(DEFAULT_FONT_SIZE);
        withWeightRegular();
        withPostureRegular();
    }

    public FontBuilder withSize(int fontSize) {
        attributes.put(TextAttribute.SIZE, fontSize);
        return this;
    }

    public FontBuilder withFamily(String family) {
        attributes.put(TextAttribute.FAMILY, family);
        return this;
    }

    public FontBuilder withWeight(float weight) {
        attributes.put(TextAttribute.WEIGHT, weight);
        return this;
    }

    public FontBuilder withWeightRegular() {
        attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_REGULAR);
        return this;
    }

    public FontBuilder withWeightSemibold() {
        attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_SEMIBOLD);
        return this;
    }

    public FontBuilder withWeightBold() {
        attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
        return this;
    }

    public FontBuilder withPosture(float posture) {
        attributes.put(TextAttribute.POSTURE, posture);
        return this;
    }

    public FontBuilder withPostureRegular() {
        attributes.put(TextAttribute.POSTURE, TextAttribute.POSTURE_REGULAR);
        return this;
    }

    public FontBuilder withPostureItalic() {
        attributes.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
        return this;
    }


    public Font build() {
        return Font.getFont(attributes);
    }
}
