package objects;

import com.badlogic.gdx.graphics.Texture;

public class WoodTriangle extends structure{
    public WoodTriangle(float x, float y, float a, float b){
        super(x, y, a, b, new Texture("wood_plank.png"));
    }
}
