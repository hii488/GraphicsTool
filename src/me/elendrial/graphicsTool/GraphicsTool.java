package me.elendrial.graphicsTool;

import me.elendrial.graphicsTool.graphics.Window;
import me.elendrial.graphicsTool.helpers.MathsHelper;
import me.elendrial.graphicsTool.scenes.Scene;

// NB: any angles are in radians here, as it makes it consistent with java's Math methods.
// TO THINK ABOUT: maybe switch out Vector with custom 3 direction class?
public class GraphicsTool {

	private static Scene loadedScene;
	public static boolean running = true;
	public static Window w;
	
	public static void main(String[] args) {
		w = new Window("Graphics Tool", 1080, 1080);
		w.createDisplay();
		w.start();
		
		Settings.startingScene.width = w.width;
		Settings.startingScene.height = w.height;
		loadScene(Settings.startingScene);
		
		renderScene();
		
	}
	
	
	public static void loadScene(Scene s) {
		loadedScene = s;
		loadedScene.load();
	}
	
	public static Scene getScene() {
		return loadedScene;
	}

	
	public static void renderScene() {
		w.render();
		wait(100);
		w.render();
		wait(1000);
		while(running) {
			w.render();
			wait(Settings.updateDelay);
			try {
				if(Settings.updating)
					loadedScene.update();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
