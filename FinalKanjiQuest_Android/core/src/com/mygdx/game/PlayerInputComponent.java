package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

public class PlayerInputComponent extends InputComponent implements InputProcessor {

	private final static String TAG = PlayerInputComponent.class.getSimpleName();
	private Vector3 lastMouseCoordinates;
	boolean doNothing;
	int screenWidth;
	int screenHeight;
	int touchDownX;
	int touchDownY;

	public PlayerInputComponent(){
		//Gdx.app.log(TAG, "Construction" );
		this.lastMouseCoordinates = new Vector3();
		Gdx.input.setInputProcessor(this);

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		touchDownX = 0;
		touchDownY = 0;
		doNothing = false;
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
			//Gdx.app.log(TAG, "Mouse LEFT click at : (" + lastMouseCoordinates.x + "," + lastMouseCoordinates.y + ")" );
			entity.sendMessage(MESSAGE.INIT_SELECT_ENTITY, json.toJson(lastMouseCoordinates));
			mouseButtons.put(Mouse.SELECT, false);
		}
	}

	@Override
	public boolean keyDown(int keycode) {
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		touchDownX = screenX;
		touchDownY = screenY;
		this.selectMouseButtonPressed(screenX, screenY);
		this.setClickedMouseCoordinates(screenX, screenY);
		Gdx.app.log(TAG, "touch down : (x == " + touchDownX + ", y ==" + touchDownY + ")" );

		//top left corner
		if((screenX >= 0 && screenX <= screenWidth/3) &&
				(screenY >= 0 && screenY <= screenHeight/3)){
			if (keys.get(Keys.UP) || keys.get(Keys.DOWN) || keys.get(Keys.RIGHT) ||
					keys.get(Keys.LEFT) || keys.get(Keys.UP_RIGHT) ||keys.get(Keys.DOWN_RIGHT) ||
					keys.get(Keys.DOWN_LEFT)) {
				doNothing = true;
				Gdx.app.log(TAG, "top left doNothing is " + doNothing);
			}
			else {
				Gdx.app.log(TAG, "up left pressed ");
				this.upLeftPressed();
			}
		}

		//top center
		if((screenX >= screenWidth/3 && screenX <= screenWidth/1.5) &&
				(screenY >= 0 && screenY <= screenHeight/3)){
			if (keys.get(Keys.DOWN) || keys.get(Keys.RIGHT) ||
					keys.get(Keys.LEFT) || keys.get(Keys.UP_RIGHT) || keys.get(Keys.UP_LEFT) ||keys.get(Keys.DOWN_RIGHT) ||
					keys.get(Keys.DOWN_LEFT)) {
				doNothing = true;
				Gdx.app.log(TAG, "up doNothing is " + doNothing);
			}
			else {
				Gdx.app.log(TAG, "up pressed ");
				this.upPressed();
			}
		}

		//top right corner
		if((screenX >= screenWidth/1.5 && screenX <= screenWidth) &&
				(screenY >= 0 && screenY <= screenHeight/3)){
			if (keys.get(Keys.UP) || keys.get(Keys.DOWN) || keys.get(Keys.RIGHT) ||
					keys.get(Keys.LEFT) || keys.get(Keys.UP_LEFT) ||keys.get(Keys.DOWN_RIGHT) ||
					keys.get(Keys.DOWN_LEFT)) {
				doNothing = true;
				Gdx.app.log(TAG, "top right doNothing is " + doNothing);
			}
			else {
				Gdx.app.log(TAG, "up right pressed ");
				this.upRightPressed();
			}
		}

		//center's left
		if((screenX >= 0 && screenX <= screenWidth/3) &&
				(screenY >= screenHeight/3 && screenY <= screenHeight/1.5)){
			if (keys.get(Keys.UP) || keys.get(Keys.DOWN) || keys.get(Keys.RIGHT) ||
					keys.get(Keys.UP_RIGHT) || keys.get(Keys.UP_LEFT) ||keys.get(Keys.DOWN_RIGHT) ||
					keys.get(Keys.DOWN_LEFT)) {
				doNothing = true;
				Gdx.app.log(TAG, "left doNothing is " + doNothing);

			}
			else {
				Gdx.app.log(TAG, "left pressed ");
				this.leftPressed();
			}
		}
		//center
		if((screenX >= screenWidth/3  && screenX <= screenWidth/1.5) &&
				(screenY >= screenHeight/3 && screenY <= screenHeight/1.5)){
			//do nothing for now
			doNothing = true;
			Gdx.app.log(TAG, "center doNothing is " + doNothing);
		}

		//center's right pressed
		if((screenX >= screenWidth/1.5 && screenX <= screenWidth) &&
				(screenY >= screenHeight/3 && screenY <= screenHeight/1.5)){
			if (keys.get(Keys.UP) || keys.get(Keys.DOWN) || keys.get(Keys.LEFT) ||
					keys.get(Keys.UP_RIGHT) || keys.get(Keys.UP_LEFT) ||keys.get(Keys.DOWN_RIGHT) ||
					keys.get(Keys.DOWN_LEFT)) {
				doNothing = true;
				Gdx.app.log(TAG, "right doNothing is " + doNothing);
			}
			else {
				Gdx.app.log(TAG, "right pressed ");
				this.rightPressed();
			}
		}

		//bottom left corner
		if((screenX >= 0 && screenX <= screenWidth/3) &&
				(screenY >= screenHeight/1.5 && screenY <= screenHeight)){
			if (keys.get(Keys.UP) || keys.get(Keys.DOWN) || keys.get(Keys.RIGHT) ||
					keys.get(Keys.LEFT) || keys.get(Keys.UP_RIGHT) || keys.get(Keys.UP_LEFT) ||
					keys.get(Keys.DOWN_RIGHT)) {
				doNothing = true;
				Gdx.app.log(TAG, "down left doNothing is " + doNothing);
			}
			else {
				Gdx.app.log(TAG, "down left pressed ");
				this.downLeftPressed();
			}
		}

		//bottom center
		if((screenX >= screenWidth/3 && screenX <= screenWidth/1.5) &&
				(screenY >= screenHeight/1.5 && screenY <= screenHeight)){
			if (keys.get(Keys.UP) || keys.get(Keys.RIGHT) || keys.get(Keys.LEFT) ||
					keys.get(Keys.UP_RIGHT) || keys.get(Keys.UP_LEFT) ||keys.get(Keys.DOWN_RIGHT) ||
					keys.get(Keys.DOWN_LEFT)) {
				doNothing = true;
				Gdx.app.log(TAG, "down doNothing is " + doNothing);
			}
			else {
				Gdx.app.log(TAG, "down pressed ");
				this.downPressed();
			}
		}

		//bottom right corner
		if((screenX >= screenWidth/1.5 && screenX <= screenWidth) &&
				(screenY >= screenHeight/1.5 && screenY <= screenHeight)){
			if (keys.get(Keys.UP) || keys.get(Keys.DOWN) || keys.get(Keys.RIGHT) ||
					keys.get(Keys.LEFT) || keys.get(Keys.UP_RIGHT) || keys.get(Keys.UP_LEFT) ||
					keys.get(Keys.DOWN_LEFT)) {
				doNothing = true;
				Gdx.app.log(TAG, "down right doNothing is " + doNothing);
			}
			else {
				Gdx.app.log(TAG, "down right pressed ");
				this.downRightPressed();
			}
		}

		Gdx.app.log(TAG, "touch down returned" );

		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		this.selectMouseButtonReleased(screenX, screenY);

		//Gdx.app.log(TAG, "touch up : ( x == " + screenX + ", y ==" + screenY + ")" );
		Gdx.app.log(TAG, "touch up inaction, doNothing: " + doNothing);

		if(doNothing){
			// do nothing
			//Gdx.app.log(TAG, "doing nothing" );
		}
		else {
			//Gdx.app.log(TAG, "hide() called" );
			hide();
		}

		doNothing = false;

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
		Gdx.app.log(TAG, "hide() inaction" );
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
		keys.put(Keys.UP, false);
		keys.put(Keys.DOWN, false);
		keys.put(Keys.UP_RIGHT, false);
		keys.put(Keys.UP_LEFT, false);
		keys.put(Keys.DOWN_RIGHT, false);
		keys.put(Keys.DOWN_LEFT, false);
		keys.put(Keys.QUIT, false);
	}

}
