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

import objects.BlackBird;
import objects.NormalPig;
import objects.RedBird;
import objects.Sling;
import objects.StoneRectangle;
import objects.WhiteBird;
import objects.WoodRectangle;
import objects.birds;
import objects.pigs;
import objects.structure;

public class Level3 implements Screen {
    private Main game;
    private SpriteBatch batch;
    private Texture image;
    private Stage stage;
    private Texture  pause, win, loose;
    private birds bird1, bird2, bird3, bird4;
    private pigs pig1, pig2;
    private structure struct1, struct2, struct3, struct4, struct5, struct6;
    private Sling sling;
    public Level3(Main game){
        this.game = game;
    }

    @Override
    public void show() {

        batch = new SpriteBatch();
        image = new Texture("level3.png");  //load background image

        //level layout
        bird1 = new BlackBird(95, 70);
        bird2 = new WhiteBird(65,70);
        bird3 = new RedBird(40,70);
        bird4 = new RedBird(5,70);
        sling = new Sling(80,70);
        struct1 = new WoodRectangle(Gdx.graphics.getWidth()-100,70,10,70);
        struct2 = new WoodRectangle(Gdx.graphics.getWidth()-40,70,10,70);
        struct3 = new WoodRectangle(Gdx.graphics.getWidth()-100,140,70,10);
        struct4 = new StoneRectangle(Gdx.graphics.getWidth() - 110, 70,10,70);
        struct5 = new StoneRectangle(Gdx.graphics.getWidth() - 170, 70,10,70);
        struct6 = new StoneRectangle(Gdx.graphics.getWidth() - 170, 140,70,10);
        pig1 = new NormalPig(Gdx.graphics.getWidth() - 80,70);
        pig2 = new NormalPig(Gdx.graphics.getWidth() - 150,70);

        stage = new Stage(new ScreenViewport());   //set up stage
        Gdx.input.setInputProcessor(stage);

        //Buttons
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

        //add buttons to stage
        stage.addActor(pauseButton);
        stage.addActor(winButton);
        stage.addActor(looseButton);
        stage.addActor(sling);
        stage.addActor(struct1);
        stage.addActor(struct2);
        stage.addActor(struct3);
        stage.addActor(struct4);
        stage.addActor(struct5);
        stage.addActor(struct6);
        stage.addActor(bird1);
        stage.addActor(bird2);
        stage.addActor(bird3);
        stage.addActor(bird4);
        stage.addActor(pig1);
        stage.addActor(pig2);
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
