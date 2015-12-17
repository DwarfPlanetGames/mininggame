package ml.dpgames.mine;

import java.util.HashMap;

import ml.dpgames.mine.objects.blocks.Block;

import com.badlogic.gdx.math.Vector2;

public class Chunk {

	private final HashMap<Vector2, Block> blocks = new HashMap<Vector2, Block>();

	public Block getBlock(int x, int y) {
		if (blocks.containsKey(new Vector2(x, y))) {
			return blocks.get(new Vector2(x, y));
		}
		return null;
	}

	public Block replace(int x, int y, Block block) {
		Block ret = null;
		if (blocks.containsKey(new Vector2(x,y))) {
			ret = blocks.get(new Vector2(x,y));
		}
		blocks.put(new Vector2(x,y), block);
		return ret;
	}

}
