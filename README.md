# yeremeyev java swing gui
## Description
library provide base swing components with rich style settings 
## Configuration
default java is 17<br/>
compile under java 8
## Components
### TabbedPane

#### how to use 
just create new com.yeremeyev.java.common.windows.swing.components.base.tabbedpane.TabbedPane()

#### work with style
use default style or custom component name

to use custom style on application start set up needed style using UIManager.<br/>
possible style settings may be achieved with TabbedPaneSettings

<i>
UIManager.put(TabbedPaneSettings.getBackgroundColorName(), Colors.GRAY_HARBOR);
UIManager.put(TabbedPaneSettings.getSelectedBackgroundColorName(), Color.WHITE);
UIManager.put(TabbedPaneSettings.getBorderColorName(), Colors.LIGHT_SLATE_GRAY);
UIManager.put(TabbedPaneSettings.getSelectedBorderColorName(), Colors.DEEP_BLACK_SEA);
UIManager.put(TabbedPaneSettings.getContentBorderColorName(), Color.RED);
UIManager.put(TabbedPaneSettings.getContentBorderWidthName(), 1);
UIManager.put(TabbedPaneSettings.getTabItemHeightName(), 28);
UIManager.put(TabbedPaneSettings.getTabItemArcName(), 8);
UIManager.put(TabbedPaneSettings.getTabAreaInsetsName(), new Insets(4, 3, 0, 0));
UIManager.put(TabbedPaneSettings.getContentBorderInsetsName(), new Insets(1, 1, 1, 1));
</i>