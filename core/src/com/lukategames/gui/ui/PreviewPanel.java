package com.lukategames.gui.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import javax.swing.JPanel;

public class PreviewPanel extends JPanel implements Runnable {

    private boolean running;
    public static BufferedImage image;
    public static RescaleOp rop;

    public PreviewPanel() {
        Thread thread = new Thread(this);
        thread.setPriority(Thread.MAX_PRIORITY);
        running = true;
        thread.start();

        float[] scales = { 0.5f, 0.5f, 0.5f, 1f};
        float[] offsets = new float[4];
         rop = new RescaleOp(scales, offsets, null);
    }


    @Override
    public void run() {
        while(running) {
            repaint();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.WHITE);
        float centX = getWidth()/2;
        float centY = getHeight()/2;

        graphics.fillRect(getWidth()/2 - MainPanel.width/2, getHeight()/2 - MainPanel.height/2, MainPanel.width, MainPanel.height);
        if(image != null) {
            graphics.drawImage(image, (int) centX - image.getWidth() / 2, (int) centY - image.getHeight() / 2, null);
        }
    }
}
