package objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class structure extends Image {
    public structure(float x, float y, float a, float b, Texture structure){
        super(structure);
        this.setPosition(x,y);
        this.setSize(a, b);
    }
}
