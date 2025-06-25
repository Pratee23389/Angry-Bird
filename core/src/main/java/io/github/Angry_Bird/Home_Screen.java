package io.github.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Home_Screen implements Screen {
    private Main game;
    private SpriteBatch batch;
    private Texture image;
    private Stage stage;
    private Texture play, exit, rule;

    public Home_Screen(Main game){
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        image = new Texture("Home_Screen.jpg"); //load background image

        stage = new Stage(new ScreenViewport());   //set stage
        Gdx.input.setInputProcessor(stage);

        //Buttons

        play = new Texture("play.png");

        ImageButton playButton = new ImageButton(new TextureRegionDrawable(play));

        playButton.setSize(200, 100); // Set button size
        playButton.setPosition( Gdx.graphics.getWidth()/2 - 100, Gdx.graphics.getHeight() / 2 + 50); // Set position of button


        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Play_game screen
                game.setScreen(new Play_game(game));
            }
        });

        exit = new Texture("exit.png");

        ImageButton exitButton = new ImageButton(new TextureRegionDrawable(exit));

        exitButton.setSize(200, 100); // Set button size
        exitButton.setPosition(Gdx.graphics.getWidth()/2 - 100, Gdx.graphics.getHeight() / 2 - 150 ); // Set position of button


        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Exit game
                Gdx.app.exit();
            }
        });

        rule = new Texture("rules.png");

        ImageButton ruleButton = new ImageButton(new TextureRegionDrawable(rule));

        ruleButton.setSize(200, 100); // Set button size
        ruleButton.setPosition(Gdx.graphics.getWidth()/2 - 100, Gdx.graphics.getHeight() / 2 - 50); // Set position of button


        ruleButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Rules screen
                game.setScreen(new Rules(game));
            }
        });



        // Add buttons to the stage
        stage.addActor(playButton);
        stage.addActor(ruleButton);
        stage.addActor(exitButton);
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
        play.dispose();
        exit.dispose();
        rule.dispose();

    }
}
