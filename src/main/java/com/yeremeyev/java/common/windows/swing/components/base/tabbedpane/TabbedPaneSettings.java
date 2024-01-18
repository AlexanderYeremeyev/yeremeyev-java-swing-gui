package com.yeremeyev.java.common.windows.swing.components.base.tabbedpane;

public class TabbedPaneSettings {

    public static String getBackgroundColorName(String name) {
        return String.format(TabbedPaneConstants.BACKGROUND_COLOR_NAME, name);
    }

    public static String getBackgroundColorName() {
        return getBackgroundColorName(TabbedPane.DEFAULT_NAME);
    }

    public static String getSelectedBackgroundColorName(String name) {
        return String.format(TabbedPaneConstants.SELECTED_BACKGROUND_COLOR_NAME, name);
    }

    public static String getSelectedBackgroundColorName() {
        return getSelectedBackgroundColorName(TabbedPane.DEFAULT_NAME);
    }

    public static String getBorderColorName(String name) {
        return String.format(TabbedPaneConstants.BORDER_COLOR_NAME, name);
    }

    public static String getBorderColorName() {
        return getBorderColorName(TabbedPane.DEFAULT_NAME);
    }

    public static String getSelectedBorderColorName(String name) {
        return String.format(TabbedPaneConstants.SELECTED_BORDER_COLOR_NAME, name);
    }

    public static String getSelectedBorderColorName() {
        return getSelectedBorderColorName(TabbedPane.DEFAULT_NAME);
    }

    public static String getContentBorderColorName(String name) {
        return String.format(TabbedPaneConstants.CONTENT_BORDER_COLOR_NAME, name);
    }

    public static String getContentBorderColorName() {
        return getContentBorderColorName(TabbedPane.DEFAULT_NAME);
    }

    public static String getContentBorderWidthName(String name) {
        return String.format(TabbedPaneConstants.CONTENT_BORDER_WIDTH_NAME, name);
    }

    public static String getContentBorderWidthName() {
        return getContentBorderWidthName(TabbedPane.DEFAULT_NAME);
    }

    public static String getTabItemHeightName(String name) {
        return String.format(TabbedPaneConstants.TAB_ITEM_HEIGHT_NAME, name);
    }

    public static String getTabItemHeightName() {
        return getTabItemHeightName(TabbedPane.DEFAULT_NAME);
    }

    public static String getTabItemArcName(String name) {
        return String.format(TabbedPaneConstants.TAB_ITEM_ARC_NAME, name);
    }

    public static String getTabItemArcName() {
        return getTabItemArcName(TabbedPane.DEFAULT_NAME);
    }

    public static String getTabAreaInsetsName(String name) {
        return String.format(TabbedPaneConstants.TAB_AREA_INSETS_NAME, name);
    }

    public static String getTabAreaInsetsName() {
        return getTabAreaInsetsName(TabbedPane.DEFAULT_NAME);
    }

    public static String getContentBorderInsetsName(String name) {
        return String.format(TabbedPaneConstants.CONTENT_BORDER_INSETS_NAME, name);
    }

    public static String getContentBorderInsetsName() {
        return getContentBorderInsetsName(TabbedPane.DEFAULT_NAME);
    }
}
