package com.yeremeyev.java.common.windows.swing.tools;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Insets;

public class UIManagerTools {
    public static final int DEFAULT_INT_VALUE = 0;

    public static Color getColor(String name, Color defaultValue) {
        Color result = UIManager.getColor(name);
        if (result == null) {
            result = defaultValue;
        }
        return result;
    }

    public static int getInt(String name, int defaultValue) {
        int result = UIManager.getInt(name);
        if (result == DEFAULT_INT_VALUE) {
            result = defaultValue;
        }
        return result;
    }

    public static Insets getInsets(String name, Insets defaultValue) {
        Insets result = UIManager.getInsets(name);
        if (result == null) {
            result = defaultValue;
        }
        return result;
    }
}
