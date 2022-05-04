package OurVisuals;

import ie.tudublin.Visual;
import ddf.minim.*;

public class DrumSet extends Visual{
    String[] songs = {"java/data/HomiesInParis2.mp3", "java/data/drum_kick.wav", "java/data/drum_snare.wav", "java/data/drum_hat.wav"};
    AudioPlayer ap, ap1, ap2, ap3;
    AudioBuffer ab;
    Minim minim;

    public void settings()
    {
        size(512, 200);
    }
    public void setup()
    { 
        minim = new Minim(this);

        
        ap = minim.loadFile(songs[0], 1024);
        ap1 = minim.loadFile(songs[1], 1024);
        ap2 = minim.loadFile(songs[2], 1024);
        ap3 = minim.loadFile(songs[3], 1024);

        ap.play();
    }

    public void keyPressed()
    {
        if (key == 'a')
		{
            ap1.play();
            ap1.rewind();
		}	
		else if (key == 's')
		{
            ap2.play();
            ap2.rewind();
		}
        else if (key == 'd')
		{
            ap3.play();
            ap3.rewind();
		}
    }

    public void draw()
    {
        background(0);
        stroke(255);
        /*
        // draw the waveforms
        for(int i = 0; i < out.bufferSize() - 1; i++)
        {
            line( i, 50 + out.left.get(i)*50, i+1, 50 + out.left.get(i+1)*50 );
            line( i, 150 + out.right.get(i)*50, i+1, 150 + out.right.get(i+1)*50 );
        }
        */
    }
}
