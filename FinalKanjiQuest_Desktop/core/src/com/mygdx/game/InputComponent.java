package com.mygdx.game;

import com.badlogic.gdx.utils.Json;

import java.util.HashMap;
import java.util.Map;

public abstract class InputComponent implements Component {

    protected Entity.Direction currentDirection = null;
    protected Entity.State currentState = null;
    protected Json json;

    protected enum Keys {
        LEFT, RIGHT, UP, DOWN, QUIT,
        UP_RIGHT, UP_LEFT, DOWN_RIGHT, DOWN_LEFT
    }

    protected enum Mouse {
        SELECT, DOACTION
    }

    protected static Map<Keys, Boolean> keys = new HashMap<Keys, Boolean>();
    protected static Map<Mouse, Boolean> mouseButtons = new HashMap<Mouse, Boolean>();

    //initialize the hashmap for inputs
    static {
        keys.put(Keys.LEFT, false);
        keys.put(Keys.RIGHT, false);
        keys.put(Keys.UP, false);
        keys.put(Keys.DOWN, false);
        keys.put(Keys.UP_LEFT, false);
        keys.put(Keys.UP_RIGHT, false);
        keys.put(Keys.DOWN_LEFT, false);
        keys.put(Keys.DOWN_RIGHT, false);
        keys.put(Keys.QUIT, false);
    };

    static {
        mouseButtons.put(Mouse.SELECT, false);
        mouseButtons.put(Mouse.DOACTION, false);
    };

    InputComponent(){
        json = new Json();
    }

    public abstract void update(Entity entity, float delta);

}
