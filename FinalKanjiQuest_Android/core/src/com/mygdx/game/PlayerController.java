package com.mygdx.game;


import java.util.HashMap;
import java.util.Map;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;


public class PlayerController implements InputProcessor {

	private final static String TAG = PlayerController.class.getSimpleName();

	enum Keys {
		LEFT, RIGHT, UP, DOWN
	}


	private static Map<Keys, Boolean> keys = new HashMap<Keys, Boolean>();
	int screenWidth;
	int screenHeight;


	//initialize the hashmap for inputs
	static {
		keys.put(Keys.UP, false);
		keys.put(Keys.DOWN, false);
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
	}

	private Entity player;
	boolean actLeft;
	boolean actRight;
	boolean actUp;
	boolean actDown;

	public PlayerController(Entity player) {
		//Gdx.app.log(TAG, "Construction" );
		this.player = player;

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		actLeft  = false;
		actRight = false;
		actUp    = false;
		actDown  = false;

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
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	//TODO Speak about this in report - corners for UP & Down
	// majority of the right and left side are for the corresponding directions
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		//Gdx.app.log(TAG, "touch down : ( x == " + screenX + ", y ==" + screenY + ")" );
		//Gdx.app.log(TAG, "Screen Width : " + Gdx.graphics.getWidth());
		//Gdx.app.log(TAG, "Screen Height : " + Gdx.graphics.getHeight());

		if((screenX >= 0 && screenX <= screenWidth/2) &&
				(screenY >= screenHeight/4 && screenY <= screenHeight/1.3)){
			if (keys.get(Keys.UP) || keys.get(Keys.DOWN) || keys.get(Keys.RIGHT)) {
					//do nothing
			} else {
				this.leftPressed();
				actLeft = true;
			}
		}
		if((screenX >= screenWidth/2 && screenX <= screenWidth) &&
				(screenY >= screenHeight/4 && screenY <= screenHeight/1.3)){
			if (keys.get(Keys.DOWN) || keys.get(Keys.UP) || keys.get(Keys.LEFT)){
					//do nothing
			} else {
				this.rightPressed();
				actRight = true;
			}
		}

		if((screenX >= 0 && screenX <= screenWidth) &&
				(screenY >= 0 && screenY <= screenHeight/4)){
			if (keys.get(Keys.DOWN) || keys.get(Keys.LEFT) || keys.get(Keys.RIGHT)){
					//do nothing
			} else {
				this.upPressed();
				actUp = true;
			}
		}
		if((screenX >= 0 && screenX <= screenWidth) &&
				(screenY >= screenHeight/1.3 && screenY <= screenHeight)){
			if (keys.get(Keys.UP) || keys.get(Keys.LEFT)  || keys.get(Keys.RIGHT)){
					//do nothing
			} else {
				this.downPressed();
				actDown = true;
			}
		}

		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		//Gdx.app.log(TAG, "touch up : ( x == " + screenX + ", y ==" + screenY + ")" );

		if((screenX >= 0 && screenX <= screenWidth/2) &&
				(screenY >= screenHeight/4 && screenY <= screenHeight/1.3)){
			if (actLeft == true){
				hide();
				doNotAct();
			}
		}

		if((screenX >= screenWidth/2 && screenX <= screenWidth) &&
				(screenY >= screenHeight/4 && screenY <= screenHeight/1.3)){
			if (actRight == true){
				hide();
				doNotAct();
			}
		}

		if((screenX >= 0 && screenX <= screenWidth) &&
				(screenY >= 0 && screenY <= screenHeight/4)){
			if (actUp == true){
				hide();
				doNotAct();

			}
		}
		if((screenX >= 0 && screenX <= screenWidth) &&
				(screenY >= screenHeight/1.3 && screenY <= screenHeight)){
			if (actDown == true){
				hide();
				doNotAct();
			}
		}

		return true;
	}

	public void doNotAct(){
		actLeft = false;
		actRight = false;
		actUp = false;
		actDown = false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false ;
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


	public void update(float delta){
		processInput(delta);
	}

	public static void hide(){
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
		keys.put(Keys.UP, false);
		keys.put(Keys.DOWN, false);

	}

	private void processInput(float delta){

		//Keyboard input
		if( keys.get(Keys.LEFT)){
			//Gdx.app.log(TAG, "LEFT key");
			player.calculateNextPosition(Entity.Direction.LEFT, delta);
			player.setState(Entity.State.WALKING);
			player.setDirection(Entity.Direction.LEFT, delta);
		}else if( keys.get(Keys.RIGHT)){
			//Gdx.app.log(TAG, "RIGHT key");
			player.calculateNextPosition(Entity.Direction.RIGHT, delta);
			player.setState(Entity.State.WALKING);
			player.setDirection(Entity.Direction.RIGHT, delta);
		}else if( keys.get(Keys.UP)){
			//Gdx.app.log(TAG, "UP key");
			player.calculateNextPosition(Entity.Direction.UP, delta);
			player.setState(Entity.State.WALKING);
			player.setDirection(Entity.Direction.UP, delta);
		}else if(keys.get(Keys.DOWN)){
			//Gdx.app.log(TAG, "DOWN key");
			player.calculateNextPosition(Entity.Direction.DOWN, delta);
			player.setState(Entity.State.WALKING);
			player.setDirection(Entity.Direction.DOWN, delta);
		}else{
			player.setState(Entity.State.IDLE);
		}

	}

}
