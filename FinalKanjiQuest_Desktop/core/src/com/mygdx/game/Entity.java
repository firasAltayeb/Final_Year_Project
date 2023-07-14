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
        setBoundingBox(0f, 0.5f);
    }

}
