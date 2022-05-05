package OurVisuals;

import processing.core.PApplet;

public class Laser {
    GameOfNode gon;

    public Laser(GameOfNode gon) {
        this.gon = gon;
    }
    
    public void render(float x, float laserW, float y)
    {
        float f = PApplet.map(PApplet.abs(gon.getAmplitude()), 0, 1, gon.ab.size(), 10) / 5;

        for(int i = 0; i < gon.ab.size(); i += (int)f)
        { 
            float c = PApplet.map(i, 0, gon.ab.size(), 0, 255);
            gon.stroke(c, 255, 255);
            gon.strokeWeight(1);
            
            gon.line(x, y, gon.random(x - laserW / 2, x + laserW / 2), 0);
        }
    }
}
