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

public class PauseScreen implements Screen {
    private Main game;
    private SpriteBatch batch;
    private Texture image;
    private Stage stage;
    private Texture  retry, resume, main_menu;
    public PauseScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        image = new Texture("pause_screen.png");   //load background

        stage = new Stage(new ScreenViewport());   //set up stage
        Gdx.input.setInputProcessor(stage);

        //buttons
        retry = new Texture("retry.png");
        ImageButton retryButton = new ImageButton(new TextureRegionDrawable(retry));

        retryButton.setSize(200, 100); // Set button size
        retryButton.setPosition( Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 + 40); // Set position of button


        retryButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to previous screen
                game.setScreen(game.getPreviousScreen());
            }
        });

        resume = new Texture("resume.png");
        ImageButton resumeButton = new ImageButton(new TextureRegionDrawable(resume));

        resumeButton.setSize(200, 100); // Set button size
        resumeButton.setPosition( Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 60 ); // Set position of button


        resumeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to previous screen
                game.setScreen(game.getPreviousScreen());
            }
        });

        main_menu = new Texture("main_menu.png");
        ImageButton MenuButton = new ImageButton(new TextureRegionDrawable(main_menu));

        MenuButton.setSize(200, 100); // Set button size
        MenuButton.setPosition( Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 160); // Set position of button


        MenuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level screen
                game.setScreen(new Level(game));
            }
        });

        stage.addActor(retryButton);
        stage.addActor(resumeButton);
        stage.addActor(MenuButton);
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
        image.dispose();
        batch.dispose();
        stage.dispose();
        retry.dispose();
        resume.dispose();
        main_menu.dispose();
    }
}
