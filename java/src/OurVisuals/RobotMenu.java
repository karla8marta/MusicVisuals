package OurVisuals;

import processing.core.PApplet;

public class RobotMenu {
    GameOfNode gon;

    public RobotMenu(GameOfNode gon) {
        this.gon = gon;
    }

    public void render(float x, float y) {
        float[] lerpedBuffer;
        lerpedBuffer = new float[gon.width];
        float sum = 0;
        float colour = PApplet.map(gon.getAmplitude(), 0, 1, 0, 255);

        gon.pushMatrix();
        gon.fill(0);
        gon.translate(x, y);
        gon.stroke(255);
        gon.strokeWeight(1);
        // draw boxes
        gon.rectMode(PApplet.CORNER);
        gon.rect(0, 0, 80, 75, 2); // draw big box
        gon.circle(15, 70, PApplet.map(gon.getAmplitude(), 0, 1, 1, 6));
        gon.circle(25, 70, PApplet.map(gon.getAmplitude(), 0, 1, 1, 6));
        gon.rect(10, 10, 60, 55, 2); // draw small tv
        gon.rect(23, -30, 35, 20, 2); // draw head

        gon.rect(35, -10, 20 - 10, 10, 2); // draw neck
        // draw face
        gon.fill(PApplet.map(gon.getAmplitude(), 0, 1, 150, 255), 255, 255);
        gon.stroke(255);
        gon.circle(30, -25, 7); // left eye
        gon.circle(52, -25, 7); // right eye
        gon.fill(0);
        gon.line(35, -15, 45, -15); // mouth
        gon.triangle(35, -30, 40, -45, 45, -30); // draw hat
        gon.fill(colour, 255, 255);
        gon.stroke(colour, 255, 255);

        gon.circle(40, -49, PApplet.map(gon.getAmplitude(), 0, 1, 5, 20));
        gon.stroke(255);
        gon.fill(0);

        // make legs
        gon.beginShape();
        gon.curveVertex(20, 75);
        gon.curveVertex(20, 75);
        gon.curveVertex(PApplet.map(gon.getAmplitude(), 0, 1, 0, 30), 105);
        gon.curveVertex(25, 130);
        gon.curveVertex(25, 130);
        gon.endShape();

        gon.beginShape();
        gon.curveVertex(30, 75);
        gon.curveVertex(30, 75);
        gon.curveVertex(PApplet.map(gon.getAmplitude(), 0, 1, 10, 40), 105);
        gon.curveVertex(35, 130);
        gon.curveVertex(35, 130);
        gon.endShape();

        gon.beginShape();
        gon.curveVertex(50, 75);
        gon.curveVertex(50, 75);
        gon.curveVertex(PApplet.map(gon.getAmplitude(), 0, 1, 40, 80), 105);
        gon.curveVertex(55, 130);
        gon.curveVertex(55, 130);
        gon.endShape();

        gon.beginShape();
        gon.curveVertex(60, 75);
        gon.curveVertex(60, 75);
        gon.curveVertex(PApplet.map(gon.getAmplitude(), 0, 1, 50, 90), 105);
        gon.curveVertex(65, 130);
        gon.curveVertex(65, 130);
        gon.endShape();

        // shoes
        gon.scale(1, -1);
        gon.arc(28, -135, 20, 20, 0, PApplet.PI);
        gon.arc(58, -135, 20, 20, 0, PApplet.PI);
        gon.line(20, -135, 38, -135);
        gon.line(50, -135, 68, -135);

        // fingers
        gon.strokeWeight(4);
        gon.arc(-28, -65, 15, 20, 0, PApplet.PI);
        gon.arc(110, -65, 15, 20, 0, PApplet.PI);
        gon.strokeWeight(2);

        // arms
        gon.scale(1, 1);
        gon.beginShape();
        gon.curveVertex(80, -15);
        gon.curveVertex(80, -15);
        gon.curveVertex(PApplet.map(gon.getAmplitude(), 0, 1, 90, 100), -25);
        gon.curveVertex(115, -57);
        gon.curveVertex(115, -57);
        gon.endShape();

        gon.beginShape();
        gon.curveVertex(80, -25);
        gon.curveVertex(80, -25);
        gon.curveVertex(PApplet.map(gon.getAmplitude(), 0, 1, 90, 100), -35);
        gon.curveVertex(105, -57);
        gon.curveVertex(105, -57);
        gon.endShape();

        gon.beginShape();
        gon.curveVertex(0, -25);
        gon.curveVertex(0, -25);
        gon.curveVertex(PApplet.map(gon.getAmplitude(), 0, 1, -10, -20), -35);
        gon.curveVertex(-23, -57);
        gon.curveVertex(-23, -57);
        gon.endShape();

        gon.beginShape();
        gon.curveVertex(0, -15);
        gon.curveVertex(0, -15);
        gon.curveVertex(PApplet.map(gon.getAmplitude(), 0, 1, -10, -20), -25);
        gon.curveVertex(-33, -57);
        gon.curveVertex(-33, -57);
        gon.endShape();

        for (int i = 0; i < gon.ab.size()/4; i++) {
            sum += PApplet.abs(gon.ab.get(i));
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], gon.ab.get(i), 0.05f);
        }

        for (int i = 200; i < gon.ab.size()/4; i++) {
            // float c = map(ab.get(i), -1, 1, 0, 255);
            float c = PApplet.map(i - 25, 0, gon.ab.size()/4, 0, 255);
            gon.stroke(c, 255, 255);
            float f = lerpedBuffer[i] * 100 * 4.0f;
            gon.line(-i + 268, -40 + f, -i + 268, -40 - f);
        }

        gon.popMatrix();

    }

}