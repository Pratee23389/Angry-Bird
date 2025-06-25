package io.github.Angry_Bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class Loading_Screen implements Screen {
    private Main game;
    private SpriteBatch batch;
    private Texture image;
    private int screenWidth, screenHeight;

    private ShapeRenderer shapeRenderer;
    private BitmapFont font;

    private boolean loadingCompleted = false;

    private float progress;

    public Loading_Screen(Main game){
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        image = new Texture("loading_screen.jpg");   //load background
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        progress = 0f;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);

        if (progress < 1) {
            batch.begin();
            batch.draw(image, 0, 0, screenWidth, screenHeight); // Draw the image scaled to the entire screen

            batch.end();
            progress += Gdx.graphics.getDeltaTime() * 0.2f; // Increment progress over time
            drawLoadingBar();}
        else if (!loadingCompleted) {
            loadingCompleted = true;
            game.setScreen(new Home_Screen(game));    //transition to Home_Screen after loading is completed
        }

    }

    private void drawLoadingBar() {
        // Get the width and height of the screen
        int screenWidth = Gdx.graphics.getWidth();

        // Calculate the width of the loading bar based on the progress
        float barWidth = screenWidth * 0.3f; // 60% of screen width
        float barHeight = 18f;
        float cornerRadius = 8f;
        float yPosition = 80f;

        float loadingBarProgress = barWidth * progress; // bar width * current progress

        // Draw the background bar
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect((screenWidth - barWidth) / 2 + cornerRadius, yPosition, barWidth - 2 * cornerRadius, barHeight);
        shapeRenderer.rect((screenWidth - barWidth) / 2, yPosition + cornerRadius, barWidth, barHeight - 2 * cornerRadius);

        // Draw arcs for rounded corners (background bar)
        shapeRenderer.arc((screenWidth - barWidth) / 2 + cornerRadius, yPosition + cornerRadius, cornerRadius, 180, 90); // Bottom-left corner
        shapeRenderer.arc((screenWidth + barWidth) / 2 - cornerRadius, yPosition + cornerRadius, cornerRadius, 270, 90); // Bottom-right corner
        shapeRenderer.arc((screenWidth - barWidth) / 2 + cornerRadius, yPosition + barHeight - cornerRadius, cornerRadius, 90, 90); // Top-left corner
        shapeRenderer.arc((screenWidth + barWidth) / 2 - cornerRadius, yPosition + barHeight - cornerRadius, cornerRadius, 0, 90); // Top-right corner

        // Draw the loading bar progress
        shapeRenderer.setColor(Color.ORANGE);

        shapeRenderer.rect((screenWidth - barWidth) / 2 + cornerRadius, yPosition, loadingBarProgress - 2 * cornerRadius, barHeight);
        shapeRenderer.rect((screenWidth - barWidth) / 2, yPosition + cornerRadius, loadingBarProgress, barHeight - 2 * cornerRadius);

        shapeRenderer.arc((screenWidth - barWidth) / 2 + cornerRadius, yPosition + cornerRadius, cornerRadius, 180, 90); // Bottom-left progress
        shapeRenderer.arc((screenWidth - barWidth) / 2 + cornerRadius, yPosition + barHeight - cornerRadius, cornerRadius, 90, 90); // Top-left progress
        shapeRenderer.arc((screenWidth - barWidth) / 2 + loadingBarProgress - cornerRadius, yPosition  + cornerRadius, cornerRadius, 270, 90); // Bottom-right progress
        shapeRenderer.arc((screenWidth - barWidth) / 2 + loadingBarProgress - cornerRadius, yPosition + barHeight - cornerRadius, cornerRadius, 0, 90); // Top-right progres


        shapeRenderer.end();

        // Draw progress percentage as text
        batch.begin();
        font.draw(batch, (int)(progress * 100) + "%", screenWidth / 2 - 15,  yPosition + 15);
        font.draw(batch, "Loading", screenWidth / 2 - 30,  yPosition - 10);
        batch.end();
    }

    @Override
    public void resize (int width, int height){
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
        shapeRenderer.dispose();
        font.dispose();
        }
}
