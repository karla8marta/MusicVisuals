package OurVisuals;

import processing.core.PApplet;

public class SpeakerEffect {
    GameOfNode gon;

    public SpeakerEffect(GameOfNode gon) {
        this.gon = gon;
    }

    public void render(float x, float y, float size)
    {
        for(int i = 0 ; i < gon.ab.size() ; i +=20)
        {
            gon.noFill();
            float c = PApplet.map(i, 0, gon.ab.size(), 0, 255);
            gon.stroke(c, 255, 255);
            float f = gon.getSmoothedAmplitude() * size;
            gon.circle(x, y, f); 
        }
    }
}