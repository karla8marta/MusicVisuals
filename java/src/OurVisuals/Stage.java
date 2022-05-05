package OurVisuals;

import processing.core.PApplet;

public class Stage
{
    GameOfNode gon;
    SpeakerEffect se;
    Laser ls;
    RobotStage rs;

    public Stage(GameOfNode gon) {
        this.gon = gon;
        this.se = new SpeakerEffect(gon);
        this.ls = new Laser(gon);
        this.rs = new RobotStage(gon);
    }

    public void drawStage()
    {
        float halfW = gon.width / 2.0f;
        float halfH = gon.height / 2.0f;
        float border = gon.width / 100.0f;
        float bSpeakerW = (gon.width - halfW - border * 2) / 4.0f;
        float sSpeakerW = bSpeakerW - border * 4.0f;
        float bSpeakerH = halfH / 5.0f;
        float sSpeakerH = halfH * 3 / 5.0f;
        float lSpeakerCircleX = border + bSpeakerW / 2.0f;
        float rSpeakerCircleX = gon.width - border - bSpeakerW / 2.0f;
        float laserX = 0;
        float laserY = 0;
        float laserTimer = 0;
        
        // dj booth
        gon.noFill();
        gon.stroke(255);
        gon.strokeWeight(1);
        gon.rectMode(PApplet.CENTER);
        gon.rect(halfW, halfH, halfW, halfH / 3);
        // dj
        drawDJ(halfW, halfH / 2, halfW / 8);
        // booth
        drawBoothWave(halfW / 2, halfW * 3 / 2, halfH, halfH / 3);

        // speaker left
        gon.stroke(255);
        gon.strokeWeight(1);
        gon.rectMode(PApplet.CORNER);
        gon.rect(border, bSpeakerH, bSpeakerW, halfH);
        gon.rect(border + bSpeakerW, sSpeakerH, bSpeakerW, sSpeakerH);
        gon.rect(border * 3, halfH / 2, sSpeakerW, sSpeakerH);
        // speaker right
        gon.rect(gon.width - border - bSpeakerW, bSpeakerH, bSpeakerW, halfH);
        gon.rect(gon.width - border - bSpeakerW * 2, sSpeakerH, bSpeakerW, sSpeakerH); 
        gon.rect(gon.width - bSpeakerW + border, halfH / 2, sSpeakerW, sSpeakerH);
        // speaker circle
        for (int i = 0; i < 3; i++)
        {
            float gap = 14.0f;
            gon.circle(lSpeakerCircleX, bSpeakerH + halfH / 6, bSpeakerW / 2 - i * gap);
            gon.circle(rSpeakerCircleX, bSpeakerH + halfH / 6, bSpeakerW / 2 - i * gap);
            gon.ellipse(lSpeakerCircleX + bSpeakerW, sSpeakerH * 3 / 2, bSpeakerW / 2 - i * gap, sSpeakerH * 3 / 4 - i * gap * 2);
            gon.ellipse(rSpeakerCircleX - bSpeakerW, sSpeakerH * 3 / 2, bSpeakerW / 2 - i * gap, sSpeakerH * 3 / 4 - i * gap * 2);
            for (int j = 1; j <= 3; j++)
            {
                gon.circle(lSpeakerCircleX, halfH / 2 + sSpeakerH * j / 4, sSpeakerW / 2 - i * gap / 2);
                gon.circle(rSpeakerCircleX, halfH / 2 + sSpeakerH * j / 4, sSpeakerW / 2 - i * gap / 2);
            }
        }
        // speaker effects
        se.render(lSpeakerCircleX, bSpeakerH + halfH / 6, halfW, 40);
        se.render(rSpeakerCircleX, bSpeakerH + halfH / 6, halfW, 40);
        se.render(lSpeakerCircleX + bSpeakerW, sSpeakerH * 3 / 2, halfW, 10);
        se.render(rSpeakerCircleX - bSpeakerW, sSpeakerH * 3 / 2, halfW, 10);

        // laser eye it run 10 sec, stop 5 sec
        laserTimer = gon.millis() / 1000.0f % 15;

        gon.stroke(255, 255, 255);
        gon.strokeWeight(0.5f);
        if (laserTimer >= 0 && laserTimer <= 10)
        {
            laserY = PApplet.map(laserTimer % 10, 0, 10, 0, gon.height);
            for (int i = 0; i < gon.ab.size(); i += 5)
            {
                laserX = PApplet.map(i, 0, gon.ab.size(), 0, gon.width);
                gon.line(halfW, halfH / 2, laserX, laserY);
            }
        }

        // robots laser
        ls.render(halfW * 8 / 9, halfW, halfH / 3 - 8);
        ls.render(halfW * 10 / 9, halfW, halfH / 3 - 8);

        // robots
        rs.renderRobot(gon.width * 5/6, gon.height* 4/5, "QUIT", false, true);
        rs.renderRobot(gon.width * 1/6, gon.height* 4/5, "MENU", true, true);
        rs.renderRobot(gon.width * 3/8-5, gon.height* 2/7-8, "NO", true, false);
        rs.renderRobot(gon.width * 5/8+5, gon.height* 2/7-8, "JAZZ", false, false);
    }

    public void drawDJ(float x, float y, float size)
    {
        float halfS = size / 2;
        float eyebrowsL = 7;

        gon.pushMatrix();
        gon.translate(x, y - halfS);
        //triangle
        gon.fill(255 / 6.0f, 200, 255);
        gon.stroke(255);
        gon.triangle(0, 0, -halfS, size, halfS, size);
        //eyebrows
        gon.noFill();
        gon.stroke(0);
        gon.line(0, halfS * 3 / 4, 0, halfS * 3 / 4 - eyebrowsL);
        gon.line(-eyebrowsL * 2 / 3, halfS * 3 / 4, -eyebrowsL, halfS * 3 / 4 - eyebrowsL  * 2 / 3);
        gon.line(eyebrowsL * 2 / 3, halfS * 3 / 4, eyebrowsL, halfS * 3 / 4 - eyebrowsL  * 2 / 3);
        //eyes
        gon.fill(255);
        gon.ellipse(0, halfS, halfS - 5, halfS / 2);
        gon.fill(0);
        gon.ellipse(0, halfS, halfS / 5, halfS / 3);
        //bowtie
        gon.fill(0);
        gon.triangle(0, size - halfS / 2, -halfS / 3, size - halfS * 2 / 3, -halfS / 3, size - halfS * 2 / 5);
        gon.triangle(0, size - halfS / 2, halfS / 3, size - halfS * 2 / 3, halfS / 3, size - halfS * 2 / 5);
        //hat
        gon.noFill();
        gon.stroke(255);
        gon.beginShape();
        gon.vertex(-halfS / 2, 0);
        gon.vertex(-halfS / 2, -3);
        gon.vertex(-halfS / 4, -3);
        gon.vertex(-halfS / 4, -halfS * 2 / 3);
        gon.vertex(halfS / 4, -halfS * 2 / 3);
        gon.vertex(halfS / 4, -3);
        gon.vertex(halfS / 2, -3);
        gon.vertex(halfS / 2, 0);
        gon.vertex(-halfS / 2, 0);
        gon.endShape();
        gon.popMatrix();
        
        gon.pushMatrix();
        gon.translate(x, y + halfS);
        //legs
        gon.line(-size / 4, 0, -size / 4, halfS * 2 / 3);
        gon.line(-size / 4, halfS * 2 / 3, -size / 8, halfS / 3);
        gon.line(-size / 8, halfS / 3, -size / 8, halfS * 3 / 4);
        //right leg
        gon.line(size / 4, 0, size / 4, halfS * 2 / 3);
        gon.line(size / 4, halfS * 2 / 3, size / 8, halfS / 3);
        gon.line(size / 8, halfS / 3, size / 8, halfS * 3 / 4);
        gon.popMatrix();

        //arms
        gon.arc(x - halfS * 3 / 4, y, halfS, halfS, PApplet.HALF_PI, PApplet.PI); 
        //right
        gon.arc(x + halfS * 3 / 4, y, halfS, halfS, 0, PApplet.HALF_PI); 
    }

    public void drawBoothWave(float leftEdge, float rightEdge, float waveY, float waveH)
    {
        for(int i = (int)leftEdge + 10; i < (int)rightEdge; i += 10)
        {
            float c = PApplet.map(i, leftEdge, rightEdge, 255 / 4.0f, 255 * 3 / 4.0f);
            gon.stroke(c, 255, 255);
            gon.strokeWeight(3);
            float f = PApplet.map(gon.lerpedBuffer[i], 0, 1, 0, waveH) * 1.5f;
            gon.line(i, waveY - f, i, waveY + f);
        }
    }
}
