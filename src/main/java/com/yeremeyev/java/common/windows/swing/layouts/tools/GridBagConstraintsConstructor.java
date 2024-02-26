package com.yeremeyev.java.common.windows.swing.layouts.tools;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GridBagConstraintsConstructor extends GridBagConstraints {

    public GridBagConstraintsConstructor() {
        gridx = 0;
        gridy = 0;
        fillNone();
        setAnchor(GridBagConstraints.CENTER);
    }

    /**
     * move to next horizontal cell
     */
    public GridBagConstraintsConstructor nextCell() {
        gridx++;
        return this;
    }

    /**
     * move to next row and first cell
     */
    public GridBagConstraintsConstructor nextRow() {
        gridx = 0;
        gridy++;
        return this;
    }

    /**
     * set property to expand cell to the end of row
     */
    public GridBagConstraintsConstructor span() {
        gridwidth = GridBagConstraints.REMAINDER;
        return this;
    }

    /**
     * set how many cells should this component take up
     */
    public GridBagConstraintsConstructor span(int width) {
        gridwidth = width;
        return this;
    }

    /**
     * set property how to work with cell content
     */
    public GridBagConstraintsConstructor fillHorizontally() {
        fill = GridBagConstraints.HORIZONTAL;
        return this;
    }

    /**
     * set property how to work with cell content
     */
    public GridBagConstraintsConstructor fillNone() {
        fill = GridBagConstraints.NONE;
        return this;
    }

    /**
     * Specifies how to distribute extra horizontal and vertical space
     *
     * @param horizontal
     * @param vertical
     * @return
     */
    public GridBagConstraintsConstructor setWeights(float horizontal, float vertical) {
        weightx = horizontal;
        weighty = vertical;
        return this;
    }

    /**
     * possible values
     * FIRST_LINE_START	PAGE_START	FIRST_LINE_END
     * LINE_START	CENTER	LINE_END
     * LAST_LINE_START	PAGE_END	LAST_LINE_END
     *
     * @param anchor
     * @return
     */
    public GridBagConstraintsConstructor setAnchor(int anchor) {
        this.anchor = anchor;
        return this;
    }

    public GridBagConstraintsConstructor setInsets(Insets insets) {
        this.insets = insets;
        return this;
    }
}
