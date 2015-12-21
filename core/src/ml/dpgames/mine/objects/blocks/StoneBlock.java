package ml.dpgames.mine.objects.blocks;

import java.util.Random;

import ml.dpgames.mine.Chunk;
import ml.dpgames.mine.objects.Block;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class StoneBlock extends Block {
	public static final Random rand = new Random();
	@Override
	public void render(SpriteBatch batch, Vector2 location) {
		rand.setSeed(location.hashCode());
		TextureRegion reg = new TextureRegion(Chunk.blockSheet, 0, 0, 32, 32);
		batch.draw(reg, location.x, location.y, 16,16,32,32,Block.size / 32, Block.size/32,0);
	}

}
