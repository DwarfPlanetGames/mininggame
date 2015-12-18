package ml.dpgames.mine.screens;

import ml.dpgames.mine.objects.Player;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {

	private static final SpriteBatch batch = new SpriteBatch();
	public static final OrthographicCamera camera = TitleScreen.camera;
	public static final Player player = new Player();

	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		/*UPDATE*/{
			player.update(delta);
		}
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		/*RENDER*/{
			player.render(batch);
		}
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		TitleScreen.sResize(width, height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}

}
