package com.lukategames.gui.ui;

import com.lukategames.game.api.texture.Image;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;

public class Table extends JTable {

    private static final String[] columnNames = {"Property",
            "Value"};

    private static final Object[][] data = {
            {"Game", ""},
            {"Game Width", ""},
            {"Game Height", ""},
            {"Game Image", ""},
            {"Scene", ""},
            {"Layer", ""}
    };

    public Table() {
        super(data, columnNames);
        JComboBox bar = new JComboBox(columnNames);


        getModel().addTableModelListener(
                new TableModelListener()
                {
                    public void tableChanged(TableModelEvent evt)
                    {
                        if(evt.getColumn() == 1) {
                            if(evt.getFirstRow() == 1) {
                                MainPanel.width = Integer.parseInt(getValueAt(1,1).toString())/2;

                            }
                            if(evt.getFirstRow() == 2) {
                                MainPanel.height = Integer.parseInt(getValueAt(2,1).toString())/2;
                            }

                            if(evt.getFirstRow() == 3) {
                               String s = getValueAt(3,1).toString();
                               for(com.lukategames.gui.component.Image i : MainPanel.images) {
                                   if(i.getName().equals(s)) {
                                       try {
                                           BufferedImage before = ImageIO.read(new File(i.getPath()));
                                           int w = before.getWidth();
                                           int h = before.getHeight();
                                           BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
                                           AffineTransform at = new AffineTransform();
                                           at.scale(0.5, 0.5);
                                           AffineTransformOp scaleOp =
                                                   new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                                           after = scaleOp.filter(before, after);
                                           PreviewPanel.image = after;
                                       } catch (IOException e) {
                                           e.printStackTrace();
                                       }
                                   }
                               }
                            }
                        }
                    }
                });
    }

    @Override
    public TableCellEditor getCellEditor(int row, int column) {
        int modelColumn = convertColumnIndexToModel( column );

        if (modelColumn == 1 && row < 4)
        {
            JComboBox<String> comboBox1 = new JComboBox<String>();
            for(com.lukategames.gui.component.Image image : MainPanel.images) {
                comboBox1.addItem(image.getName());
            }
            return new DefaultCellEditor( comboBox1 );
        } else
            return super.getCellEditor(row, column);
    }
}
