package OurVisuals;

import processing.core.PApplet;

public class Menu 
{
    GameOfNode gon;
    RobotMenu robots;
    Lines lines;
    Spiral spirals;

    public Menu(GameOfNode gon) {
        this.gon = gon;
        this.robots = new RobotMenu(gon);
        this.lines = new Lines(gon);
        this.spirals = new Spiral(gon);
    }

    public void drawMenu(String songName)
    {
        float border = gon.height / 6.0f;
        float halfW = gon.width / 2.0f;
        float c = PApplet.map(gon.getSmoothedAmplitude(), 0, 1, 0, 255);

        gon.textAlign(PApplet.CENTER, PApplet.CENTER);
        gon.textSize(40);
        gon.fill(c, 255, 255);
        gon.text("Game of Notes", halfW, border);

        gon.fill(255);
        gon.textSize(20);
        gon.text("Choose Song", halfW, border * 2);

        gon.textSize(30);
        gon.text(songName, halfW, border * 3);

        gon.noFill();
        gon.rectMode(PApplet.CENTER);
        gon.stroke(c, 255, 255);
        gon.strokeWeight(3);
        gon.rect(halfW, border * 4, PApplet.map(gon.getSmoothedAmplitude(), 0, 1, gon.width / 10, gon.width / 5),
        PApplet.map(gon.getSmoothedAmplitude(), 0, 1, gon.height / 10, gon.height / 7));

        gon.fill(255);
        gon.text("Start", halfW, border * 3.95f);
        gon.textSize(25);

        gon.stroke(c, 255, 255);
        gon.strokeWeight(5);
        drawArrow(halfW * 2 / 3, border * 3, halfW / 10, 179.0f);
        drawArrow(halfW * 4 / 3, border * 3, halfW / 10, 0.0f);

        lines.draw_lines();
        robots.render(halfW * 1 / 4, gon.height - border * 2);
        robots.render(halfW * 8 / 5, gon.height - border * 2);
        spirals.draw_spirals();
    }
    
    void drawArrow(float x, float y, float size, float angle) 
    {
        float arrowLength = size / 5.0f;
        gon.pushMatrix();
        gon.translate(x, y);
        gon.rotate(PApplet.radians(angle));
        gon.line(0, 0, size, 0);
        gon.line(size, 0, size - arrowLength, -arrowLength);
        gon.line(size, 0, size - arrowLength, arrowLength);
        gon.popMatrix();

    }
}
