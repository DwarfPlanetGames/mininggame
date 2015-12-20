package ml.dpgames.mine.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {
	
	public static final Vector2 motion = new Vector2(0,0);
	public static float speed = 80;
	public static Vector2 position = new Vector2(0,0);
	
	public Player(Vector2 pos) {
		position = pos;
	}
	
	public void update(float delta) {
		position.x += motion.x * speed * delta;
		position.y += motion.y * speed * delta;
		motion.x = 0;
		motion.y = 0;
	}
	
	public void render(SpriteBatch batch) {
		
	}
	
}
