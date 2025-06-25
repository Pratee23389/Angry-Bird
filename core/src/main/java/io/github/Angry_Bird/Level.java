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

public class Level implements Screen {
    private Main game;
    private SpriteBatch batch;
    private Texture image;
    private Stage stage;
    private Texture  level1, level2, level3, level4, level5, level6, level7, level8, level9, level10, level11, level12, back;

    public Level(Main game){
        this.game = game;
    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        image = new Texture("Levels.png");   //load background image

        stage = new Stage(new ScreenViewport());   //set stage
        Gdx.input.setInputProcessor(stage);

        //Buttons
        level1 = new Texture("1.png");
        ImageButton level1Button = new ImageButton(new TextureRegionDrawable(level1));

        level1Button.setSize(200, 100); // Set button size
        level1Button.setPosition( Gdx.graphics.getWidth() / 2 - 300, Gdx.graphics.getHeight() / 2 + 70); // Set position of button


        level1Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level1 screen
                game.setScreen(new Level1(game));
            }
        });

        level2 = new Texture("2.png");
        ImageButton level2Button = new ImageButton(new TextureRegionDrawable(level2));

        level2Button.setSize(200, 100); // Set button size
        level2Button.setPosition( Gdx.graphics.getWidth() / 2 - 160, Gdx.graphics.getHeight() / 2 + 70); // Set position of button


        level2Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level2 screen
                game.setScreen(new Level2(game));
            }
        });

        level3 = new Texture("3.png");
        ImageButton level3Button = new ImageButton(new TextureRegionDrawable(level3));

        level3Button.setSize(200, 100); // Set button size
        level3Button.setPosition( Gdx.graphics.getWidth() / 2 - 30, Gdx.graphics.getHeight() / 2 + 70); // Set position of button


        level3Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level3 screen
                game.setScreen(new Level3(game));
            }
        });

        level4 = new Texture("4.png");
        ImageButton level4Button = new ImageButton(new TextureRegionDrawable(level4));

        level4Button.setSize(200, 100); // Set button size
        level4Button.setPosition( Gdx.graphics.getWidth() / 2 + 100 , Gdx.graphics.getHeight() / 2 + 70); // Set position of button


        level4Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level4 screen
                game.setScreen(new Level4(game));
            }
        });

        level5 = new Texture("5.png");
        ImageButton level5Button = new ImageButton(new TextureRegionDrawable(level5));

        level5Button.setSize(200, 100); // Set button size
        level5Button.setPosition( Gdx.graphics.getWidth() / 2 - 300, Gdx.graphics.getHeight() / 2 - 65); // Set position of button


        level5Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level5 screen
                game.setScreen(new Level5(game));
            }
        });

        level6 = new Texture("6.png");
        ImageButton level6Button = new ImageButton(new TextureRegionDrawable(level6));

        level6Button.setSize(200, 100); // Set button size
        level6Button.setPosition( Gdx.graphics.getWidth() / 2 - 160, Gdx.graphics.getHeight() / 2 - 65); // Set position of button


        level6Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level6 screen
                game.setScreen(new Level6(game));
            }
        });

        level7 = new Texture("7.png");
        ImageButton level7Button = new ImageButton(new TextureRegionDrawable(level7));

        level7Button.setSize(200, 100); // Set button size
        level7Button.setPosition( Gdx.graphics.getWidth() / 2 - 30, Gdx.graphics.getHeight() / 2 - 65); // Set position of button


        level7Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level7 screen
                game.setScreen(new Level7(game));
            }
        });

        level8 = new Texture("8.png");
        ImageButton level8Button = new ImageButton(new TextureRegionDrawable(level8));

        level8Button.setSize(200, 100); // Set button siz
        level8Button.setPosition( Gdx.graphics.getWidth() / 2 + 100, Gdx.graphics.getHeight() / 2 - 65); // Set position of button


        level8Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level8 screen
                game.setScreen(new Level8(game));
            }
        });

        level9 = new Texture("9.png");
        ImageButton level9Button = new ImageButton(new TextureRegionDrawable(level9));

        level9Button.setSize(200, 100); // Set button size
        level9Button.setPosition( Gdx.graphics.getWidth() / 2 - 300, Gdx.graphics.getHeight() / 2 - 200); // Set position of button


        level9Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level9 screen
                game.setScreen(new Level9(game));
            }
        });

        level10 = new Texture("10.png");
        ImageButton level10Button = new ImageButton(new TextureRegionDrawable(level10));

        level10Button.setSize(200, 100); // Set button size
        level10Button.setPosition( Gdx.graphics.getWidth() / 2 - 160, Gdx.graphics.getHeight() / 2 - 200); // Set position of button


        level10Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level10 screen
                game.setScreen(new Level10(game));
            }
        });

        level11 = new Texture("11.png");
        ImageButton level11Button = new ImageButton(new TextureRegionDrawable(level11));

        level11Button.setSize(200, 100); // Set button size
        level11Button.setPosition( Gdx.graphics.getWidth() / 2 - 30, Gdx.graphics.getHeight() / 2 - 200); // Set position of button


        level11Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level11 screen
                game.setScreen(new Level11(game));
            }
        });

        level12 = new Texture("12.png");
        ImageButton level12Button = new ImageButton(new TextureRegionDrawable(level12));

        level12Button.setSize(200, 100); // Set button size
        level12Button.setPosition( Gdx.graphics.getWidth() / 2 + 100, Gdx.graphics.getHeight() / 2 - 200); // Set position of button


        level12Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Level12 screen (for example, Game_Screen)
                game.setScreen(new Level12(game));
            }
        });

        back = new Texture("back_button.png");
        ImageButton BackButton = new ImageButton(new TextureRegionDrawable(back));

        BackButton.setSize(40, 40); // Set button size
        BackButton.setPosition( 20, Gdx.graphics.getHeight() - 60); // Set position of button


        BackButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to Play_game screen
                game.setScreen(new Play_game(game));
            }
        });

        //add buttons to stage
        stage.addActor(level1Button);
        stage.addActor(level2Button);
        stage.addActor(level3Button);
        stage.addActor(level4Button);
        stage.addActor(level5Button);
        stage.addActor(level6Button);
        stage.addActor(level7Button);
        stage.addActor(level8Button);
        stage.addActor(level9Button);
        stage.addActor(level10Button);
        stage.addActor(level11Button);
        stage.addActor(level12Button);
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
    public void dispose() {
        batch.dispose();
        image.dispose();
        stage.dispose();
        level1.dispose();
        level2.dispose();
        level3.dispose();
        level4.dispose();
        level5.dispose();
        level6.dispose();
        level7.dispose();
        level8.dispose();
        level9.dispose();
        level10.dispose();
        level11.dispose();
        level12.dispose();

    }
}
