package ml.dpgames.mine;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

import ml.dpgames.mine.objects.Block;
import ml.dpgames.mine.objects.blocks.LeafBlock;
import ml.dpgames.mine.objects.blocks.StoneBlock;
import ml.dpgames.mine.objects.blocks.WoodBlock;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Chunk implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int chunkSize = 32;
	public static final Texture blockSheet = new Texture("block_sheet.png");
	private final HashMap<Vector2, Block> blocks = new HashMap<Vector2, Block>();
	// private final HashMap<Vector2, TextureRegion> backgrounds = new
	// HashMap<Vector2, TextureRegion>();
	public static long seed = System.nanoTime();
	public int type; // 0 - plains; 1 - forest; 2 - cave; 3 - desert;
	public int x, y;

	public Chunk(int x, int y) {
		this.x = x;
		this.y = y;
		long seed = (String.valueOf(Chunk.seed) + String.valueOf(x) + String.valueOf(y)).hashCode();
		MGMain.println("Creating new chunk with seed: " + seed);
		boolean[][] rawMap = generateRawMap(seed);
		for (int i = 0; i < 5; i++) {
			rawMap = smoothMap(rawMap);
		}
		blocks.clear();
		switch (type) {
		case 2:
			for (x = 0; x < chunkSize; x++) {
				for (y = 0; y < chunkSize; y++) {
					if (rawMap[x][y]) {
						replace(x, y, new StoneBlock());
					}
				}
			}
			break;
		case 3:
			for (x = 0; x < chunkSize; x++) {
				for (y = 0; y < chunkSize; y++) {
					if (rawMap[x][y]) {
						replace(x, y, new LeafBlock());
					}
				}
			}
			break;
		default:
			for (x = 0; x < chunkSize; x++) {
				for (y = 0; y < chunkSize; y++) {
					if (rawMap[x][y]) {
						if (getNeighbors(rawMap, x, y) > 6) {
							replace(x, y, new WoodBlock());
						} else {
							replace(x, y, new LeafBlock());
						}
					}
				}
			}
			break;
		}
	}

	public boolean[][] generateRawMap(long seed) {
		Random rand = new Random(seed);
		for (int i = 0; i < 10; i++) {
			rand.nextInt();
		}
		type = rand.nextInt(4);
		int chance = new int[] { 25, 40, 52, 52 }[type];
		boolean[][] map = new boolean[chunkSize][chunkSize];
		for (int x = 0; x < chunkSize; x++) {
			for (int y = 0; y < chunkSize; y++) {
				map[x][y] = rand.nextInt(100) <= chance;
			}
		}
		return map;
	}

	public boolean[][] smoothMap(boolean[][] map) {
		boolean[][] submap = new boolean[chunkSize][chunkSize];
		for (int x = 0; x < chunkSize; x++) {
			for (int y = 0; y < chunkSize; y++) {
				submap[x][y] = map[x][y];
			}
		}
		for (int x = 0; x < chunkSize; x++) {
			for (int y = 0; y < chunkSize; y++) {
				int n = getNeighbors(submap, x, y);
				if (n < 4)
					map[x][y] = false;
				if (n > 4)
					map[x][y] = true;
			}
		}
		return map;
	}

	public int getNeighbors(boolean map[][], int xl, int yl) {
		int count = 0;
		for (int x = xl - 1; x <= xl + 1; x++) {
			for (int y = yl - 1; y <= yl + 1; y++) {
				if (x >= 0 && y >= 0 && x < chunkSize && y < chunkSize) {
					if (x != xl || y != yl) {
						count += map[x][y] ? 1 : 0;
					}
				}
			}
		}
		return count;
	}

	public Block getBlock(int x, int y) {
		if (blocks.containsKey(new Vector2(x, y))) {
			return blocks.get(new Vector2(x, y));
		}
		return null;
	}

	public Block replace(int x, int y, Block block) {
		if (!(x >= 0 && y >= 0 && x < chunkSize && y < chunkSize)) {
			throw new ArrayIndexOutOfBoundsException(x > y ? ("x is " + x) : ("y is " + y));
		}
		Block ret = null;
		if (blocks.containsKey(new Vector2(x, y))) {
			ret = blocks.get(new Vector2(x, y));
		}
		blocks.put(new Vector2(x, y), block);
		return ret;
	}

	public void render(SpriteBatch batch, int xl, int yl) {
		for (int x = 0; x < chunkSize; x++) {
			for (int y = 0; y < chunkSize; y++) {
				Block block = getBlock(x, y);
				if (block != null) {
					block.render(batch, new Vector2(xl * chunkSize * Block.size + x * Block.size, yl * chunkSize * Block.size + y * Block.size));
				}
			}
		}
	}

	public void close() {
		System.out.println("Writing chunk " + x + " " + y + " to file");
		try {
			ObjectOutputStream os = new ObjectOutputStream(Gdx.files.external(MGMain.saveLoc + "/" + MGMain.worldName + "/world/" + x + ":" + y + ".bin").write(false));
			os.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void finalize() throws Throwable {
		try {
			close();
		} finally {
			super.finalize();
		}
	}

}
