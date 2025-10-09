package io.github.mazegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MazeGame extends Game{

    public SpriteBatch batch;
    public BitmapFont font;
    public Viewport viewport;
    public Player player;

    public void create(){
        batch = new SpriteBatch();
        font = new BitmapFont();
        viewport = new FitViewport(8, 5);
        player = new Player(new Texture("bucket.png"));
    }

    public void render(){
        super.render();
    }
}
