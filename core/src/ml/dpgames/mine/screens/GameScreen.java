package ml.dpgames.mine.screens;

import java.util.HashMap;
import java.util.Random;

import ml.dpgames.mine.Chunk;
import ml.dpgames.mine.MGMain;
import ml.dpgames.mine.objects.Block;
import ml.dpgames.mine.objects.Player;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen implements Screen {

	private static final SpriteBatch batch = new SpriteBatch();
	public static final OrthographicCamera camera = TitleScreen.camera;
	public static final Player player = new Player(new Vector2(0,0));
	public static HashMap<Vector2, Chunk> chunks = new HashMap<Vector2, Chunk>();
	public static final long seed = System.nanoTime();
	public Random rand = new Random(seed);

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		/*UPDATE*/{
			MGMain.control.update(delta);
			player.update(delta);
		}
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.setColor(1, 1, 1, 1);
		/*RENDER*/{
			renderChunks(batch);
			player.render(batch);
			MGMain.control.render(batch);
		}
		batch.end();
	}
	
	public void renderChunks(SpriteBatch batch) {
		int xl = (int)(Player.position.x / Block.size / Chunk.chunkSize);
		int yl = (int)(Player.position.y / Block.size / Chunk.chunkSize);
		for (int x = xl - 2; x <= xl + 1; x++) {
			for (int y = yl - 2; y <= yl + 1; y++) {
				Chunk chunk = chunks.get(new Vector2(x,y));
				if (chunk != null) {
					chunk.render(batch, x, y);
				} else {
					chunks.put(new Vector2(x,y), new Chunk(x,y));
				}
			}
		}
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
