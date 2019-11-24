package com.lukategames.gui.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainBar extends JMenuBar {

    public MainBar() {
        JMenu menu = new JMenu("File");
        JMenuItem item = new JMenuItem("New");
        menu.add(item);
        add(menu);

        JMenu menu1 = new JMenu("New");
        JMenuItem item1 = new JMenuItem("Scene");
        JMenuItem item2 = new JMenuItem("Layer");
        JMenuItem item3 = new JMenuItem("Sprite");
        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);
        add(menu1);

        JMenu menu2 = new JMenu("Image");
        JMenuItem item4 = new JMenuItem("Add");
        menu2.add(item4);
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & PNG Images", "jpg", "png");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    MainPanel.images.add(new com.lukategames.gui.component.Image(chooser.getSelectedFile().getAbsolutePath(), chooser.getSelectedFile().getName()));
                }
            }
        });
        add(menu2);
    }

}
