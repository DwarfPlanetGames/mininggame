package ml.dpgames.mine.objects.blocks;

import ml.dpgames.mine.Chunk;
import ml.dpgames.mine.objects.Block;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class GrassBlock extends Block {

	@Override
	public void render(SpriteBatch batch, Vector2 location) {
		TextureRegion reg = new TextureRegion(Chunk.blockSheet, 32*2,0,32,32);
		batch.draw(reg, location.x, location.y, Block.size, Block.size);
	}

}
