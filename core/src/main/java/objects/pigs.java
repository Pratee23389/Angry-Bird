package objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class pigs extends Image {
    public pigs(float x, float y, Texture pig) {
        super(pig);
        this.setPosition(x,y);
        this.setSize(45,45);
    }
}
