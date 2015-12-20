package ml.dpgames.mine.android;

import ml.dpgames.mine.Control;
import ml.dpgames.mine.MGMain;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MGMain(new Control() {
			@Override
			public void render(SpriteBatch batch) {
				
			}

			@Override
			public void update(float delta) {
			}
		}), config);
	}
}
