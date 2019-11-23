package com.lukategames.game.api.actions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;

public class ActionManager {

    public static HashMap<String, Action> actions = new HashMap<>();

    public ActionManager(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);

            Gson gson = new GsonBuilder().registerTypeAdapter(ActionInit.class, new ActionJsonDeserializer()).create();

            ActionList list = gson.fromJson(reader, ActionList.class);

            for(ActionInit actionInit:  list.actions) {
               actions.put(actionInit.getName(), actionInit.getObject());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private class ActionList {
        private ActionInit[] actions;
    }

    private class ActionJsonDeserializer implements JsonDeserializer<ActionInit> {
        @Override
        public ActionInit deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            String type = json.getAsJsonObject().get("type").getAsString();
            switch(type) {
                case "Physics":
                    return context.deserialize(json, PhysicsInit.class);
                case "Shake":
                    return context.deserialize(json, ShakeInit.class);
                case "Move":
                    return context.deserialize(json, MoveInit.class);
                case "Fade":
                    return context.deserialize(json, FadeInit.class);
                default:
                    throw new IllegalArgumentException("Error");
            }
        }
    }
}
