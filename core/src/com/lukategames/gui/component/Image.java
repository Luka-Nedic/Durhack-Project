package com.lukategames.gui.component;

public class Image {

    private String path;
    private String name;

    public Image(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }
}
