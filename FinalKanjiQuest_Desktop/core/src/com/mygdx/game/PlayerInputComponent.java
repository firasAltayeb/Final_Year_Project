package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

public class PlayerInputComponent extends InputComponent implements InputProcessor {

	private final static String TAG = PlayerInputComponent.class.getSimpleName();
	private Vector3 lastMouseCoordinates;

	public PlayerInputComponent(){
		//Gdx.app.debug(TAG, "Construction" );
		this.lastMouseCoordinates = new Vector3();
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void receiveMessage(String message) {
		String[] string = message.split(MESSAGE_TOKEN);

		if( string.length == 0 ) return;

		//Specifically for messages with 1 object payload
		if( string.length == 2 ) {
			if (string[0].equalsIgnoreCase(MESSAGE.CURRENT_DIRECTION.toString())) {
				currentDirection = json.fromJson(Entity.Direction.class, string[1]);
			}
		}
	}

	@Override
	public void dispose(){
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void update(Entity entity, float delta){
		//Keyboard input
		if( keys.get(Keys.LEFT)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.LEFT));
		}else if( keys.get(Keys.RIGHT)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.RIGHT));
		}else if( keys.get(Keys.UP)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.UP));
		}else if( keys.get(Keys.UP_LEFT)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.UP_LEFT));
		}else if( keys.get(Keys.UP_RIGHT)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.UP_RIGHT));
		} else if(keys.get(Keys.DOWN)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.DOWN));
		} else if(keys.get(Keys.DOWN_LEFT)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.DOWN_LEFT));
		} else if(keys.get(Keys.DOWN_RIGHT)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.DOWN_RIGHT));
		}
		else{
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.IDLE));
			if( currentDirection == null ){
				entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.DOWN));
			}
		}

		//Mouse input
		if( mouseButtons.get(Mouse.SELECT)) {
			//Gdx.app.debug(TAG, "Mouse LEFT click at : (" + lastMouseCoordinates.x + "," + lastMouseCoordinates.y + ")" );
			entity.sendMessage(MESSAGE.INIT_SELECT_ENTITY, json.toJson(lastMouseCoordinates));
			mouseButtons.put(Mouse.SELECT, false);
		}
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
		if( keycode == Input.Keys.DOWN || keycode == Input.Keys.X){
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
		if( keycode == Input.Keys.DOWN || keycode == Input.Keys.X){
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
	
	//Key presses
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
	
	//Releases
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

	public static void hide(){
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
		keys.put(Keys.UP, false);
		keys.put(Keys.DOWN, false);
		keys.put(Keys.QUIT, false);
	}

}
