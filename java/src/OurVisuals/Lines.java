package OurVisuals;

import processing.core.PApplet;

public class Lines {

    Menu menu;
    float lerpedAverage = 0;

    public Lines(Menu menu) {
        this.menu = menu;
    }

    public void draw_lines() {
        menu.pushMatrix();
        menu.lerpedAverage = PApplet.lerp(lerpedAverage, menu.getAmplitude(), 0.1f);
        float r = 1f;
        int shapes = 10;
        float size = 200;
        float calculate = PApplet.TWO_PI / (float) shapes;
        menu.strokeWeight(2);
        for (int i = 0; i < 500; i++) {
            menu.stroke(PApplet.map(menu.getAmplitude(), 0, 1, 0, 255), 255, 255, 100);
            float new_cal = i * (calculate + menu.lerpedAverage * 0.01f);
            float x = 50 + PApplet.sin(new_cal) * r;
            float y = 100 - PApplet.cos(new_cal) * r;
            menu.line(0, size, x, y);
            size = y;
            r += 0.5f + (menu.lerpedAverage * 0.01f);
        }
        menu.popMatrix();
    }

}