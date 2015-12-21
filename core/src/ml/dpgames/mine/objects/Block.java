package ml.dpgames.mine.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Block {
	public static final int size = 64;
	public boolean collide = true;

	public abstract void render(SpriteBatch batch, Vector2 location);
}
