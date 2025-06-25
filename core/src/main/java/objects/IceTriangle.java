package objects;

import com.badlogic.gdx.graphics.Texture;

public class IceTriangle extends structure{
    public IceTriangle(float x, float y, float a, float b) {
        super(x, y, a, b, new Texture("ice_plank.png"));
    }
}
