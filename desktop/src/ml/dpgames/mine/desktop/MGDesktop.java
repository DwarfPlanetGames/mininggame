package ml.dpgames.mine.desktop;

import ml.dpgames.mine.Control;
import ml.dpgames.mine.MGMain;
import ml.dpgames.mine.objects.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MGDesktop {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new MGMain(new Control(){
			@Override
			public void render(SpriteBatch batch) {
			}

			@Override
			public void update(float delta) {
				int mx = 0, my = 0;
				if (Gdx.input.isKeyPressed(Keys.W)) {
					my++;
				}
				if (Gdx.input.isKeyPressed(Keys.S)) {
					my--;
				}
				if (Gdx.input.isKeyPressed(Keys.D)) {
					mx++;
				}
				if (Gdx.input.isKeyPressed(Keys.A)) {
					mx--;
				}
				Player.motion.x = mx;
				Player.motion.y = my;
				if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
					Player.speed = 160 * 8;
				} else {
					Player.speed = 160;
				}
			}
		}), config);
	}
}
