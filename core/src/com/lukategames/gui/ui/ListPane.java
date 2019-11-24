package com.lukategames.gui.ui;

import java.awt.Dimension;

import javax.swing.JList;

public class ListPane extends JList {

    private static String[] componentTypes =  { "Sprite","Scene","Layer"};

    public ListPane() {
        super(componentTypes);
        setMinimumSize(new Dimension(200,200));
    }
}
