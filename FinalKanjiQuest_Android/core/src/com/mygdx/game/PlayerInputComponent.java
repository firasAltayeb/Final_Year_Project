package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.screens.MainGameScreen;

public class PlayerInputComponent extends InputComponent implements InputProcessor {

	private final static String TAG = PlayerInputComponent.class.getSimpleName();
	private Vector3 lastMouseCoordinates;
	boolean doNothing;
	int screenWidth;
	int screenHeight;
	int touchDownX;
	int touchDownY;

	public PlayerInputComponent(){
		Gdx.app.debug(TAG, "setInputProcessor this" );
		Gdx.input.setInputProcessor(this);
		this.lastMouseCoordinates = new Vector3();

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		touchDownX = 0;
		touchDownY = 0;
		doNothing = false;

	}

	@Override
	public void dispose() {
		Gdx.app.debug(TAG, "setInputProcessor null" );
		Gdx.input.setInputProcessor(null);
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
	public void update(Entity entity, float delta){

		//Keyboard input
		if(keys.get(Keys.PAUSE)) {
			System.out.println("INPUT PAUSED");
			MainGameScreen.setGameState(MainGameScreen.GameState.PAUSED);
			pauseReleased();
		}
		else if( keys.get(Keys.LEFT)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.LEFT));
		}else if( keys.get(Keys.RIGHT)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.RIGHT));
		}else if( keys.get(Keys.UP)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.UP));
		}else if(keys.get(Keys.DOWN)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.DOWN));
		} else if( keys.get(Keys.UP_LEFT)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.UP_LEFT));
		}else if( keys.get(Keys.UP_RIGHT)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.UP_RIGHT));
		} else if(keys.get(Keys.DOWN_LEFT)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.DOWN_LEFT));
		} else if(keys.get(Keys.DOWN_RIGHT)){
			entity.sendMessage(MESSAGE.CURRENT_STATE, json.toJson(Entity.State.WALKING));
			entity.sendMessage(MESSAGE.CURRENT_DIRECTION, json.toJson(Entity.Direction.DOWN_RIGHT));
		} else if(keys.get(Keys.QUIT)) {
			quitReleased();
			Gdx.app.exit();
		} else{
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
				keys.put(Keys.UP_LEFT, true);
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
				keys.put(Keys.UP, true);
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
				keys.put(Keys.UP_RIGHT, true);
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
				keys.put(Keys.LEFT, true);
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
				keys.put(Keys.RIGHT, true);
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
				keys.put(Keys.DOWN_LEFT, true);
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
				keys.put(Keys.DOWN, true);;
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
				keys.put(Keys.DOWN_RIGHT, true);;
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

	public void quitPressed(){
		keys.put(Keys.QUIT, true);
	}

	public void pausePressed() {
		keys.put(Keys.PAUSE, true);
	}
	
	public void quitReleased(){
		keys.put(Keys.QUIT, false);
	}

	public void pauseReleased() { keys.put(Keys.PAUSE, false);}

	public void setClickedMouseCoordinates(int x,int y){
		lastMouseCoordinates.set(x, y, 0);
	}

	public void selectMouseButtonPressed(int x, int y){
		mouseButtons.put(Mouse.SELECT, true);
	}
	
	public void selectMouseButtonReleased(int x, int y){
		mouseButtons.put(Mouse.SELECT, false);
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
	}

}
