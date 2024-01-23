package com.yeremeyev.java.common.windows.swing.components.base.tabbedpane;

import com.yeremeyev.java.common.windows.common.Colors;

import java.awt.Color;
import java.awt.Insets;

class TabbedPaneConstants {

    static final Color DEFAULT_TEXT_COLOR = Colors.BLACK_EARTH;
    static final Color DEFAULT_SELECTED_TEXT_COLOR = Colors.BLACK_EARTH;
    static final Color DEFAULT_BACKGROUND_COLOR = Colors.GRAY_HARBOR;
    static final Color DEFAULT_SELECTED_BACKGROUND_COLOR = Color.WHITE;
    static final Color DEFAULT_BORDER_COLOR = Colors.GAINSBORO;
    static final Color DEFAULT_SELECTED_BORDER_COLOR = Colors.SHADOW;
    static final Color DEFAULT_CONTENT_BORDER_COLOR = Colors.SHADOW;

    static final int DEFAULT_CONTENT_BORDER_WIDTH = 1;
    static final int DEFAULT_TAB_ITEM_HEIGHT = 24;
    static final int DEFAULT_TAB_ITEM_ARC = 6;
    static final int DEFAULT_TAB_ITEM_TEXT_OFFSET = 10;

    static final Insets DEFAULT_TAB_AREA_INSETS = new Insets(4, 3, 0, 0);
    static final Insets DEFAULT_CONTENT_BORDER_INSETS = new Insets(DEFAULT_CONTENT_BORDER_WIDTH, DEFAULT_CONTENT_BORDER_WIDTH, DEFAULT_CONTENT_BORDER_WIDTH, DEFAULT_CONTENT_BORDER_WIDTH);

    static final String TEXT_COLOR_NAME = "tabbed_pane_{}_text_color";
    static final String SELECTED_TEXT_COLOR_NAME = "tabbed_pane_{}_selected_text_color";
    static final String BACKGROUND_COLOR_NAME = "tabbed_pane_{}_background";
    static final String SELECTED_BACKGROUND_COLOR_NAME = "tabbed_pane_{}_selected_background";
    static final String BORDER_COLOR_NAME = "tabbed_pane_{}_border_color";
    static final String SELECTED_BORDER_COLOR_NAME = "tabbed_pane_{}_selected_border_color";
    static final String CONTENT_BORDER_COLOR_NAME = "tabbed_pane_{}_content_border_color";

    static final String CONTENT_BORDER_WIDTH_NAME = "tabbed_pane_{}_content_border_width";
    static final String TAB_ITEM_HEIGHT_NAME = "tabbed_pane_{}_tab_item_height";
    static final String TAB_ITEM_ARC_NAME = "tabbed_pane_{}_tab_item_arc";
    static final String TAB_ITEM_TEXT_OFFSET_NAME = "tabbed_pane_{}_tab_item_text_offset";

    static final String TAB_AREA_INSETS_NAME = "tabbed_pane_{}_tab_area_insets";
    static final String CONTENT_BORDER_INSETS_NAME = "tabbed_pane_{}_content_border_insets";
    static final String FONT_NAME = "tabbed_pane_{}_font";
}
