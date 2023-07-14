package com.mygdx.game.old_files;

/*
  Created by firasAltayeb on 02/03/2017.


import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;


public class PlayerController implements InputProcessor {

    private final static String TAG = PlayerController.class.getSimpleName();

    enum Keys {
        LEFT, RIGHT, UP, DOWN,
        UP_RIGHT, UP_LEFT, DOWN_RIGHT, DOWN_LEFT
    }

    enum Mouse {
        SELECT, DOACTION
    }

    private static Map<Keys, Boolean> keys = new HashMap<PlayerController.Keys, Boolean>();
    private static Map<Mouse, Boolean> mouseButtons = new HashMap<PlayerController.Mouse, Boolean>();
    private Vector3 lastMouseCoordinates;

    //initialize the hashmap for inputs
    static {
        keys.put(Keys.LEFT, false);
        keys.put(Keys.RIGHT, false);
        keys.put(Keys.UP, false);
        keys.put(Keys.DOWN, false);
        keys.put(Keys.UP_RIGHT, false);
        keys.put(Keys.UP_LEFT, false);
        keys.put(Keys.DOWN_RIGHT, false);
        keys.put(Keys.DOWN_LEFT, false);
    };

    static {
        mouseButtons.put(Mouse.SELECT, false);
        mouseButtons.put(Mouse.DOACTION, false);
    };

    private Entity player;

    public PlayerController(Entity player){
        //Gdx.app.debug(TAG, "Construction" );
        this.lastMouseCoordinates = new Vector3();
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {
        if( keycode == Input.Keys.LEFT || keycode == Input.Keys.A){
            this.leftPressed();
        }
        if( keycode == Input.Keys.RIGHT || keycode == Input.Keys.D){
            this.rightPressed();
        }
        if( keycode == Input.Keys.UP || keycode == Input.Keys.W){
            this.upPressed();
        }
        if( keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
            this.downPressed();
        }
        if( keycode == Input.Keys.Q){
            this.upLeftPressed();

        }if( keycode == Input.Keys.E){
            this.upRightPressed();

        }if( keycode == Input.Keys.C){
            this.downRightPressed();

        }if( keycode == Input.Keys.Z){
            this.downLeftPressed();

        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if( keycode == Input.Keys.LEFT || keycode == Input.Keys.A){
            this.leftReleased();
        }
        if( keycode == Input.Keys.RIGHT || keycode == Input.Keys.D){
            this.rightReleased();
        }
        if( keycode == Input.Keys.UP || keycode == Input.Keys.W ){
            this.upReleased();
        }
        if( keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
            this.downReleased();
        }
        if( keycode == Input.Keys.Q){
            this.upLeftReleased();

        }if( keycode == Input.Keys.E){
            this.upRightReleased();

        }if( keycode == Input.Keys.C){
            this.downRightReleased();

        }if( keycode == Input.Keys.Z){
            this.downLeftReleased();

        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //Gdx.app.debug(TAG, "GameScreen: MOUSE DOWN........: (" + screenX + "," + screenY + ")" );

        if( button == Input.Buttons.LEFT || button == Input.Buttons.RIGHT ){
            this.setClickedMouseCoordinates(screenX, screenY);
        }

        //left is selection, right is context menu
        if( button == Input.Buttons.LEFT){
            this.selectMouseButtonPressed(screenX, screenY);
        }
        if( button == Input.Buttons.RIGHT){
            this.doActionMouseButtonPressed(screenX, screenY);
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        //left is selection, right is context menu
        if( button == Input.Buttons.LEFT){
            this.selectMouseButtonReleased(screenX, screenY);
        }
        if( button == Input.Buttons.RIGHT){
            this.doActionMouseButtonReleased(screenX, screenY);
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    //presses
    public void leftPressed(){
        keys.put(Keys.LEFT, true);
    }

    public void rightPressed(){
        keys.put(Keys.RIGHT, true);
    }

    public void upPressed(){
        keys.put(Keys.UP, true);
    }

    public void downPressed(){
        keys.put(Keys.DOWN, true);
    }

    public void upRightPressed(){
        keys.put(Keys.UP_RIGHT, true);
    }

    public void upLeftPressed(){
        keys.put(Keys.UP_LEFT, true);
    }

    public void downRightPressed(){
        keys.put(Keys.DOWN_RIGHT, true);
    }

    public void downLeftPressed(){
        keys.put(Keys.DOWN_LEFT, true);
    }

    public void setClickedMouseCoordinates(int x,int y){
        lastMouseCoordinates.set(x, y, 0);
    }

    public void selectMouseButtonPressed(int x, int y){
        mouseButtons.put(Mouse.SELECT, true);
    }

    public void doActionMouseButtonPressed(int x, int y){
        mouseButtons.put(Mouse.DOACTION, true);
    }

    //releases
    public void leftReleased(){
        keys.put(Keys.LEFT, false);
    }

    public void rightReleased(){
        keys.put(Keys.RIGHT, false);
    }

    public void upReleased(){
        keys.put(Keys.UP, false);
    }

    public void downReleased(){
        keys.put(Keys.DOWN, false);
    }

    public void upRightReleased(){
        keys.put(Keys.UP_RIGHT, false);
    }

    public void upLeftReleased(){
        keys.put(Keys.UP_LEFT, false);
    }

    public void downRightReleased(){
        keys.put(Keys.DOWN_RIGHT, false);
    }

    public void downLeftReleased(){
        keys.put(Keys.DOWN_LEFT, false);
    }


    public void selectMouseButtonReleased(int x, int y){
        mouseButtons.put(Mouse.SELECT, false);
    }

    public void doActionMouseButtonReleased(int x, int y){
        mouseButtons.put(Mouse.DOACTION, false);
    }

    public void update(float delta){
        //Gdx.app.debug(TAG, "update:: Next Position: (" + player.getNextPosition().x
        // + "," + player.getNextPosition().y + ")" + "DELTA: " + delta);
        processInput(delta);
    }

    public static void hide(){
        keys.put(Keys.LEFT, false);
        keys.put(Keys.RIGHT, false);
        keys.put(Keys.UP, false);
        keys.put(Keys.DOWN, false);
        keys.put(Keys.UP_RIGHT, false);
        keys.put(Keys.UP_LEFT, false);
        keys.put(Keys.DOWN_RIGHT, false);
        keys.put(Keys.DOWN_LEFT, false);
    }

    private void processInput(float delta){

        //Keyboard input
        if( keys.get(Keys.LEFT)){
            //Gdx.app.debug(TAG, "LEFT key");
            player.calculateNextPosition(Entity.Direction.LEFT, delta);
            player.setState(Entity.State.WALKING);
            player.setDirection(Entity.Direction.LEFT, delta);
        }else if( keys.get(Keys.RIGHT)){
            //Gdx.app.debug(TAG, "RIGHT key");
            player.calculateNextPosition(Entity.Direction.RIGHT, delta);
            player.setState(Entity.State.WALKING);
            player.setDirection(Entity.Direction.RIGHT, delta);
        }else if( keys.get(Keys.UP)){
            //Gdx.app.debug(TAG, "UP key");
            player.calculateNextPosition(Entity.Direction.UP, delta);
            player.setState(Entity.State.WALKING);
            player.setDirection(Entity.Direction.UP, delta);
        }else if(keys.get(Keys.DOWN)){
            //Gdx.app.debug(TAG, "DOWN key");
            player.calculateNextPosition(Entity.Direction.DOWN, delta);
            player.setState(Entity.State.WALKING);
            player.setDirection(Entity.Direction.DOWN, delta);
        }
        else if(keys.get(Keys.UP_RIGHT)){
            //Gdx.app.debug(TAG, "E key");
            player.calculateNextPosition(Entity.Direction.UP_RIGHT, delta);
            player.setState(Entity.State.WALKING);
            player.setDirection(Entity.Direction.UP_RIGHT, delta);
        }
        else if(keys.get(Keys.UP_LEFT)){
            //Gdx.app.debug(TAG, "Q key");
            player.calculateNextPosition(Entity.Direction.UP_LEFT, delta);
            player.setState(Entity.State.WALKING);
            player.setDirection(Entity.Direction.UP_LEFT, delta);
        }
        else if(keys.get(Keys.DOWN_RIGHT)){
            //Gdx.app.debug(TAG, "C key");
            player.calculateNextPosition(Entity.Direction.DOWN_RIGHT, delta);
            player.setState(Entity.State.WALKING);
            player.setDirection(Entity.Direction.DOWN_RIGHT, delta);
        }
        else if(keys.get(Keys.DOWN_LEFT)){
            //Gdx.app.debug(TAG, "Z key");
            player.calculateNextPosition(Entity.Direction.DOWN_LEFT, delta);
            player.setState(Entity.State.WALKING);
            player.setDirection(Entity.Direction.DOWN_LEFT, delta);
        }
        else{
            player.setState(Entity.State.IDLE);
        }

        //Mouse input
        if( mouseButtons.get(Mouse.SELECT)) {
            //Gdx.app.debug(TAG, "Mouse LEFT click at : (" + lastMouseCoordinates.x + "," + lastMouseCoordinates.y + ")" );
            mouseButtons.put(Mouse.SELECT, false);
        }

    }

}
*/