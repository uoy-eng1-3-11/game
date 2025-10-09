package io.github.mazegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Player {

    private Texture image;

    private Vector2 position;
    private Vector2 gridPosition;
    private Vector2 nextGridPosition;
    private boolean isMoving = false;

    public Player(Texture pImage){
        image = pImage;
        gridPosition = Vector2.Zero;
    }

    public void update(){
        if (!isMoving){
            setPosition(gridPosition.x * WorldGrid.GRID_SQUARE_SIZE, gridPosition.y * WorldGrid.GRID_SQUARE_SIZE); 
            input();
        }
        else {
            Vector2 nextPosition = new Vector2(nextGridPosition.x * WorldGrid.GRID_SQUARE_SIZE, nextGridPosition.y * WorldGrid.GRID_SQUARE_SIZE);
            setPosition(Extenstions.vectorLerp(position, nextPosition, 1f));
            if (Extenstions.distanceSquared(position, nextPosition) < .1f){
                setPosition(nextPosition);
                isMoving = false;
            }
        }
    }

    public void input(){
        if (Gdx.input.isKeyJustPressed(Keys.A)){
            nextGridPosition = new Vector2(gridPosition.x + 1, gridPosition.y);
            isMoving = true;
        } 
        else if (Gdx.input.isKeyJustPressed(Keys.D)){
            nextGridPosition = new Vector2(gridPosition.x - 1, gridPosition.y);
            isMoving = true;
        } 
        else if (Gdx.input.isKeyJustPressed(Keys.W)){
            nextGridPosition = new Vector2(gridPosition.x, gridPosition.y - 1);
            isMoving = true;
        }
        else if (Gdx.input.isKeyJustPressed(Keys.S)){
            nextGridPosition = new Vector2(gridPosition.x, gridPosition.y + 1);
            isMoving = true;
        }
    }

    public Vector2 getPosition(){
        return position;
    }

    public void setPosition(float x, float y){
        position = new Vector2(x, y);
    }

    public void setPosition(Vector2 vector){
        position = vector;
    }

    public void draw(SpriteBatch batch){
        batch.draw(image, position.x, position.y, image.getWidth(), image.getHeight());
    }
}
