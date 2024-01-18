package com.yeremeyev.java.common.windows.swing.components.base.tabbedpane;

import com.yeremeyev.java.common.windows.swing.components.interfaces.Component;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

/**
 * custom JTabbedPane implementation
 */
public class TabbedPane extends JTabbedPane implements Component {
    static final String DEFAULT_NAME = "default";

    private String name;

    public TabbedPane(String name, int tabPlacement) {
        // JTabbedPane.SCROLL_TAB_LAYOUT means the same height for tab items.
        super(tabPlacement, JTabbedPane.SCROLL_TAB_LAYOUT);

        this.name = name;
        setUI(new TabbedPaneUI());
    }

    public TabbedPane(int tabPlacement) {
        this(DEFAULT_NAME, tabPlacement);
    }

    public TabbedPane() {
        this(DEFAULT_NAME, SwingConstants.TOP);
    }

    @Override
    public String getComponentName() {
        return name;
    }

    @Override
    public void closeComponent() {
    }
}
