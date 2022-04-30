package OurVisuals;

import ie.tudublin.Visual;
import java.util.*;

public class Menu extends Visual {

    // array to store song names
    String[] display_names = { "Homies In Paris", "Hero Planet", "Masquerade" };
    // array to store file names
    String[] songs = { "HomiesInParis2.mp3", "heroplanet.mp3", "Masquerade.mp3" };
    // index of the song selected
    int song_index = 0;
    // array to store number of playes
    String[] players = { "1 player", "2 players" };
    int width = 800;
    int middleW = width / 2;
    int border = 120;
    int gap = 50;
    int arrowH = 30;
    float lerpedAverage = 0;
    Lines lines;

    public void settings() {

        size(800, 800);
        // fullScreen(P3D, SPAN);
    }

    public void setup() {

        colorMode(HSB);
        setFrameSize(256);
        startMinim();
        loadAudio(songs[song_index]);
        play_music();
        lines = new Lines(this);

    }

    public void play_music() {

        getAudioPlayer().close();
        loadAudio(songs[song_index]);
        getAudioPlayer().cue(0);
        getAudioPlayer().play();

    }

    public void mousePressed() {

        if (mouseX > middleW + border && mouseX < middleW + border + arrowH && mouseY > border * 2 + 35
                && mouseY < border * 2 + 35 + arrowH / 2) {

            song_index += 1;
            println(song_index);
            println(songs.length);

            if (song_index > songs.length - 1) {
                song_index -= 1;
            }

            play_music();

        }

        if (mouseX > border * 2 + 10 && mouseX < border * 2 + 10 + arrowH && mouseY > border * 2 + arrowH
                && mouseY < border * 2 + arrowH + arrowH / 2) {

            song_index -= 1;
            if (song_index < 0) {
                song_index += 1;
            }

            play_music();

        }

    }

    // draw arrows
    void drawArrow(int x, int y, int size, float angle) {

        pushMatrix();
        translate(x, y);
        rotate(radians(angle));
        line(0, 0, size, 0);
        line(size, 0, size - 8, -8);
        line(size, 0, size - 8, 8);
        popMatrix();

    }

    void drawMainScreen() {

        textAlign(CENTER);
        textSize(40);
        fill(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        text("Game of Notes", middleW, border);
        fill(255);
        textSize(30);
        text("Choose Song", middleW, border * 2);
        text("Number of Players", middleW, border * 3);
        text("Start", middleW, border * 5);
        textSize(25);
        // display song name here
        text(display_names[song_index], middleW, border * 2 + gap);
        // display number of player here
        text(players[0], middleW, border * 3 + gap);

    }

    public void draw() {

        background(0);
        calculateAverageAmplitude();
        calculateFrequencyBands();
        drawMainScreen();
        // change text colour with amplitude
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        // change this after
        drawArrow(middleW + border, border * 2 + gap - 8, arrowH, 0);
        drawArrow(border * 2 + gap - 8, border * 2 + gap - 8, arrowH, 179);
        drawArrow(middleW + border, border * 3 + gap - 8, arrowH, 0);
        drawArrow(border * 2 + gap - 8, border * 3 + gap - 8, arrowH, 179);
        lines.draw_lines();

    }
}