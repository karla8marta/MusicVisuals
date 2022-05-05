package OurVisuals;

import processing.core.PApplet;

public class Lines {

    GameOfNode gon;
    float lerpedAverage;

    public Lines(GameOfNode gon) {
        this.gon = gon;
        this.lerpedAverage = 0;
    }

    public void draw_lines() {
        gon.pushMatrix();

        lerpedAverage = PApplet.lerp(lerpedAverage, gon.getAmplitude(), 0.1f);
        float r = 1f;
        int shapes = 10;
        float calculate = PApplet.TWO_PI / (float) shapes;
        float c = PApplet.map(gon.getAmplitude(), 0, 1, 0, 255);
        
        gon.strokeWeight(2);
        gon.stroke(c, 255, 255, 100);

        for (int i = 0; i < 500; i++) {
            float new_cal = i * (calculate + lerpedAverage * 0.01f);
            float x = 50 + PApplet.sin(new_cal) * r;
            float y = 100 - PApplet.cos(new_cal) * r;
            gon.line(0, gon.width / 5, x, y);
            r += 0.5f + (lerpedAverage * 0.01f);
        }
        gon.popMatrix();
    }

}