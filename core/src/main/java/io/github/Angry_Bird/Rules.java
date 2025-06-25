package io.github.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Rules implements Screen {
    private Main game;
    private SpriteBatch batch;
    private Texture image;
    private Stage stage;
    private ScrollPane scrollPane;

    public Rules(Main game){
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        image = new Texture("Rule.png");    //load background

        stage = new Stage(new ScreenViewport());   //set up stage
        Gdx.input.setInputProcessor(stage);

        String rules = "1. Slingshot Mechanics:\n" +
"    *Bird Launching: You launch birds using a slingshot by pulling back on the bird, adjusting the angle and force of the shot.\n" +
"    *Trajectory Control: The trajectory of the bird is controlled by how far back you pull the slingshot and at what angle you release it.\n" +
"2. Birds:\n" +
"    *Different Bird Types: Each bird type has unique abilities.\n" +
"    *Red Bird: Basic bird with no special power.\n" +
"    *Blue Bird: Splits into three smaller birds when tapped mid-air.\n" +
"    *Yellow Bird: Speeds up when tapped mid-air.\n" +
"    *Black Bird: Explodes after impact or a short delay.\n" +
"    *White Bird: Drops explosive eggs when tapped mid-air.\n" +
"    *Limited Number of Birds: You have a fixed number of birds per level, and using them strategically is key to success.\n" +
"3. Objective:\n" +
"    *Defeat the Pigs: The goal is to defeat all the pigs on the level, typically positioned inside or around structures made of wood, stone, and glass.\n" +
"    *Destroy Structures: You can either directly hit the pigs or destroy structures to make them collapse on the pigs.\n" +
"4. Scoring System:\n" +
"    *Points for Damage: You earn points for destroying structures and defeating pigs.\n" +
"    *Bonus for Unused Birds: Any birds you have left at the end of the level grant extra points.\n" +
"    *Stars for Performance: You are rated on a 3-star scale based on your score. Achieving 3 stars requires high efficiency in defeating the pigs.\n" +
"5. Pigs:\n " +
"    *Pig Types: Pigs come in various sizes and toughness. Larger pigs are harder to defeat.\n" +
"    *King Pig: In some levels, the King Pig is the final target and is usually harder to defeat.\n" +
"6. Environmental Elements:\n" +
"    *Wood, Glass, Stone: The structures protecting the pigs are made of different materials.\n" +
"    *Wood: Weak and easily destroyed.\n" +
"    *Glass: Fragile, but more resistant than wood.\n" +
"    *Stone: Strongest and hardest to break.\n" +
"    *Gravity and Physics: The game relies heavily on physics. Structures will collapse if their support is destroyed.\n" +
"7. Special Abilities:\n" +
"    *Certain birds have special abilities that are triggered by tapping the screen while the bird is in mid-flight:\n" +
"    *Blue Bird: Splits into three.\n" +
"    *Yellow Bird: Gains speed.\n" +
"    *Black Bird: Explodes.\n" +
"    *White Bird: Drops an egg.\n" +
"8. Fail Conditions:\n" +
"    *All Birds Used, Pigs Remaining: If you use all your birds and pigs remain, you fail the level and must retry.\n" +
"10. Progression:\n" +
"    *Unlocking Levels: You must complete levels to unlock the next one.\n" +
"Strategy Tips:\n" +
"    *Aim for Weak Points: Target areas in the structure that cause the most collapse.\n" +
"    *Use Birds Efficiently: Don't waste birds. Try to cause as much damage as possible with each shot.\n" +
"    *Utilize Special Abilities: Tap the screen at the right time to activate bird abilities.\n";

        // Label for the rules
        Label rulesLabel = new Label(rules,new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        rulesLabel.setWrap(true);

        //scroll panel for rules
        scrollPane = new ScrollPane(rulesLabel);
        scrollPane.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() - 90);
        scrollPane.setPosition(0, 0);

        Texture back = new Texture("back_button.png");
        ImageButton BackButton = new ImageButton(new TextureRegionDrawable(back));

        BackButton.setSize(40, 40); // Set button size
        BackButton.setPosition( 20, Gdx.graphics.getHeight() - 60); // Set position of button


        BackButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to  Home_Screen
                game.setScreen(new Home_Screen(game));
            }
        });

        stage.addActor(BackButton);
        stage.addActor(scrollPane);

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
    }
}
