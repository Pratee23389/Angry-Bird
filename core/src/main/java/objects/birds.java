package objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


abstract public class birds extends Image {
    public  birds(float x, float y, float a, float b, Texture bird){
        super(bird);
        this.setPosition(x,y);
        this.setSize(a, b);
    }
}
