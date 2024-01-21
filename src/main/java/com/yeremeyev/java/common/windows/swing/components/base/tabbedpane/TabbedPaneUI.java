package com.yeremeyev.java.common.windows.swing.components.base.tabbedpane;

import com.yeremeyev.java.common.windows.swing.tools.UIManagerTools;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Stroke;

class TabbedPaneUI extends BasicTabbedPaneUI {
    private String name;

    private Color textColor;
    private Color selectedTextColor;
    private Color backgroundColor;
    private Color selectedBackgroundColor;
    private Color borderColor;
    private Color selectedBorderColor;
    private Color contentBorderColor;

    private int contentBorderWidth;
    private int arc;
    private int tabItemHeight;
    private int tabItemTextOffset;
    private Insets contentBorderInsets;
    private Stroke contentBorderStroke;

    public TabbedPaneUI() {
        super();
    }

    /**
     * return tab item width
     */
    @Override
    protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
        if (tabPlacement == LEFT || tabPlacement == RIGHT) {
            return tabItemHeight;
        }
        return super.calculateTabWidth(tabPlacement, tabIndex, metrics);
    }

    /**
     * return tab item height
     */
    @Override
    protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
        if (tabPlacement == TOP || tabPlacement == BOTTOM) {
            return tabItemHeight;
        }
        String title = tabPane.getTitleAt(tabIndex);
        FontMetrics fontMetrics = getFontMetrics();
        int result = tabItemTextOffset * 2;
        result += fontMetrics.stringWidth(title);
        return result;
    }

    /*
     * by default draw rectangle area for focus item. override to exclude such effect
     */
    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
        // it is ok
    }

    @Override
    protected Insets getContentBorderInsets(int tabPlacement) {
        return contentBorderInsets;
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int width, int height, boolean isSelected) {
        Graphics2D graphics = (Graphics2D) g;
        Color background = isSelected ? selectedBackgroundColor : backgroundColor;
        graphics.setColor(background);

        graphics.fillRoundRect(x, y, width, height, arc, arc);
        switch (tabPlacement) {
            case LEFT:
                graphics.fillRect(x + arc, y, width - arc, height);
                break;
            case BOTTOM:
                graphics.fillRect(x, y, width, height - arc);
                break;
            case RIGHT:
                graphics.fillRect(x, y, width - arc, height);
                break;
            case TOP:
            default:
                graphics.fillRect(x, y + arc, width, height - arc);
        }
    }

    private void paintTopTabBorder(Graphics graphics, int x, int y, int w, int h) {
        int halfArc = arc / 2;
        graphics.drawLine(x + halfArc, y, x + w - halfArc, y);
        graphics.drawArc(x, y, arc, arc, 90, 90);
        graphics.drawLine(x, y + halfArc, x, y + h);
        graphics.drawArc(x + w - arc, y, arc, arc, 0, 90);
        graphics.drawLine(x + w, y + halfArc, x + w, y + h);
    }

    private void paintLeftTabBorder(Graphics graphics, int x, int y, int w, int h) {
        int halfArc = arc / 2;
        graphics.drawLine(x + halfArc, y, x + w, y);
        graphics.drawArc(x, y, arc, arc, 90, 90);
        graphics.drawLine(x, y + halfArc, x, y + h - halfArc);
        graphics.drawArc(x, y + h - arc, arc, arc, 180, 90);
        graphics.drawLine(x + halfArc, y + h, x + w, y + h);
    }

    private void paintBottomTabBorder(Graphics graphics, int x, int y, int w, int h) {
        int halfArc = arc / 2;
        graphics.drawLine(x + halfArc, y + h, x + w - halfArc, y + h);
        graphics.drawArc(x, y + h - arc, arc, arc, 180, 90);
        graphics.drawLine(x, y, x, y + h - halfArc);
        graphics.drawArc(x + w - arc, y + h - arc, arc, arc, 270, 90);
        graphics.drawLine(x + w, y, x + w, y + h - halfArc);
    }

    private void paintRightTabBorder(Graphics graphics, int x, int y, int w, int h) {
        int halfArc = arc / 2;
        graphics.drawLine(x, y, x + w - halfArc, y);
        graphics.drawArc(x - arc, y, arc, arc, 0, 90);
        graphics.drawLine(x + w, y + halfArc, x + w, y + h - halfArc);
        graphics.drawArc(x + w - arc, y + h - arc, arc, arc, 270, 90);
        graphics.drawLine(x, y + h, x + w - halfArc, y + h);
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int width, int height, boolean isSelected) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(isSelected ? selectedBorderColor : borderColor);

        switch (tabPlacement) {
            case LEFT:
                paintLeftTabBorder(graphics, x, y, width, height);
                break;
            case RIGHT:
                paintRightTabBorder(graphics, x, y, width, height);
                break;
            case BOTTOM:
                paintBottomTabBorder(graphics, x, y, width, height);
                break;
            case TOP:
            default:
                paintTopTabBorder(graphics, x, y, width, height);
        }
    }

    private void styleInitialize() {
        textColor = UIManagerTools.getColor(TabbedPaneSettings.getTextColorName(name), TabbedPaneConstants.DEFAULT_TEXT_COLOR);
        selectedTextColor = UIManagerTools.getColor(TabbedPaneSettings.getSelectedTextColorName(name), TabbedPaneConstants.DEFAULT_SELECTED_TEXT_COLOR);
        backgroundColor = UIManagerTools.getColor(TabbedPaneSettings.getBackgroundColorName(name), TabbedPaneConstants.DEFAULT_BACKGROUND_COLOR);
        selectedBackgroundColor = UIManagerTools.getColor(TabbedPaneSettings.getSelectedBackgroundColorName(name), TabbedPaneConstants.DEFAULT_SELECTED_BACKGROUND_COLOR);
        borderColor = UIManagerTools.getColor(TabbedPaneSettings.getBorderColorName(name), TabbedPaneConstants.DEFAULT_BORDER_COLOR);
        selectedBorderColor = UIManagerTools.getColor(TabbedPaneSettings.getSelectedBorderColorName(name), TabbedPaneConstants.DEFAULT_SELECTED_BORDER_COLOR);
        contentBorderColor = UIManagerTools.getColor(TabbedPaneSettings.getContentBorderColorName(name), TabbedPaneConstants.DEFAULT_CONTENT_BORDER_COLOR);

        contentBorderWidth = UIManagerTools.getInt(TabbedPaneSettings.getContentBorderWidthName(name), TabbedPaneConstants.DEFAULT_CONTENT_BORDER_WIDTH);
        tabItemHeight = UIManagerTools.getInt(TabbedPaneSettings.getTabItemHeightName(name), TabbedPaneConstants.DEFAULT_TAB_ITEM_HEIGHT);
        arc = UIManagerTools.getInt(TabbedPaneSettings.getTabItemArcName(name), TabbedPaneConstants.DEFAULT_TAB_ITEM_ARC);
        tabItemTextOffset = UIManagerTools.getInt(TabbedPaneSettings.getTabItemTextOffsetName(name), TabbedPaneConstants.DEFAULT_TAB_ITEM_TEXT_OFFSET);

        // offsets for tab items area
        tabAreaInsets = UIManagerTools.getInsets(TabbedPaneSettings.getTabAreaInsetsName(name), TabbedPaneConstants.DEFAULT_TAB_AREA_INSETS);
        contentBorderInsets = UIManagerTools.getInsets(TabbedPaneSettings.getContentBorderInsetsName(name), TabbedPaneConstants.DEFAULT_CONTENT_BORDER_INSETS);

        contentBorderStroke = new BasicStroke(contentBorderWidth);
    }

    @Override
    protected void installDefaults() {
        super.installDefaults();

        styleInitialize();
    }

    @Override
    public void installUI(JComponent component) {
        super.installUI(component);

        name = ((TabbedPane) component).getComponentName();
    }

    @Override
    public void uninstallUI(JComponent component) {
        super.uninstallUI(component);
    }

    @Override
    protected void paintContentBorderTopEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        Graphics2D graphics = (Graphics2D) g;
        Stroke originalStroke = graphics.getStroke();
        graphics.setStroke(contentBorderStroke);
        graphics.setColor(contentBorderColor);

        switch (tabPlacement) {
            case TOP:
                int widthBeforeSpace = tabAreaInsets.left;
                int spaceWidth = rects[selectedIndex].width;
                for (int i = 0; i < selectedIndex; i++) {
                    widthBeforeSpace += rects[i].width;
                }

                graphics.drawLine(x, y, x + widthBeforeSpace, y);
                graphics.drawLine(x + widthBeforeSpace + spaceWidth, y, x + w, y);
                break;
            case LEFT:
            case BOTTOM:
            case RIGHT:
            default:
                graphics.drawLine(x, y, x + w, y);
        }
        graphics.setStroke(originalStroke);
    }

    @Override
    protected void paintContentBorderBottomEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        Graphics2D graphics = (Graphics2D) g;
        Stroke originalStroke = graphics.getStroke();
        graphics.setStroke(contentBorderStroke);
        graphics.setColor(contentBorderColor);
        switch (tabPlacement) {
            case BOTTOM:
                int widthBeforeSpace = tabAreaInsets.left;
                int spaceWidth = rects[selectedIndex].width;
                for (int i = 0; i < selectedIndex; i++) {
                    widthBeforeSpace += rects[i].width;
                }

                graphics.drawLine(x, y + h - 1, x + widthBeforeSpace, y + h - 1);
                graphics.drawLine(x + widthBeforeSpace + spaceWidth, y + h - 1, x + w, y + h - 1);
                break;
            case LEFT:
            case RIGHT:
            case TOP:
            default:
                graphics.drawLine(x, y + h - 1, x + w, y + h - 1);
        }
        graphics.setStroke(originalStroke);
    }

    @Override
    protected void paintContentBorderLeftEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        Graphics2D graphics = (Graphics2D) g;
        Stroke originalStroke = graphics.getStroke();
        graphics.setStroke(contentBorderStroke);
        graphics.setColor(contentBorderColor);

        switch (tabPlacement) {
            case LEFT:
                int widthBeforeSpace = tabAreaInsets.left;
                int spaceWidth = rects[selectedIndex].height;
                for (int i = 0; i < selectedIndex; i++) {
                    widthBeforeSpace += rects[i].height;
                }

                graphics.drawLine(x, y, x, y + widthBeforeSpace);
                graphics.drawLine(x, y + widthBeforeSpace + spaceWidth, x, y + h);
                break;
            case RIGHT:
            case BOTTOM:
            case TOP:
            default:
                graphics.drawLine(x, y, x, y + h);
        }

        graphics.setStroke(originalStroke);
    }

    @Override
    protected void paintContentBorderRightEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        Graphics2D graphics = (Graphics2D) g;
        Stroke originalStroke = graphics.getStroke();
        graphics.setStroke(contentBorderStroke);
        graphics.setColor(contentBorderColor);

        switch (tabPlacement) {
            case RIGHT:
                int widthBeforeSpace = tabAreaInsets.left;
                int spaceWidth = rects[selectedIndex].height;
                for (int i = 0; i < selectedIndex; i++) {
                    widthBeforeSpace += rects[i].height;
                }

                graphics.drawLine(x + w - 1, y, x + w - 1, y + widthBeforeSpace);
                graphics.drawLine(x + w - 1, y + widthBeforeSpace + spaceWidth, x + w - 1, y + h);
                break;
            case LEFT:
            case BOTTOM:
            case TOP:
            default:
                graphics.drawLine(x + w - 1, y, x + w - 1, y + h);
        }

        graphics.setStroke(originalStroke);
    }

    @Override
    protected void paintText(Graphics g, int tabPlacement,
                             Font font, FontMetrics metrics, int tabIndex,
                             String title, Rectangle textRect,
                             boolean isSelected)
    {
        g.setColor(isSelected ? this.selectedTextColor : this.textColor);

        if (tabPlacement == TOP || tabPlacement == BOTTOM) {
            super.paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);
            return;
        }

        Graphics2D graphics = (Graphics2D) g;

        int x = textRect.x;
        int y = textRect.y;
        FontMetrics fontMetrics = getFontMetrics();
        int halfHeight = fontMetrics.getHeight() / 2;

        int angle = tabPlacement == RIGHT ? 90 : -90;
        int xCorrecition = fontMetrics.stringWidth(title) / 2;
        xCorrecition += tabPlacement == RIGHT ? -halfHeight : halfHeight;
        int yCorrecition = tabPlacement == RIGHT ? -tabItemHeight / 2 + halfHeight : tabItemHeight / 2;

        graphics.translate((float) x, (float) y);
        graphics.rotate(Math.toRadians(angle));
        graphics.drawString(title, -xCorrecition, yCorrecition);
        graphics.rotate(-Math.toRadians(angle));
        graphics.translate(-(float) x, -(float) y);
    }
}
