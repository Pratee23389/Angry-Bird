package io.github.Angry_Bird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class Main extends Game {
    private Screen previousScreen;
    @Override
    public void create() {
        setScreen(new Loading_Screen(this));
    }

    public void setPreviousScreen(Screen previousScreen) {
        this.previousScreen = previousScreen;   //set previousScreen
    }

    public Screen getPreviousScreen() {
        return previousScreen; // Retrieve the previous screen
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
