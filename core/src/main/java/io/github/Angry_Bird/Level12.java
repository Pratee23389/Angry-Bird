package io.github.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Level12 implements Screen {
    private Main game;
    private SpriteBatch batch;
    private Texture image;
    private Stage stage;
    private Texture  pause, win, loose;
    public Level12(Main game){
        this.game = game;
    }

    @Override
    public void show() {

        batch = new SpriteBatch();
        image = new Texture("level12.png");  //load background

        stage = new Stage(new ScreenViewport());   //set up stage
        Gdx.input.setInputProcessor(stage);

        //buttons
        pause = new Texture("pause.png");
        ImageButton pauseButton = new ImageButton(new TextureRegionDrawable(pause));

        pauseButton.setSize(50, 50); // Set button size
        pauseButton.setPosition( 20, Gdx.graphics.getHeight() - 60); // Set position of button


        pauseButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setPreviousScreen(game.getScreen());
                // Transition to PauseScreen screen
                game.setScreen(new PauseScreen(game));
            }
        });

        loose = new Texture("loose.png");
        ImageButton looseButton = new ImageButton(new TextureRegionDrawable(loose));

        looseButton.setSize(50, 50); // Set button size
        looseButton.setPosition( Gdx.graphics.getWidth() - 120, Gdx.graphics.getHeight() - 60); // Set position of button


        looseButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setPreviousScreen(game.getScreen());
                // Transition to LooseScreen screen
                game.setScreen(new LooseScreen(game));
            }
        });

        win = new Texture("win.png");
        ImageButton winButton = new ImageButton(new TextureRegionDrawable(win));

        winButton.setSize(50, 50); // Set button size
        winButton.setPosition( Gdx.graphics.getWidth() - 60, Gdx.graphics.getHeight() - 60); // Set position of button


        winButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to WinScreen screen
                game.setPreviousScreen(game.getScreen());
                game.setScreen(new WinScreen(game));
            }
        });

        stage.addActor(pauseButton);
        stage.addActor(winButton);
        stage.addActor(looseButton);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        batch.draw(image, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // Draw image scaled to the entire screen
        batch.end();

        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true); // Update the stage's viewport on resize
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        stage.dispose();
        pause.dispose();
        win.dispose();
        loose.dispose();
    }
}
