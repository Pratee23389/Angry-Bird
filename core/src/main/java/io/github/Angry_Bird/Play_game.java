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

public class Play_game implements Screen {
    private Main game;
    private SpriteBatch batch;
    private Texture image;
    private Stage stage;
    private Texture  NewGame, LoadGame, Back;

    public Play_game(Main game){
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        image = new Texture("Play_game.jpg");   //load background

        stage = new Stage(new ScreenViewport());   //set up stage
        Gdx.input.setInputProcessor(stage);

        //buttons
        NewGame = new Texture("new.png");
        ImageButton NewButton = new ImageButton(new TextureRegionDrawable(NewGame));

        NewButton.setSize(200, 100); // Set button size
        NewButton.setPosition( Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 + 70); // Set position of button


        NewButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Difficulty screen
                game.setScreen(new Difficulty(game));
            }
        });

        LoadGame = new Texture("load.png");
        ImageButton LoadButton = new ImageButton(new TextureRegionDrawable(LoadGame));

        LoadButton.setSize(200, 100); // Set button size
        LoadButton.setPosition( Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 30); // Set position of button


        LoadButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level screen
                game.setScreen(new Level(game));
            }
        });

        Back = new Texture("back.png");
        ImageButton BackButton = new ImageButton(new TextureRegionDrawable(Back));

        BackButton.setSize(200, 100); // Set button size
        BackButton.setPosition( Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 130); // Set position of button


        BackButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Home_Screen screen
                game.setScreen(new Home_Screen(game));
            }
        });

        stage.addActor(NewButton);
        stage.addActor(LoadButton);
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
    public void dispose (){
        batch.dispose();
        image.dispose();
        stage.dispose();
        NewGame.dispose();
        LoadGame.dispose();
        Back.dispose();
    }
}
