package com.mygdx.game;

/**
 * Created by firasAltayeb on 27/02/2017.
 */

import java.util.UUID;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Entity {

    private static final String TAG = Entity.class.getSimpleName();
    private static final String defaultSpritePath = "sprites/characters/hiro_sheet";

    private Vector2 velocity;
    private String entityID;

    private Direction currentDirection = Direction.LEFT;
    private Direction perviousDirection = Direction.UP;

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

    public final int FRAME_WIDTH = 16;
    public final int FRAME_HEIGHT = 16;
    public static Rectangle boundingBox;


    public enum State {
        IDLE, WALKING
    }

    public enum Direction {
        UP,RIGHT,DOWN,LEFT;
    }

    public void initEntity(){
        this.entityID = UUID.randomUUID().toString();
        this.nextPlayerPosition = new Vector2();
        this.currentPlayerPosition = new Vector2();
        this.boundingBox = new Rectangle();
        this.velocity = new Vector2(2f, 2f);

        Utility.loadTextureAsset(defaultSpritePath);
        loadDefaultSprite();
        loadAllAnimations();
    }

    public void update(float delta){
        frameTime = (frameTime + delta) % 5; //want to avoid overflow

        //we want the hitbox to be at the feet for a better feel
        setBoundingBoxSize(0f, 0.5f);
    }

    public void init(float startX, float startY){
        this.currentPlayerPosition.x = startX;
        this.currentPlayerPosition.y = startY;

        this.nextPlayerPosition.x = startX;
        this.nextPlayerPosition.y = startY;
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
            Gdx.app.debug(TAG, "Width and Height are 0!! " + width +
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
    }


}
