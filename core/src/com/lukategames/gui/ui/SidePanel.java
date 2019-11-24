package com.lukategames.gui.ui;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class SidePanel extends JPanel {

    private ListPane listPane;
    private Table table;

    public SidePanel() {
        listPane = new ListPane();
        table = new Table();

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                listPane, table);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(100);
        add(splitPane);

    }
}
