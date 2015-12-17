package ml.dpgames.mine.screens;

import ml.dpgames.mine.MGMain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TitleScreen implements Screen {

	private static final SpriteBatch batch = new SpriteBatch();
	public static final OrthographicCamera camera = new OrthographicCamera();

	@Override
	public void show() {
		resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void render(float delta) {
		/*UPDATE*/{
			if (Gdx.input.isKeyJustPressed(Keys.ENTER) || Gdx.input.justTouched()) {
				MGMain.setTheScreen(new GameScreen());
			}
		}
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		/*RENDER*/{

		}
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		sResize(width, height);
	}

	public static void sResize(int width, int height) {
		if ((float) MGMain.WIDTH / MGMain.HEIGHT < (float) width / height) {
			camera.viewportHeight = MGMain.HEIGHT;
			camera.viewportWidth = getCamWidth(MGMain.HEIGHT);
		} else {
			camera.viewportHeight = getCamHeight(MGMain.WIDTH);
			camera.viewportWidth = MGMain.WIDTH;
		}
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

	/**
	 * Gets the width of a camera with specified height
	 * 
	 * @param camHeight
	 *            The height of the camera.
	 * @return The width of the camera.
	 */
	public static int getCamWidth(int camHeight) {
		// cam.height / cam.width = width / height
		// cam.width = (width * cam.height) / height
		int camWidth = (Gdx.graphics.getWidth() * camHeight) / Gdx.graphics.getHeight();
		return camWidth;
	}

	/**
	 * Gets the height of a camera with specified height
	 * 
	 * @param camWidth
	 *            The width of the camera.
	 * @return The height of the camera.
	 */
	public static int getCamHeight(int camWidth) {
		// cam.height / cam.width = width / height
		// cam.width = (width * cam.height) / height
		int camHeight = (Gdx.graphics.getHeight() * camWidth) / Gdx.graphics.getWidth();
		return camHeight;
	}

}
