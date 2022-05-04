package OurVisuals;

import ie.tudublin.Visual;
import ddf.minim.*;
import processing.core.*;

public class GameOfNode extends Visual{
    Minim minim;
    AudioPlayer ap;
    AudioBuffer ab;

    Menu menu;
    Stage stage;

    String[] songsName = {"Homies In Paris", "Hero Planet", "Masquerade"};
    String[] songsPath = {"java/data/HomiesInParis2.mp3","java/data/heroplanet.mp3", "java/data/Masquerade.mp3"};

    int currSong = 0;
    boolean displayMenu = true;

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

        menu = new Menu(this);
    }

    public void keyPressed()
    {
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

        if (displayMenu)
        {
            menu.drawMenu(songsName[currSong]);
        }
    }
}
