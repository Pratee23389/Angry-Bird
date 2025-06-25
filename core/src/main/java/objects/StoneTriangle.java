package objects;

import com.badlogic.gdx.graphics.Texture;

public class StoneTriangle extends structure{
    public StoneTriangle(float x, float y, float a, float b){
        super(x, y, a, b, new Texture("stone_plank.png"));
    }
}
