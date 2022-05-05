package OurVisuals;

import ie.tudublin.Visual;
import ddf.minim.*;
import processing.core.*;

public class GameOfNode extends Visual{
    Minim minim;
    AudioPlayer ap, ap1;
    AudioBuffer ab;

    Menu menu;
    Stage stage;
    Drum kick, snare, hat;

    String[] songsName = {"Homies In Paris", "Hero Planet", "Tequila Shots", "All the Things", "Masquerade"};
    String[] songsPath = {"java/data/HomiesInParis.mp3","java/data/heroplanet.mp3", "java/data/TequilaShots.mp3" ,"java/data/yunglean.mp3", "java/data/Masquerade.mp3"};

    int currSong = 0;
    boolean displayMenu = true;
    float[] lerpedBuffer;

    public void settings()
    {
        size(1000, 600);
    }

    public void setup()
    {
        colorMode(HSB);
        setFrameSize(1024);
        startMinim();
        changeMusic();
        lerpedBuffer = new float[ab.size()];

        menu = new Menu(this);
        stage = new Stage(this);
        kick = new Drum(this, "kick", "java/data/drum_kick.wav");
        snare = new Drum(this, "snare", "java/data/drum_snare.wav");
        hat = new Drum(this, "hat", "java/data/drum_hat.wav");
    }

    public void keyPressed()
    {
        if (keyCode == ' ')
        {
            if (ap.isPlaying())
            {
                ap.pause();
            }
            else
            {
                ap.loop();
            }
        }

        if(displayMenu)
        {
            if(keyCode == LEFT)
            {
                if (currSong == 0)
                {
                    currSong = songsName.length - 1;
                }
                else
                {
                    currSong--;
                }
                changeMusic();
            }
            else if(keyCode == RIGHT)
            {
                if (currSong == songsName.length - 1)
                {
                    currSong = 0;
                }
                else
                {
                    currSong++;
                }
                changeMusic();
            }
            else if (keyCode == ENTER)
            {
                displayMenu = false;
            }
        }
        else
        {
            if (key == 'a')
            {
                hat.drumHit();
            }
            else if (key == 's')
            {
                kick.drumHit();
            }
            else if (key == 'd')
            {
                snare.drumHit();
            }
        }
    }

    public void keyReleased()
    {
        if (!displayMenu)
        {
            if (key == 'a')
            {
                hat.hitEffect = false;
                ab = ap.mix;
            }
            else if (key == 's')
            {
                kick.hitEffect = false;
                ab = ap.mix;
            }
            else if (key == 'd')
            {
                snare.hitEffect = false;
                ab = ap.mix;
            }
        }
    }

    public void mousePressed()
    {
        if(displayMenu)
        {
            float border = height / 6.0f;
            float halfW = width / 2.0f;

            if (mouseX >= halfW - width / 20 && mouseX <= halfW + width / 20 && mouseY >= border * 4 - height / 20 && mouseY <= border * 4 + height / 20)
            {
                displayMenu = false;
            }
        }
        else
        {
            if (mouseX >= width * 5 / 36 && mouseX <= width * 7 / 36 && mouseY >= height * 31 / 40 && mouseY <= height * 33 / 40)
            {
                displayMenu = true;
            }
            else if(mouseX >= width * 29 / 36 && mouseX <= width * 31 / 36 && mouseY >= height * 31 / 40 && mouseY <= height * 33 / 40)
            {
                exit();
            }
        }
    }

    public void changeMusic()
    {
        if (ap != null && ap.isPlaying()) ap.close();
        loadAudio(songsPath[currSong]);
        ap = getAudioPlayer();
        ap.loop();
        ab = ap.mix;
    }

    public void draw()
    {
        background(0);
        calculateAverageAmplitude();
        calculateFrequencyBands();

        for(int i = 0 ; i < ab.size() ; i ++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], ab.get(i), 0.05f);
        }

        if (displayMenu)
        {
            menu.drawMenu(songsName[currSong]);
        }
        else
        {
            kick.render(width / 2, height * 3 / 4, width / 8);
            hat.render(width / 3, height * 3 / 4, width / 8);
            snare.render(width * 4 / 6, height * 3 / 4, width / 8);
            stage.drawStage();
        }
    }
}
