package OurVisuals;

import processing.core.PApplet;

public class Spiral {

    GameOfNode gon;
    float lerpedAverage;

    public Spiral(GameOfNode gon) {
        this.gon = gon;
        this.lerpedAverage = 0;
    }

    public void draw_spirals() {
        float r = 2f;
        int numPoints = 30;
        float thetaInc = PApplet.TWO_PI + PApplet.PI / (float) numPoints;
        lerpedAverage = PApplet.lerp(lerpedAverage, gon.getAmplitude(), 0.1f);
        gon.strokeWeight(2);
        float X = gon.height / 6.0f * 3, Y = 0;
        for (int i = 0; i < 125; i++) {
            float c = PApplet.map(i, 0, 125, 0, 255) % 255.0f;
            gon.stroke(c, 255, 255, 100);
            float theta = i * (thetaInc + lerpedAverage * 5);
            float x = gon.width + PApplet.sin(theta) * r;
            float y = 0 - PApplet.cos(theta) * r;
            r += 2.5f + lerpedAverage;
            gon.line(X, Y, x, y);
            gon.line(X, Y, x, y);
            X = x;
            Y = y;
        }
    }

}