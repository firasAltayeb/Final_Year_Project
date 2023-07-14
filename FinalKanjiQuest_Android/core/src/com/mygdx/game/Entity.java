package com.mygdx.game;

/**
 * Created by firasAltayeb on 27/02/2017.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.UUID;

public class Entity {

    private static final String TAG = Entity.class.getSimpleName();
    private static final String defaultSpritePath = "sprites/hiro_sheet.png";

    private Vector2 velocity;
    private String entityID;

    private Direction currentDirection = Direction.LEFT;
    private Direction previousDirection = Direction.UP;

    private Animation walkLeftAnimation;
    private Animation walkRightAnimation;
    private Animation walkUpAnimation;
    private Animation walkDownAnimation;

    private Array<TextureRegion> walkLeftFrames;
    private Array<TextureRegion> walkRightFrames;
    private Array<TextureRegion> walkUpFrames;
    private Array<TextureRegion> walkDownFrames;

    protected Vector2 nextPlayerPosition;
    protected Vector2 currentPlayerPosition;
    protected State state = State.IDLE;
    protected float frameTime = 0f;
    protected Sprite frameSprite = null;
    protected TextureRegion currentFrame = null;

    public final int FRAME_WIDTH = 19;
    public final int FRAME_HEIGHT = 34;
    public static Rectangle boundingBox;


    public enum State {
        IDLE, WALKING
    }

    public enum Direction {
        UP,RIGHT,DOWN,LEFT;
    }

    public Entity(){
        initEntity();
    }

    public void initEntity(){
        //Gdx.app.log(TAG, "Construction" );

        this.entityID = UUID.randomUUID().toString();
        this.nextPlayerPosition = new Vector2();
        this.currentPlayerPosition = new Vector2();
        this.boundingBox = new Rectangle();
        //Player speed
        this.velocity = new Vector2(4f, 4f);

        Utility.loadTextureAsset(defaultSpritePath);
        loadDefaultSprite();
        loadAllAnimations();
    }

    public void update(float delta){
        frameTime = (frameTime + delta) % 5; //want to avoid overflow
        //Gdx.app.log(TAG, "frametime: " + _frameTime );

        //we want the hitbox to be at the feet for a better feel
        setBoundingBoxSize(0.4f, 0.6f);
    }

    public void init(float startX, float startY){
        this.currentPlayerPosition.x = startX;
        this.currentPlayerPosition.y = startY;

        this.nextPlayerPosition.x = startX;
        this.nextPlayerPosition.y = startY;

        //Gdx.app.log(TAG, "Calling INIT" );
    }

    public void setBoundingBoxSize(float percentageWidthReduced,
                                        float percentageHeightReduced){
        //update the current bounding box
        float width;
        float height;

        // To get 80% reduction, we pass .8f == (1 - .20)
        float widthReductionAmount = 1.0f - percentageWidthReduced;
        float heightReductionAmount = 1.0f - percentageHeightReduced;

        if(widthReductionAmount > 0 && widthReductionAmount < 1){
            width = FRAME_WIDTH * widthReductionAmount;
        } else {
            width = FRAME_WIDTH;
        }

        if(heightReductionAmount > 0 && heightReductionAmount < 1){
            height = FRAME_WIDTH * heightReductionAmount;
        } else {
            height = FRAME_WIDTH;
        }

        if(width == 0 || height == 0){
            Gdx.app.log(TAG, "Width and Height are 0!! " + width +
            ":" + height);
        }

        //need to account for the unitScale, since the map coordinates
        //will be in pixels
        float minX;
        float minY;
        if (MapManger.UNIT_SCALE > 0){
            minX = nextPlayerPosition.x / MapManger.UNIT_SCALE;
            minY = nextPlayerPosition.y / MapManger.UNIT_SCALE;
        } else {
            minX = nextPlayerPosition.x;
            minY = nextPlayerPosition.y;
        }

        boundingBox.set(minX, minY, width, height);
        //Gdx.app.log(TAG, "SETTING Bounding Box: (" + minX + "," + minY + ")  width: " + width + " height: " + height);
    }

    private void loadDefaultSprite(){
        Texture texture = Utility.getTextureAsset(defaultSpritePath);
        TextureRegion [][] textureFrames = TextureRegion.split(texture, FRAME_WIDTH, FRAME_HEIGHT);
        frameSprite = new Sprite(textureFrames[0][0].getTexture(), 0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        currentFrame = textureFrames[0][0];
    }

    private void loadAllAnimations() {
        //Walking animation
        Texture texture = Utility.getTextureAsset(defaultSpritePath);
        TextureRegion[][] textureFrames = TextureRegion.split(texture, FRAME_WIDTH, FRAME_HEIGHT);

        walkDownFrames = new Array<TextureRegion>(4);
        walkLeftFrames = new Array<TextureRegion>(4);
        walkRightFrames = new Array<TextureRegion>(4);
        walkUpFrames = new Array<TextureRegion>(4);


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //Gdx.app.log(TAG, "Got frame " + i + "," + j + " from " + sourceImage);
                TextureRegion region = textureFrames[i][j];
                if (region == null) {
                    Gdx.app.log(TAG, "Got null animation frame " + i + "," + j);
                }
                switch (i) {
                    case 0:
                        walkUpFrames.insert(j, region);
                        break;
                    case 1:
                        walkDownFrames.insert(j, region);
                        break;
                    case 2:
                        walkLeftFrames.insert(j, region);
                        break;
                    case 3:
                        walkRightFrames.insert(j, region);
                        break;
                }
            }
        }

        walkDownAnimation = new Animation(0.25f, walkDownFrames, Animation.PlayMode.LOOP);
        walkLeftAnimation = new Animation(0.25f, walkLeftFrames, Animation.PlayMode.LOOP);
        walkRightAnimation = new Animation(0.25f, walkRightFrames, Animation.PlayMode.LOOP);
        walkUpAnimation = new Animation(0.25f, walkUpFrames, Animation.PlayMode.LOOP);

    }

    public void dispose(){
        Utility.unloadAsset(defaultSpritePath);
    }

    public void setState(State state){
        this.state = state;
    }

    public Sprite getFrameSprite(){
        return frameSprite;
    }

    public TextureRegion getFrame(){
        return currentFrame;
    }

    public Vector2 getCurrentPosition(){
        return currentPlayerPosition;
    }

    public void setCurrentPosition(float currentPositionX, float currentPositionY){
        frameSprite.setX(currentPositionX);
        frameSprite.setY(currentPositionY);
        this.currentPlayerPosition.x = currentPositionX;
        this.currentPlayerPosition.y = currentPositionY;
    }

    public void setDirection(Direction direction,  float deltaTime){
        this.previousDirection = this.currentDirection;
        this.currentDirection = direction;

        //Look into the appropriate variable when changing position
        switch (currentDirection) {
            case DOWN :
                currentFrame = walkDownAnimation.getKeyFrame(frameTime);
                break;
            case LEFT :
                currentFrame = walkLeftAnimation.getKeyFrame(frameTime);
                break;
            case UP :
                currentFrame = walkUpAnimation.getKeyFrame(frameTime);
                break;
            case RIGHT :
                currentFrame = walkRightAnimation.getKeyFrame(frameTime);
                break;
            default:
                break;
        }
    }

    public void setNextPositionToCurrent(){
        setCurrentPosition(nextPlayerPosition.x, nextPlayerPosition.y);
        //Gdx.app.log(TAG, "Setting nextPosition as Current: (" + _nextPlayerPosition.x + "," + _nextPlayerPosition.y + ")");
    }

    public void calculateNextPosition(Direction currentDirection, float deltaTime){
        float testX = currentPlayerPosition.x;
        float testY = currentPlayerPosition.y;

        //Gdx.app.log(TAG, "calculateNextPosition:: Current Position: (" + _currentPlayerPosition.x + "," + _currentPlayerPosition.y + ")"  );
        //Gdx.app.log(TAG, "calculateNextPosition:: Current Direction: " + _currentDirection  );

        //currentVelocity * scalar quantity
        velocity.scl(deltaTime);

        switch (currentDirection) {
            case LEFT :
                testX -= velocity.x;
                break;
            case RIGHT :
                testX += velocity.x;
                break;
            case UP :
                testY += velocity.y;
                break;
            case DOWN :
                testY -= velocity.y;
                break;
            default:
                break;
        }

        nextPlayerPosition.x = testX;
        nextPlayerPosition.y = testY;

        //velocity
        velocity.scl(1 / deltaTime);
    }



}