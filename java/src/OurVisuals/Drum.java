package OurVisuals;

import processing.core.PApplet;

public class Drum 
{
    GameOfNode gon;
    String drumType;
    String soundPath;
    float brightness = 0;
    float x = 0;
    float y = 0;
    float size = 0;
    boolean hitEffect = false;
    
    public Drum(GameOfNode gon, String type, String path) {
        this.gon = gon;
        this.drumType = type;
        this.soundPath = path;
    }

    public void render(float x, float y, float size)
    {
        this.x = x;
        this.y = y;
        this.size = size;

        if (hitEffect)
        {
            //Bottom echo effect
            gon.strokeWeight(0.5f);
            for (int i = 0; i < 3; i++)
            {
                gon.fill(brightness + i * 30,255,brightness + i * 30);
                gon.stroke(brightness + i * 30);
                gon.ellipse(x, y + size / 2, size * 3 / 2 - i * 30, size / 2 - i * 15);
            }
        }


        gon.stroke(255);
        gon.strokeWeight(2);
        
        //base
        gon.fill(0);
        gon.arc(x, y, size, size, 0, PApplet.PI);

        //name
        gon.fill(255);
        gon.textAlign(PApplet.CENTER);
        gon.textSize(20);
        gon.text(drumType, x, y + size * 2 / 3);

        //lerping surface 
        brightness = PApplet.lerp(brightness, 0, 0.2f);
        gon.fill(brightness,255,brightness);
        gon.ellipse(x, y, size, size / 2);
        

        //if true make effect
        if (hitEffect)
        {
            starEffect(x + size / 4, y - size / 8);
            linesEffect();
            echoEffect();
        }
        
    }

    public void drumHit()
    {
        gon.loadAudio(soundPath);
        gon.ap1 = gon.getAudioPlayer();
        gon.ap1.play();
        gon.ab = gon.ap1.mix;
        gon.ap1.rewind();

        hitEffect = true;
        brightness = 255;
    }

    public void echoEffect()
    {
        gon.arc(x - size / 16, y - size / 16, size, size / 2, PApplet.PI, PApplet.PI * 3 / 2);
    };

    //happens when buttons pressed
    public void starEffect(float cx, float cy)
    {   
        gon.noFill();
        float angle = PApplet.TWO_PI / 10;
		gon.beginShape();
		for (float a = 0; a < PApplet.TWO_PI; a += angle)
		{
			float sx = cx + PApplet.cos(a) * size / 8;
			float sy = cy + PApplet.sin(a) * size / 8;
			gon.vertex(sx, sy);
			sx = cx + PApplet.cos(a + angle / 2) * (size / 8 + 10);
			sy = cy + PApplet.sin(a + angle / 2) * (size / 8 + 10);
			gon.vertex(sx, sy);
		}
		gon.endShape(PApplet.CLOSE);
    }

    //happens when buttons pressed
    public void linesEffect()
    {
        gon.stroke(255);
        float length = 20;
        
        gon.pushMatrix();
        gon.translate(x - size / 4, y - size * 2 / 5);
        gon.line(0, 0, 0, -length);
        gon.rotate(-PApplet.QUARTER_PI);
        gon.line(-10, 0, -10, -length);
        gon.popMatrix();
    }
}