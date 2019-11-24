package com.lukategames.gui;

import com.lukategames.gui.ui.MainPanel;

import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame() {
        setSize(500,500);
        add(new MainPanel());
        setTitle("GameDrive");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();
    }
}
