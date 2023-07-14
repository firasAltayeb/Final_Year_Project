package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.maps.MapManager;

import java.util.Hashtable;

public abstract class GraphicsComponent implements Component {
    protected TextureRegion currentFrame = null;
    protected float frameTime = 0f;
    protected com.mygdx.game.tools.Entity.State currentState;
    protected com.mygdx.game.tools.Entity.Direction currentDirection;
    protected Json json;
    protected Vector2 currentPosition;
    protected Hashtable<com.mygdx.game.tools.Entity.AnimationType, Animation> animations;
    protected ShapeRenderer shapeRenderer;

    protected GraphicsComponent(){
        currentPosition = new Vector2(0,0);
        currentState = com.mygdx.game.tools.Entity.State.WALKING;
        currentDirection = com.mygdx.game.tools.Entity.Direction.DOWN;
        json = new Json();
        animations = new Hashtable<com.mygdx.game.tools.Entity.AnimationType, Animation>();
        shapeRenderer = new ShapeRenderer();
    }

    public abstract void update(com.mygdx.game.tools.Entity entity, MapManager mapManager, Batch batch, float delta);

    protected void updateAnimations(float delta){
        frameTime = (frameTime + delta)%5; //Want to avoid overflow

        //Look into the appropriate variable when changing position
        switch (currentDirection) {
            case DOWN:
                if (currentState == com.mygdx.game.tools.Entity.State.WALKING) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_DOWN);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                } else if(currentState == com.mygdx.game.tools.Entity.State.IDLE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_DOWN);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrames()[0];
                } else if(currentState == com.mygdx.game.tools.Entity.State.IMMOBILE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.IMMOBILE);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                }
                break;
            case DOWN_LEFT:
                if (currentState == com.mygdx.game.tools.Entity.State.WALKING) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_DOWN_LEFT);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                } else if(currentState == com.mygdx.game.tools.Entity.State.IDLE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_DOWN_LEFT);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrames()[0];
                } else if(currentState == com.mygdx.game.tools.Entity.State.IMMOBILE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.IMMOBILE);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                }
                break;
            case DOWN_RIGHT:
                if (currentState == com.mygdx.game.tools.Entity.State.WALKING) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_DOWN_RIGHT);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                } else if(currentState == com.mygdx.game.tools.Entity.State.IDLE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_DOWN_RIGHT);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrames()[0];
                } else if(currentState == com.mygdx.game.tools.Entity.State.IMMOBILE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.IMMOBILE);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                }
                break;
            case LEFT:
                if (currentState == com.mygdx.game.tools.Entity.State.WALKING) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_LEFT);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                } else if(currentState == com.mygdx.game.tools.Entity.State.IDLE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_LEFT);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrames()[0];
                } else if(currentState == com.mygdx.game.tools.Entity.State.IMMOBILE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.IMMOBILE);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                }
                break;
            case UP:
                if (currentState == com.mygdx.game.tools.Entity.State.WALKING) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_UP);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                } else if(currentState == com.mygdx.game.tools.Entity.State.IDLE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_UP);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrames()[0];
                } else if(currentState == com.mygdx.game.tools.Entity.State.IMMOBILE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.IMMOBILE);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                }
                break;
            case UP_LEFT:
                if (currentState == com.mygdx.game.tools.Entity.State.WALKING) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_UP_LEFT);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                } else if(currentState == com.mygdx.game.tools.Entity.State.IDLE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_UP_LEFT);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrames()[0];
                } else if(currentState == com.mygdx.game.tools.Entity.State.IMMOBILE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.IMMOBILE);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                }
                break;
            case UP_RIGHT:
                if (currentState == com.mygdx.game.tools.Entity.State.WALKING) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_UP_RIGHT);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                } else if(currentState == com.mygdx.game.tools.Entity.State.IDLE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_UP_RIGHT);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrames()[0];
                } else if(currentState == com.mygdx.game.tools.Entity.State.IMMOBILE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.IMMOBILE);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                }
                break;
            case RIGHT:
                if (currentState == com.mygdx.game.tools.Entity.State.WALKING) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_RIGHT);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                } else if(currentState == com.mygdx.game.tools.Entity.State.IDLE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.WALK_RIGHT);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrames()[0];
                } else if(currentState == com.mygdx.game.tools.Entity.State.IMMOBILE) {
                    Animation animation = animations.get(com.mygdx.game.tools.Entity.AnimationType.IMMOBILE);
                    if( animation == null ) return;
                    currentFrame = animation.getKeyFrame(frameTime);
                }
                break;
            default:
                break;
        }
    }

    //Specific to two frame animations where each frame is stored in a separate texture
    protected Animation loadAnimation(String firstTexture, String secondTexture, Array<GridPoint2> points, float frameDuration){
        com.mygdx.game.tools.Utility.loadTextureAsset(firstTexture);
        Texture texture1 = com.mygdx.game.tools.Utility.getTextureAsset(firstTexture);

        com.mygdx.game.tools.Utility.loadTextureAsset(secondTexture);
        Texture texture2 = com.mygdx.game.tools.Utility.getTextureAsset(secondTexture);

        TextureRegion[][] texture1Frames = TextureRegion.split(texture1, com.mygdx.game.tools.Entity.FRAME_WIDTH, com.mygdx.game.tools.Entity.FRAME_HEIGHT);
        TextureRegion[][] texture2Frames = TextureRegion.split(texture2, com.mygdx.game.tools.Entity.FRAME_WIDTH, com.mygdx.game.tools.Entity.FRAME_HEIGHT);

        Array<TextureRegion> animationKeyFrames = new Array<TextureRegion>(2);

        GridPoint2 point = points.first();

        animationKeyFrames.add(texture1Frames[point.x][point.y]);
        animationKeyFrames.add(texture2Frames[point.x][point.y]);

        return new Animation(frameDuration, animationKeyFrames, Animation.PlayMode.LOOP);
    }

    protected Animation loadAnimation(String textureName, Array<GridPoint2> points, float frameDuration){
        com.mygdx.game.tools.Utility.loadTextureAsset(textureName);
        Texture texture = com.mygdx.game.tools.Utility.getTextureAsset(textureName);

        TextureRegion[][] textureFrames = TextureRegion.split(texture, com.mygdx.game.tools.Entity.FRAME_WIDTH, com.mygdx.game.tools.Entity.FRAME_HEIGHT);

        Array<TextureRegion> animationKeyFrames = new Array<TextureRegion>(points.size);

        for( GridPoint2 point : points){
            animationKeyFrames.add(textureFrames[point.x][point.y]);
        }

        return new Animation(frameDuration, animationKeyFrames, Animation.PlayMode.LOOP);
    }
}
