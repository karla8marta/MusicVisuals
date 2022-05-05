package OurVisuals;

import ie.tudublin.Visual;
import processing.core.PApplet;
import ddf.minim.*;

public class DrumSet extends Visual{
    String[] songs = {"java/data/HomiesInParis2.mp3", "java/data/drum_kick.wav", "java/data/drum_snare.wav", "java/data/drum_hat.wav"};
    AudioPlayer ap, ap1, ap2, ap3;
    AudioBuffer ab;
    Minim minim;

    //to be lerped 
    float brightness_kick;
    float brightness_hat;
    float brightness_snare;

    //for making effects 
    boolean kickEffect = false;
    boolean hatEffect = false;;
    boolean snareEffect = false;

    public void settings()
    {
        size(512, 200);
    }
    public void setup()
    { 
        colorMode(HSB);
        minim = new Minim(this);

        
        ap = minim.loadFile(songs[0], 1024);
        ap1 = minim.loadFile(songs[1], 1024);
        ap2 = minim.loadFile(songs[2], 1024);
        ap3 = minim.loadFile(songs[3], 1024);

        ap.play();
    }

    public void keyPressed()
    {
        //kick
        if (key == 's')
		{
            brightness_kick = 255;
            ap1.play();
            ap1.rewind();
            kickEffect = true;
		}	
        //snare
		else if (key == 'd')
		{
            brightness_hat = 255;
            ap2.play();
            ap2.rewind();
            snareEffect = true;
		}
        //hat
        else if (key == 'a')
		{
            brightness_snare =255;
            ap3.play();
            ap3.rewind();
            hatEffect = true;
		}
    }

    public void keyReleased()
    {
        //kick
        if (key == 's')
        {
            kickEffect = false;
        }
        //snare
        if (key == 'd')
        {
            snareEffect = false;
        }

        //hat 
        if (key == 'a')
        {
            hatEffect = false;
        }
    }

    public void kickRender(float x1)
    {
        float y = (height/2);

        //Bottom echo effect
        fill(brightness_kick,255,brightness_kick);
        stroke(brightness_kick);
        //big echo
        arc(x1, (y)*1.5f, width/3f, width/7, 0, TWO_PI);
        //medium echo
        arc(x1, (y)*1.5f, width/3.5f, width/9, 0, TWO_PI);
        //small echo
        arc(x1, (y)*1.5f, width/4, width/12, 0, TWO_PI);

        stroke(255);
        
        
        //base
        fill(0);
        arc(x1, y, width/4, width/4, 0, PI);

        //name
        fill(255);
        textAlign(CENTER);
        text("KICK", x1, y+width/10);

        //lerping surface 
        brightness_kick = lerp(brightness_kick, 0, 0.02f);
        fill(brightness_kick,255,brightness_kick);
        arc(width/2, height/2, width/4, width/8, 0, TWO_PI);
        

        //if true make effect
        // line effect(x1)

        
        if (kickEffect == true)
        {
            starEffect(x1);
            linesEffect(x1, y);
            echoEffect(x1, y);
        }
        
    }

    public void snareRender(float x2)
    {
        float y = (height/2);

        //Bottom echo effect
        fill(brightness_hat,255,brightness_hat);
        stroke(brightness_hat);
        //big echo
        arc(x2, (y)*1.5f, width/3f, width/7, 0, TWO_PI);
        //medium echo
        arc(x2, (y)*1.5f, width/3.5f, width/9, 0, TWO_PI);
        //small echo
        arc(x2, (y)*1.5f, width/4, width/12, 0, TWO_PI);

        stroke(255);

        //base
        fill(0);        
        arc(x2, y, width/4, width/4, 0, PI);

        //name
        fill(255);
        textAlign(CENTER);
        text("SNARE", x2, y+width/10);


        //lerping surface 
        brightness_hat = lerp(brightness_hat, 0, 0.02f);
        fill(brightness_hat,255,brightness_hat);
        arc(x2, y, width/4, width/8, 0, TWO_PI);
        

        if (snareEffect == true)
        {
            starEffect(x2);
            linesEffect(x2, y);
            echoEffect(x2, y);
        }

    }

    public void hatRender(float x3)
    {
        float y = (height/2);

        //Bottom echo effect
        fill(brightness_snare,255,brightness_snare);
        stroke(brightness_snare);
        //big echo
        arc(x3, (y)*1.5f, width/3f, width/7, 0, TWO_PI);
        //medium echo
        arc(x3, (y)*1.5f, width/3.5f, width/9, 0, TWO_PI);
        //small echo
        arc(x3, (y)*1.5f, width/4, width/12, 0, TWO_PI);

        stroke(255);
        //base
        fill(0);
        arc(x3, y, width/4, width/4, 0, PI);

        //name
        fill(255);
        textAlign(CENTER);
        text("HAT", x3, y+width/10);

        //lerping surface 
        brightness_snare = lerp(brightness_snare, 0, 0.02f);
        fill(brightness_snare,255,brightness_snare);
        arc(x3, y, width/4, width/8, 0, TWO_PI);

        if (hatEffect == true)
        {
            starEffect(x3);
            linesEffect(x3, y);
            echoEffect(x3, y);
        }

        
    }

    public void echoEffect(float x,float y)
    {
        arc(x, y, width/3.5f, width/6, PI, HALF_PI+PI);
    };

    //happens when buttons pressed
    public void starEffect(float x)
    {   
        noFill();
        float cx = x;
        float cy = height / 2;	
        float radius = width/20;		
        int points = (int)map(250, 1, width, 5, 20);
        int sides = points * 2;
        float px = cx;
        float py = cy - radius; 
        for(int i = 0 ; i <= sides ; i ++)
        {
            float r = (i % 2 == 0) ? radius : radius / 2; 
            // float r = radius;
            float theta = map(i, 0, sides, 0, TWO_PI);
            x = cx + sin(theta) * r;
            float y = cy - cos(theta) * r ;
            
            //circle(x, y, 20);
            line(px+width/12, py-height/10, x+width/12, y-height/10);
            px = x;
            py = y;
        }
    }

    //happens when buttons pressed
    public void linesEffect(float x, float y)
    {
        float drumHalfWidth = (width/4)/2; // 64
        float drumHalfHeight = (width/8)/2; //32
        line(x-drumHalfWidth ,y-drumHalfHeight,x-drumHalfWidth-y/10,y-drumHalfHeight-y/10);
        line(x-drumHalfWidth+y/10 ,y-drumHalfHeight-y/12,x-drumHalfWidth+y/15,y-drumHalfHeight-(y/10)*2);
        line(x-drumHalfWidth+(y/10)*2 ,y-drumHalfHeight-(y/10),x-drumHalfWidth+(y/15)*2,y-drumHalfHeight-(y/10)*3);
        line(x-drumHalfWidth+y/3.5f ,y-drumHalfHeight-y/8,x-drumHalfWidth+y/4,y-drumHalfHeight-(y/10)*2.5f);
    }
        
    public void draw()
    {
        background(0);
        kickRender(width/2);
        hatRender(width/5);
        snareRender((width/5)*4);
        
    }
}