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

public class WinScreen implements Screen {
    private Main game;
    private SpriteBatch batch;
    private Texture image;
    private Stage stage;
    private Texture  retry, levels;
    public WinScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        image = new Texture("win_screen.png");   //load background

        stage = new Stage(new ScreenViewport());   //set up stage
        Gdx.input.setInputProcessor(stage);

        retry = new Texture("retry.png");
        ImageButton retryButton = new ImageButton(new TextureRegionDrawable(retry));

        retryButton.setSize(200, 100); // Set button size
        retryButton.setPosition( Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 + 20); // Set position of button


        retryButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to previous screen
                game.setScreen(game.getPreviousScreen());
            }
        });

        levels = new Texture("level.png");
        ImageButton levelsButton = new ImageButton(new TextureRegionDrawable(levels));

        levelsButton.setSize(200, 100); // Set button size
        levelsButton.setPosition( Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 80); // Set position of button


        levelsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level screen
                game.setScreen(new Level(game));
            }


        });

        stage.addActor(retryButton);
        stage.addActor(levelsButton);
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
        retry.dispose();
        levels.dispose();
    }
}
