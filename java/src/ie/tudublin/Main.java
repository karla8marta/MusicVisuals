package ie.tudublin;

import example.CubeVisual;
import OurVisuals.GameOfNode;
import OurVisuals.Menu;
import example.MyVisual;
import example.RotatingAudioBands;

public class Main {

	public void startUI() {
		String[] a = { "MAIN" };
		processing.core.PApplet.runSketch(a, new GameOfNode());
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.startUI();
	}
}