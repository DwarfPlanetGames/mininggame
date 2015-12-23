package ml.dpgames.mine;

import java.util.LinkedList;

import ml.dpgames.mine.screens.GameScreen;
import ml.dpgames.mine.screens.TitleScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class MGMain extends Game {

	public static final int WIDTH = 1080, HEIGHT = 720;
	public static Control control;
	private static final LinkedList<Object> printQueue = new LinkedList<Object>();
	public static String worldName = "defaultWorld";
	public static String saveLoc = ".ml.dpgames/mininggame";

	public MGMain(Control control) {
		MGMain.control = control;
	}

	@Override
	public void create() {
		setTheScreen(new TitleScreen());
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
		if (printQueue.size() > 0) {
			System.out.print(printQueue.getFirst());
			printQueue.removeFirst();
		}
	}

	public static void setTheScreen(Screen screen) {
		((Game) Gdx.app.getApplicationListener()).setScreen(screen);
	}

	public static void print(Object o) {
		printQueue.add(o);
	}

	public static void println(Object o) {
		printQueue.add(o + "\n");
	}
	
	@Override
	public void dispose() {
		GameScreen.chunks.clear();
		System.gc();
	}
}
