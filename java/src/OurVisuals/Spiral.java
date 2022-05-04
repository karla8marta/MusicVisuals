package OurVisuals;

import processing.core.PApplet;

public class Spiral {

    Menu menu;
    float lerpedAverage = 0;

    public Spiral(Menu menu) {
        this.menu = menu;
    }

    public void draw_spirals() {
        float r = 1f;
        int numPoints = 10;
        float thetaInc = PApplet.TWO_PI + PApplet.PI / (float) numPoints;
        lerpedAverage = PApplet.lerp(lerpedAverage, menu.getAmplitude(), 0.1f);
        menu.strokeWeight(2);
        float X = menu.border * 3, Y = 0;
        for (int i = 0; i < 125; i++) {
            float c = PApplet.map(i, 0, 125, 0, 255) % 255.0f;
            menu.stroke(c, 255, 255, 100);
            float theta = i * (thetaInc + lerpedAverage * 5);
            float x = menu.width + PApplet.sin(theta) * r;
            float y = 0 - PApplet.cos(theta) * r;
            r += 2.5f + lerpedAverage;
            menu.line(X, Y, x, y);
            X = x;
            Y = y;
        }
    }

}