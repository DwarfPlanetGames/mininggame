package ml.dpgames.mine.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ml.dpgames.mine.Control;
import ml.dpgames.mine.MGMain;

public class MGDesktop {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new MGMain(new Control(){
			@Override
			public void render(SpriteBatch batch) {
			}

			@Override
			public void update(float delta) {
			}
		}), config);
	}
}
