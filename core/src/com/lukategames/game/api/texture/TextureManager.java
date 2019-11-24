package com.lukategames.game.api.texture;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class TextureManager {

    public static HashMap<String, Image> images = new HashMap<String, Image>();

    public static void load(Gson gson, String fileName) {

        try {
            FileReader reader = new FileReader(fileName);
            TextureList list = gson.fromJson(reader, TextureList.class);

            for(com.lukategames.game.api.texture.ImageInit imageInit : list.images) {
                images.put(imageInit.getName(), imageInit.getObject());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private class TextureList {

        private com.lukategames.game.api.texture.ImageInit[] images;
    }

}
