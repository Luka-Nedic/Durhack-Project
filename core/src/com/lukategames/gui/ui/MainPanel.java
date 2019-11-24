package com.lukategames.gui.ui;

import com.lukategames.game.api.texture.ImageInit;
import com.lukategames.gui.component.Component;
import com.lukategames.gui.component.Image;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

    public static int width;
    public static int height;
    public static ArrayList<Component> components = new ArrayList<>();
    public static ArrayList<Image> images = new ArrayList<>();

    public MainPanel() {
        setLayout(new BorderLayout());
        add(new MainBar(), BorderLayout.NORTH);
        add(new PreviewPanel(), BorderLayout.CENTER);
        add(new Table(), BorderLayout.LINE_START);
    }

}
