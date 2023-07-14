package com.mygdx.game;


import java.util.HashMap;
import java.util.Map;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;


public class PlayerController implements InputProcessor {

	private final static String TAG = PlayerController.class.getSimpleName();

	enum Keys {
		LEFT, RIGHT, UP, DOWN,
		UP_RIGHT, UP_LEFT, DOWN_RIGHT, DOWN_LEFT
	}


	private static Map<Keys, Boolean> keys = new HashMap<Keys, Boolean>();
	int screenWidth;
	int screenHeight;
	int touchDownX;
	int touchDownY;


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

	private Entity player;
	boolean doNothing;

	public PlayerController(Entity player) {
		//Gdx.app.log(TAG, "Construction" );
		this.player = player;

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		touchDownX = 0;
		touchDownY = 0;
		doNothing = false;

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

	//TODO mention in report
	//TODO corners for UP & Down
	//TODO majority of the right and left side are for their corresponding directions
	//TODO mention how later decided to add diagonal movement
	//TODO if statements are used to stop users from stopping movement - second finger touch
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		//Gdx.app.log(TAG, "touch down : ( x == " + screenX + ", y ==" + screenY + ")" );
		//Gdx.app.log(TAG, "Screen Width : " + Gdx.graphics.getWidth());
		//Gdx.app.log(TAG, "Screen Height : " + Gdx.graphics.getHeight());

		touchDownX = screenX;
		touchDownY = screenY;
		Gdx.app.log(TAG, "touchDownX " + screenX);
		Gdx.app.log(TAG, "touchDownY " + screenY);

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
				Gdx.app.log(TAG, "upright doNothing is " + doNothing);
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
		}

		//center's right pressed
		if((screenX >= screenWidth/1.5 && screenX <= screenWidth) &&
				(screenY >= screenHeight/3 && screenY <= screenHeight/1.5)){
			if (keys.get(Keys.UP) || keys.get(Keys.DOWN) || keys.get(Keys.LEFT) ||
					keys.get(Keys.UP_RIGHT) || keys.get(Keys.UP_LEFT) ||keys.get(Keys.DOWN_RIGHT) ||
					keys.get(Keys.DOWN_LEFT)) {
				doNothing = true;
				Gdx.app.log(TAG, " right doNothing is " + doNothing);
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
				Gdx.app.log(TAG, " down left doNothing is " + doNothing);
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
				Gdx.app.log(TAG, "bottom doNothing is " + doNothing);
			}
			else {
				Gdx.app.log(TAG, "down right pressed ");
				this.downRightPressed();
			}
		}

		//Gdx.app.log(TAG, "touch down returned" );

		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		//Gdx.app.log(TAG, "touch up : ( x == " + screenX + ", y ==" + screenY + ")" );

		Gdx.app.log(TAG, "touch up inaction" );
		Gdx.app.log(TAG, "do nothing " + doNothing);

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

	//mention how
	//TODO this helps movement
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {

		Gdx.app.log(TAG, "touch dragged inaction" );
		Gdx.app.log(TAG, "touchDownX " + screenX);
		Gdx.app.log(TAG, "touchDownY " + screenY);


		if(screenX > touchDownX + 50){
			hide();
			rightPressed();
		}
		else if(screenX < touchDownX - 50){
			hide();
			leftPressed();
		}
		else if(screenY > touchDownY + 50){
			hide();
			downPressed();
		}
		else if(screenY < touchDownY - 50){
			hide();
			upPressed();
		}

//		else if((screenX > touchDownX + 50) && (screenY > touchDownY + 50)){
//			hide();
//			downRightPressed();
//		}
//		else if((screenX > touchDownX + 50) && (screenY < touchDownY - 50)){
//			hide();
//			upRightPressed();
//		}
//		else if((screenX < touchDownX - 50) && (screenY > touchDownY + 50)){
//			hide();
//			downLeftPressed();
//		}
//		else if((screenX < touchDownX - 50) && (screenY < touchDownY - 50)){
//			hide();
//			upLeftReleased();
//		}

		touchDownX = screenX;
		touchDownY = screenY;

		return true;
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

	public void update(float delta){
		processInput(delta);
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

	}

}
