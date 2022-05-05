package OurVisuals;

import processing.core.PApplet;

public class SpeakerEffect {
    GameOfNode gon;

    public SpeakerEffect(GameOfNode gon) {
        this.gon = gon;
    }

    public void render(float x, float y, float size, int circles)
    {
        for(int i = 0 ; i < gon.ab.size() ; i +=circles)
        {
            gon.noFill();
            float c = PApplet.map(i, 0, gon.ab.size(), 0, 255);
            gon.stroke(c, 255, 255);
            gon.strokeWeight(1);
            float f = gon.lerpedBuffer[i] * size * 3.0f;
            gon.circle(x, y, f); 
        }
    }
}