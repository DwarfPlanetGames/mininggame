package ml.dpgames.mine.objects.blocks;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ml.dpgames.mine.Chunk;
import ml.dpgames.mine.objects.Block;

public class DirtBlock extends Block {

	@Override
	public void render(SpriteBatch batch, Vector2 location) {
		TextureRegion reg = new TextureRegion(Chunk.blockSheet, 32 * 3,0,32,32);
		batch.draw(reg, location.x, location.y, Block.size, Block.size);
	}

}
