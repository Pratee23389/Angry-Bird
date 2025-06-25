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

public class Difficulty implements Screen {
    private Main game;
    private SpriteBatch batch;
    private Texture image;
    private Stage stage;
    private Texture  Easy, Medium, Hard, Back;
    public Difficulty(Main game){
        this.game = game;
    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        image = new Texture("Play_game.jpg");   //load background image

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        //Buttons
        Easy = new Texture("easy.png");
        ImageButton EasyButton = new ImageButton(new TextureRegionDrawable(Easy));

        EasyButton.setSize(200, 100); // Set button size
        EasyButton.setPosition( Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 + 90); // Set position of button


        EasyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level1 screen
                game.setScreen(new Level1(game));
            }
        });

        Medium = new Texture("medium.png");
        ImageButton MediumButton = new ImageButton(new TextureRegionDrawable(Medium));

        MediumButton.setSize(200, 100); // Set button size
        MediumButton.setPosition( Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 + 10); // Set position of button


        MediumButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level1 screen
                game.setScreen(new Level1(game));
            }
        });

        Hard = new Texture("hard.png");
        ImageButton HardButton = new ImageButton(new TextureRegionDrawable(Hard));

        HardButton.setSize(200, 100); // Set button size
        HardButton.setPosition( Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 70); // Set position of button


        HardButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level1 screen
                game.setScreen(new Level1(game));
            }
        });

        Back = new Texture("back.png");
        ImageButton BackButton = new ImageButton(new TextureRegionDrawable(Back));

        BackButton.setSize(200, 100); // Set button size
        BackButton.setPosition( Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 150); // Set position of button


        BackButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Play_game screen
                game.setScreen(new Play_game(game));
            }
        });

        // Add buttons to the stage
        stage.addActor(EasyButton);
        stage.addActor(MediumButton);
        stage.addActor(HardButton);
        stage.addActor(BackButton);
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
    public void resize (int width, int height){
        stage.getViewport().update(width, height, true); // Update the stage's viewport on resize
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose (){
        batch.dispose();
        image.dispose();
        stage.dispose();
        Easy.dispose();
        Medium.dispose();
        Hard.dispose();
        Back.dispose();
    }
}

