package objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Sling extends Image {
    public Sling(float x, float y) {
        super(new Texture(Gdx.files.internal("sling.png")));
        this.setPosition(x,y);
        this.setSize(100,100);
    }
}
