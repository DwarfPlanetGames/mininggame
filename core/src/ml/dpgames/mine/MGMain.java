package ml.dpgames.mine;

import ml.dpgames.mine.screens.TitleScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class MGMain extends Game {
	
	public static final int WIDTH = 720, HEIGHT = 480;
	public static Control control;
	
	public MGMain(Control control) {
		MGMain.control = control;
	}
	
	@Override
	public void create () {
		setTheScreen(new TitleScreen());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
	
	public static void setTheScreen(Screen screen) {
		((Game)Gdx.app.getApplicationListener()).setScreen(screen);
	}
}




