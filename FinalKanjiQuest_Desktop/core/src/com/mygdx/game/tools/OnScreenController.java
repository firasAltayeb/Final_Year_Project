package com.mygdx.game.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.PlayerInputComponent;


/**
 * Created by firas on 14/12/2016.
 */

public class OnScreenController {

    private final static String TAG = OnScreenController.class.getSimpleName();

    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;

    private Image buttonUp;
    private Image buttonDown;
    private Image buttonLeft;
    private Image buttonRight;

    private Table tableDirectional;


    public OnScreenController(Stage stage) {

        //Directional buttons with images.
        buttonUp = new Image(new Texture("sprites/buttonup.png"));
        buttonUp.setSize(35, 35);
        buttonUp.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = false;
            }
        });

        buttonDown = new Image(new Texture("sprites/buttondown.png"));
        buttonDown.setSize(35, 35);
        buttonDown.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log(TAG, "button down touchDown is pressed");
                downPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log(TAG, "button down touch up is pressed");
                downPressed = false;
            }
        });

        buttonLeft = new Image(new Texture("sprites/buttonleft.png"));
        buttonLeft.setSize(35, 35);
        buttonLeft.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = false;
            }
        });

        buttonRight = new Image(new Texture("sprites/buttonright.png"));
        buttonRight.setSize(35, 35);
        buttonRight.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = false;
            }
        });

        //Table with directional buttons.
        tableDirectional = new Table();
        tableDirectional.setFillParent(true);
        //tableDirectional.setDebug(true); //Render debug lines.
        tableDirectional.left().bottom().pad(5, 5, 5, 5); //Align to the left bottom.
        tableDirectional.add().space(5);
        tableDirectional.add(buttonUp).size(buttonUp.getWidth(), buttonUp.getHeight()).space(5);
        tableDirectional.add().space(5);
        tableDirectional.row();
        tableDirectional.add(buttonLeft).size(buttonLeft.getWidth(), buttonLeft.getHeight()).space(5);
        tableDirectional.add().space(5);
        tableDirectional.add(buttonRight).size(buttonRight.getWidth(), buttonRight.getHeight()).space(5);
        tableDirectional.row();
        tableDirectional.add().space(5);
        tableDirectional.add(buttonDown).size(buttonDown.getWidth(), buttonDown.getHeight()).space(5);
        tableDirectional.add().space(5);

        stage.addActor(tableDirectional);

    }

    //Getters.
    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public Table getTableDirectional() {
        return tableDirectional;
    }
}
