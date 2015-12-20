package ml.dpgames.mine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Control {
	public void render(SpriteBatch batch);
	public void update(float delta);
}
