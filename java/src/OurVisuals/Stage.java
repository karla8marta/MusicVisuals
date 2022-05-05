package OurVisuals;

import processing.core.PApplet;

public class Stage
{
    GameOfNode gon;
    SpeakerEffect se;

    public Stage(GameOfNode gon) {
        this.gon = gon;
        this.se = new SpeakerEffect(gon);
    }

    public void drawStage()
    {
        /*
        int last = 0;

        gon.noFill();
        float halfH = gon.height / 2;
        int m = gon.millis();
        m = gon.millis()-last;

        float secondsToY = map(m/10, 0, ab.size(),0,465);

        for(int i = 0 ; i < ab.size() ; i ++)
        {
        lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
        }

        float cx = width / 2;
        float cy = height / 2;
        float stageEdgeLeft = cx/2;
        float stageEdgeRight = cx*1.5f;
`       */

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
        //speaker left
        gon.rectMode(PApplet.CORNER);
        gon.rect(border, bSpeakerH, bSpeakerW, halfH);
        gon.rect(border + bSpeakerW, sSpeakerH, bSpeakerW, sSpeakerH);
        gon.rect(border * 3, halfH / 2, sSpeakerW, sSpeakerH);
        //speaker right
        gon.rect(gon.width - border - bSpeakerW, bSpeakerH, bSpeakerW, halfH);
        gon.rect(gon.width - border - bSpeakerW * 2, sSpeakerH, bSpeakerW, sSpeakerH); 
        gon.rect(gon.width - bSpeakerW + border, halfH / 2, sSpeakerW, sSpeakerH);
        //speaker circle
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

        // laser eye it run 10 sec, stop 5 sec

        laserTimer = gon.millis() / 1000.0f % 15;

        gon.stroke(255, 255, 255);
        gon.strokeWeight(0.5f);
        if (laserTimer >= 0 && laserTimer <= 10)
        {
            laserY = PApplet.map(laserTimer % 10, 0, 10, 0, gon.height);
            for (int i = 0; i < gon.ab.size(); i += 10)
            {
                laserX = PApplet.map(i, 0, gon.ab.size(), 0, gon.width);
                gon.line(halfW, halfH / 2, laserX, laserY);
            }
        }

        se.render(lSpeakerCircleX, bSpeakerH + halfH / 6, halfW / 3);
        /*
        //robots
        //robot 1
        textMode(CENTER);
        textSize(25); 
        fill(255);
        text("NO",(cx/1.5f), cy/2+5);
        noFill();
        rect(cx/1.5f, cy/2, cx/7, cx/8);
        rect(cx/1.5f, cy/2, cx/9, cx/10);
        arc(cx/1.5f, cy/2-32, cx/8, cx/6, PI, TWO_PI); 
        arc(cx/1.5f-15, cy/2-50, cx/30, cx/30, 0, TWO_PI);
        arc(cx/1.5f+15, cy/2-50, cx/30, cx/30, 0, TWO_PI);
        arc(cx/1.5f-15, cy/2-50, cx/50, cx/50, 0, TWO_PI);
        arc(cx/1.5f+15, cy/2-50, cx/50, cx/50, 0, TWO_PI);
        //LEGS + SHOES  
        line(cx/1.5f-20, cy/2+32, cx/1.5f-20 , cy/2+32+40 );
        line(cx/1.5f-10, cy/2+32, cx/1.5f-10 , cy/2+32+53 );
        line(cx/1.5f+20, cy/2+32, cx/1.5f+20 , cy/2+32+40 );
        line(cx/1.5f+10, cy/2+32, cx/1.5f+10 , cy/2+32+53 ); 
        arc(cx/1.5f-10, cy/2+32+53 , cx/8, cx/20, PI, PI+HALF_PI); 
        arc(cx/1.5f+10, cy/2+32+53 , cx/8, cx/20, PI+HALF_PI, TWO_PI);   

        //Arm
        arc(cx/1.5f-((cx/7)/2), cy/2+20 , cx/6, cx/6, PI, PI+HALF_PI); 
        arc(cx/1.5f-((cx/7)/2), cy/2+20 , cx/7, cx/7, PI, PI+HALF_PI); 
        arc(cx/1.5f+((cx/7)/2), cy/2+20-80 , cx/6, cx/6, 0, HALF_PI); 
        arc(cx/1.5f+ ((cx/7)/2), cy/2+20-80 , cx/7, cx/7, 0, HALF_PI ); 
        //Hands
        arc(cx/1.5f-((cx/7+cx/6)/2)+2,cx/2+28, cx/20, cx/20, PI, TWO_PI );
        arc(cx/1.5f+((cx/7+cx/6)/2)-2,cx/2-80, cx/20, cx/20, 0, PI ); 

        //robot 2
        fill(255);
        textSize(18);
        text("JAZZ",(cx/1.5f*2), cy/2+5);
        noFill();
        rect((cx/1.5f*2), cy/2, cx/7, cx/8);
        rect((cx/1.5f*2), cy/2, cx/9, cx/10);
        arc(cx/1.5f*2, cy/2-32, cx/8, cx/6, PI, TWO_PI);
        arc(cx/1.5f*2-15, cy/2-50, cx/30, cx/30, 0, TWO_PI);
        arc(cx/1.5f*2+15, cy/2-50, cx/30, cx/30, 0, TWO_PI);
        arc(cx/1.5f*2-15, cy/2-50, cx/50, cx/50, 0, TWO_PI);
        arc(cx/1.5f*2+15, cy/2-50, cx/50, cx/50, 0, TWO_PI);
        //LEGS + SHOES   
        line((cx/1.5f*2)-20, cy/2+32, (cx/1.5f*2)-20, cy/2+32+40 );
        line((cx/1.5f*2)-10, cy/2+32, (cx/1.5f*2)-10, cy/2+32+53 );
        line((cx/1.5f*2)+20, cy/2+32, (cx/1.5f*2)+20, cy/2+32+40 );
        line((cx/1.5f*2)+10, cy/2+32, (cx/1.5f*2)+10, cy/2+32+53 );
        arc((cx/1.5f*2)-10, cy/2+32+53 , cx/8, cx/20, PI, PI+HALF_PI); 
        arc((cx/1.5f*2)+10, cy/2+32+53 , cx/8, cx/20, PI+HALF_PI, TWO_PI); 
        //ARMS
        arc((cx/1.5f*2)-((cx/7)/2), cy/2+20-80 , cx/6, cx/6, HALF_PI, PI); 
        arc((cx/1.5f*2)-((cx/7)/2), cy/2+20-80 , cx/7, cx/7, HALF_PI, PI); 
        arc((cx/1.5f*2)+((cx/7)/2), cy/2+20 , cx/6, cx/6, PI+HALF_PI, TWO_PI); 
        arc((cx/1.5f*2)+ ((cx/7)/2), cy/2+20 , cx/7, cx/7, PI+HALF_PI, TWO_PI); 
        //Hands
        arc((cx/1.5f*2)+((cx/7+cx/6)/2)-2,cx/2+28, cx/20, cx/20, PI, TWO_PI );
        arc((cx/1.5f*2)-((cx/7+cx/6)/2)+2,cx/2-80, cx/20, cx/20, 0, PI );

        textSize(20);
        text(getAmplitude(), cx,cy+100);
        text(cx/4f , cx,cy+200);
        //speakers
        //speaker left
        rectMode(CORNER);
        rect(10, cy/5, 120, 365);
        rect(130, cy/2+35, 120, 180);

        rect(30, cy/2, 80, 180);

        //speaker circle left
        arc(68, cy/3, cx/15, cx/15, 0, TWO_PI); 
        arc(68, cy/3, cx/10, cx/10, 0, TWO_PI);   
        arc(68, cy/3, cx/8, cx/8, 0, TWO_PI);  
        //speaker smaller circles left
        //top
        arc(68, cy/2+30+10, cx/20, cx/20, 0, TWO_PI); 
        arc(68, cy/2+30+10, cx/15, cx/15, 0, TWO_PI);   
        arc(68, cy/2+30+10, cx/12, cx/12, 0, TWO_PI);  
        //middle    
        arc(68, cy/2+30+50+10, cx/20, cx/20, 0, TWO_PI); 
        arc(68, cy/2+30+50+10, cx/15, cx/15, 0, TWO_PI);   
        arc(68, cy/2+30+50+10, cx/12, cx/12, 0, TWO_PI);    
        //bottom
        arc(68, cy/2+30+50+50+10, cx/20, cx/20, 0, TWO_PI); 
        arc(68, cy/2+30+50+50+10, cx/15, cx/15, 0, TWO_PI);   
        arc(68, cy/2+30+50+50+10, cx/12, cx/12, 0, TWO_PI); 
        //left small speaker circle   

        arc(190, cy/2+120, cx/15, cx/10, 0, TWO_PI); 
        arc(190, cy/2+120, cx/10, cx/8, 0, TWO_PI);  
        arc(190, cy/2+120, cx/8, cx/4, 0, TWO_PI);      

        

        //speaker circle right
        arc(954, cy/3, cx/15, cx/15, 0, TWO_PI); 
        arc(954, cy/3, cx/10, cx/10, 0, TWO_PI);   
        arc(954, cy/3, cx/8, cx/8, 0, TWO_PI); 
        //speaker smaller circles left
        //top
        arc(954, cy/2+30+10, cx/20, cx/20, 0, TWO_PI); 
        arc(954, cy/2+30+10, cx/15, cx/15, 0, TWO_PI);   
        arc(954, cy/2+30+10, cx/12, cx/12, 0, TWO_PI);  
        //middle    
        arc(954, cy/2+30+50+10, cx/20, cx/20, 0, TWO_PI); 
        arc(954, cy/2+30+50+10, cx/15, cx/15, 0, TWO_PI);   
        arc(954, cy/2+30+50+10, cx/12, cx/12, 0, TWO_PI);    
        //bottom
        arc(954, cy/2+30+50+50+10, cx/20, cx/20, 0, TWO_PI); 
        arc(954, cy/2+30+50+50+10, cx/15, cx/15, 0, TWO_PI);   
        arc(954, cy/2+30+50+50+10, cx/12, cx/12, 0, TWO_PI);  
        //right small speaker circle 
        arc(width-190, cy/2+120, cx/15, cx/10, 0, TWO_PI); 
        arc(width-190, cy/2+120, cx/10, cx/8, 0, TWO_PI);  
        arc(width-190, cy/2+120, cx/8, cx/4, 0, TWO_PI);

        //scanning eye
        //timer every 10 second interval
        if(millis() > last+20400)
        {
            last = millis();
        }
        if(m < 10200)
        {
            for(int i = 0; i<ab.size();i+=20)
            { 
                stroke(255, 255, 255);
                line(cx,cy/3+45,i,secondsToY);
            }
        }
        */
    }

    public void drawDJ(float x, float y, float size)
    {
        float halfS = size / 2;
        float eyebrowsL = 7;

        gon.pushMatrix();
        gon.translate(x, y - halfS);
        //triangle
        gon.stroke(255);
        gon.triangle(0, 0, -halfS, size, halfS, size);
        //eyebrows
        gon.line(0, halfS * 3 / 4, 0, halfS * 3 / 4 - eyebrowsL);
        gon.line(-eyebrowsL * 2 / 3, halfS * 3 / 4, -eyebrowsL, halfS * 3 / 4 - eyebrowsL  * 2 / 3);
        gon.line(eyebrowsL * 2 / 3, halfS * 3 / 4, eyebrowsL, halfS * 3 / 4 - eyebrowsL  * 2 / 3);
        //eyes
        gon.ellipse(0, halfS, halfS - 5, halfS / 2);
        gon.ellipse(0, halfS, halfS / 5, halfS / 3);
        //bowtie
        gon.triangle(0, size - halfS / 2, -halfS / 3, size - halfS * 2 / 3, -halfS / 3, size - halfS * 2 / 5);
        gon.triangle(0, size - halfS / 2, halfS / 3, size - halfS * 2 / 3, halfS / 3, size - halfS * 2 / 5);
        //hat
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
}


/*
//the stage
void stage()
{
colorMode(HSB);
background(0);
noFill();
float halfH = height / 2;
int m = millis();
m = millis()-last;

float secondsToY = map(m/10, 0, ab.size(),0,465);

for(int i = 0 ; i < ab.size() ; i ++)
{
lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
}

float cx = width / 2;
float cy = height / 2;
float stageEdgeLeft = cx/2;
float stageEdgeRight = cx*1.5f;



stroke(255);

//rectangle stage 
rectMode(CENTER);
rect(cx, cy-100,cx+10, cx/4); 
//robots
//robot 1
textMode(CENTER);
textSize(25); 
fill(255);
text("NO",(cx/1.5f), cy/2+5);
noFill();
rect(cx/1.5f, cy/2, cx/7, cx/8);
rect(cx/1.5f, cy/2, cx/9, cx/10);
arc(cx/1.5f, cy/2-32, cx/8, cx/6, PI, TWO_PI); 
arc(cx/1.5f-15, cy/2-50, cx/30, cx/30, 0, TWO_PI);
arc(cx/1.5f+15, cy/2-50, cx/30, cx/30, 0, TWO_PI);
arc(cx/1.5f-15, cy/2-50, cx/50, cx/50, 0, TWO_PI);
arc(cx/1.5f+15, cy/2-50, cx/50, cx/50, 0, TWO_PI);
//LEGS + SHOES  
line(cx/1.5f-20, cy/2+32, cx/1.5f-20 , cy/2+32+40 );
line(cx/1.5f-10, cy/2+32, cx/1.5f-10 , cy/2+32+53 );
line(cx/1.5f+20, cy/2+32, cx/1.5f+20 , cy/2+32+40 );
line(cx/1.5f+10, cy/2+32, cx/1.5f+10 , cy/2+32+53 ); 
arc(cx/1.5f-10, cy/2+32+53 , cx/8, cx/20, PI, PI+HALF_PI); 
arc(cx/1.5f+10, cy/2+32+53 , cx/8, cx/20, PI+HALF_PI, TWO_PI);   

//Arm
arc(cx/1.5f-((cx/7)/2), cy/2+20 , cx/6, cx/6, PI, PI+HALF_PI); 
arc(cx/1.5f-((cx/7)/2), cy/2+20 , cx/7, cx/7, PI, PI+HALF_PI); 
arc(cx/1.5f+((cx/7)/2), cy/2+20-80 , cx/6, cx/6, 0, HALF_PI); 
arc(cx/1.5f+ ((cx/7)/2), cy/2+20-80 , cx/7, cx/7, 0, HALF_PI ); 
//Hands
arc(cx/1.5f-((cx/7+cx/6)/2)+2,cx/2+28, cx/20, cx/20, PI, TWO_PI );
arc(cx/1.5f+((cx/7+cx/6)/2)-2,cx/2-80, cx/20, cx/20, 0, PI ); 


//dancing
//robot_dance1
textMode(CENTER);

fill(255);
textSize(18);
textMode(CENTER);
text("MENU",(cx/4f), (cy/2)*2.5f+5);
noFill();
rect(cx/4f, (cy/2)*2.5f, cx/7, cx/8);
rect(cx/4f, (cy/2)*2.5f, cx/9, cx/10);
arc(cx/4f, (cy/2)*2.5f-32, cx/8, cx/6, PI, TWO_PI); 
arc(cx/4-15, (cy/2)*2.5f-50, cx/30, cx/30, 0, TWO_PI);
arc(cx/4f+15, (cy/2)*2.5f-50, cx/30, cx/30, 0, TWO_PI);
arc(cx/4f-15, (cy/2)*2.5f-50, cx/50, cx/50, 0, TWO_PI);
arc(cx/4f+15, (cy/2)*2.5f-50, cx/50, cx/50, 0, TWO_PI);

//LEGS + SHOES  
line(cx/4f-20, (cy/2)*2.5f+32, cx/4f-20 , (cy/2)*2.5f+32+40 );
line(cx/4f-10, (cy/2)*2.5f+32, (cx/4f-10) , (cy/2)*2.5f+32+53 );
line(cx/4f+20, (cy/2)*2.5f+32, cx/4f+20 , (cy/2)*2.5f+32+40 );
line(cx/4f+10, (cy/2)*2.5f+32, cx/4f+10, (cy/2)*2.5f+32+53 ); 
arc(cx/4f-10, (cy/2)*2.5f+32+53 , cx/8, cx/20, PI, PI+HALF_PI); 
arc(cx/4f+10, (cy/2)*2.5f+32+53 , cx/8, cx/20, PI+HALF_PI, TWO_PI);   

//Arm
if(getAmplitude() < 0.3f)
{
arc(cx/4f-((cx/7)/2), (cx/2)*2.5f+20 , cx/6, cx/6, PI, PI+HALF_PI); 
arc(cx/4f-((cx/7)/2), (cx/2)*2.5f+20 , cx/7, cx/7, PI, PI+HALF_PI); 
arc(cx/4f+((cx/7)/2), (cx/2)*2.5f-80 , cx/6, cx/6, 0, HALF_PI); 
arc(cx/4f+ ((cx/7)/2), (cx/2)*2.5f-80 , cx/7, cx/7, 0, HALF_PI ); 
//Hands
arc(cx/4f-((cx/7+cx/6)/2)+2,(cx/2)*2.5f+32, cx/20, cx/20, PI, TWO_PI );
arc(cx/4f+((cx/7+cx/6)/2)-2,(cx/2)*2.5f-92, cx/20, cx/20, 0, PI );
}
else
{
arc(cx/4f-((cx/7)/2), (cx/2)*2.5f-80 , cx/6, cx/6, HALF_PI, PI); 
arc(cx/4f-((cx/7)/2), (cx/2)*2.5f-80 , cx/7, cx/7, HALF_PI, PI); 
arc(cx/4f+((cx/7)/2), (cx/2)*2.5f+20 , cx/6, cx/6, PI+HALF_PI, TWO_PI);  
arc(cx/4f+((cx/7)/2), (cx/2)*2.5f+20 , cx/7, cx/7, PI+HALF_PI, TWO_PI); 
//Hands
arc(cx/4f+((cx/7+cx/6)/2)-2,(cx/2)*2.5f+32, cx/20, cx/20, PI, TWO_PI );
arc(cx/4f-((cx/7+cx/6)/2)+2,(cx/2)*2.5f-92, cx/20, cx/20, 0, PI );
}

//robot_dance2
textSize(18);
textMode(CENTER);
text("QUIT",(cx/4f)*7, (cy/2)*2.5f+5);
textSize(25); 
fill(255);
text("NO",(cx/1.5f), cy/2+5);
noFill();
rect((cx/4f)*7, (cy/2)*2.5f, cx/7, cx/8);
rect((cx/4f)*7, (cy/2)*2.5f, cx/9, cx/10);
arc((cx/4f)*7, (cy/2)*2.5f-32, cx/8, cx/6, PI, TWO_PI); 
arc((cx/4f)*7-15, (cy/2)*2.5f-50, cx/30, cx/30, 0, TWO_PI);
arc((cx/4f)*7+15, (cy/2)*2.5f-50, cx/30, cx/30, 0, TWO_PI);
arc((cx/4f)*7-15, (cy/2)*2.5f-50, cx/50, cx/50, 0, TWO_PI);
arc((cx/4f)*7+15, (cy/2)*2.5f-50, cx/50, cx/50, 0, TWO_PI);

//LEGS + SHOES  
line((cx/4f)*7-20, (cy/2)*2.5f+32, (cx/4f)*7-20 , (cy/2)*2.5f+32+40 );
line((cx/4f)*7-10, (cy/2)*2.5f+32, ((cx/4f)*7-10) , (cy/2)*2.5f+32+53 );
line((cx/4f)*7+20, (cy/2)*2.5f+32, (cx/4f)*7+20 , (cy/2)*2.5f+32+40 );
line((cx/4f)*7+10, (cy/2)*2.5f+32, (cx/4f)*7+10, (cy/2)*2.5f+32+53 ); 
arc((cx/4f)*7-10, (cy/2)*2.5f+32+53 , cx/8, cx/20, PI, PI+HALF_PI); 
arc((cx/4f)*7+10, (cy/2)*2.5f+32+53 , cx/8, cx/20, PI+HALF_PI, TWO_PI);   

//Arm
if(getAmplitude() < 0.3f)
{
arc((cx/4f)*7-((cx/7)/2), (cx/2)*2.5f-80 , cx/6, cx/6, HALF_PI, PI); 
arc((cx/4f)*7-((cx/7)/2), (cx/2)*2.5f-80 , cx/7, cx/7, HALF_PI, PI); 
arc((cx/4f)*7+((cx/7)/2), (cx/2)*2.5f+20 , cx/6, cx/6, PI+HALF_PI, TWO_PI);  
arc((cx/4f)*7+((cx/7)/2), (cx/2)*2.5f+20 , cx/7, cx/7, PI+HALF_PI, TWO_PI); 
//Hands
arc((cx/4f)*7+((cx/7+cx/6)/2)-2,(cx/2)*2.5f+32, cx/20, cx/20, PI, TWO_PI );
arc((cx/4f)*7-((cx/7+cx/6)/2)+2,(cx/2)*2.5f-92, cx/20, cx/20, 0, PI );
}
else
{
arc((cx/4f)*7-((cx/7)/2), (cx/2)*2.5f+20 , cx/6, cx/6, PI, PI+HALF_PI); 
arc((cx/4f)*7-((cx/7)/2), (cx/2)*2.5f+20 , cx/7, cx/7, PI, PI+HALF_PI); 
arc((cx/4f)*7+((cx/7)/2), (cx/2)*2.5f-80 , cx/6, cx/6, 0, HALF_PI); 
arc((cx/4f)*7+ ((cx/7)/2), (cx/2)*2.5f-80 , cx/7, cx/7, 0, HALF_PI ); 
//Hands
arc((cx/4f)*7-((cx/7+cx/6)/2)+2,(cx/2)*2.5f+32, cx/20, cx/20, PI, TWO_PI );
arc((cx/4f)*7+((cx/7+cx/6)/2)-2,(cx/2)*2.5f-92, cx/20, cx/20, 0, PI );
}


//robot 2
fill(255);
textSize(18);
text("JAZZ",(cx/1.5f*2), cy/2+5);
noFill();
rect((cx/1.5f*2), cy/2, cx/7, cx/8);
rect((cx/1.5f*2), cy/2, cx/9, cx/10);
arc(cx/1.5f*2, cy/2-32, cx/8, cx/6, PI, TWO_PI);
arc(cx/1.5f*2-15, cy/2-50, cx/30, cx/30, 0, TWO_PI);
arc(cx/1.5f*2+15, cy/2-50, cx/30, cx/30, 0, TWO_PI);
arc(cx/1.5f*2-15, cy/2-50, cx/50, cx/50, 0, TWO_PI);
arc(cx/1.5f*2+15, cy/2-50, cx/50, cx/50, 0, TWO_PI);
//LEGS + SHOES   
line((cx/1.5f*2)-20, cy/2+32, (cx/1.5f*2)-20, cy/2+32+40 );
line((cx/1.5f*2)-10, cy/2+32, (cx/1.5f*2)-10, cy/2+32+53 );
line((cx/1.5f*2)+20, cy/2+32, (cx/1.5f*2)+20, cy/2+32+40 );
line((cx/1.5f*2)+10, cy/2+32, (cx/1.5f*2)+10, cy/2+32+53 );
arc((cx/1.5f*2)-10, cy/2+32+53 , cx/8, cx/20, PI, PI+HALF_PI); 
arc((cx/1.5f*2)+10, cy/2+32+53 , cx/8, cx/20, PI+HALF_PI, TWO_PI); 
//ARMS
arc((cx/1.5f*2)-((cx/7)/2), cy/2+20-80 , cx/6, cx/6, HALF_PI, PI); 
arc((cx/1.5f*2)-((cx/7)/2), cy/2+20-80 , cx/7, cx/7, HALF_PI, PI); 
arc((cx/1.5f*2)+((cx/7)/2), cy/2+20 , cx/6, cx/6, PI+HALF_PI, TWO_PI); 
arc((cx/1.5f*2)+ ((cx/7)/2), cy/2+20 , cx/7, cx/7, PI+HALF_PI, TWO_PI); 
//Hands
arc((cx/1.5f*2)+((cx/7+cx/6)/2)-2,cx/2+28, cx/20, cx/20, PI, TWO_PI );
arc((cx/1.5f*2)-((cx/7+cx/6)/2)+2,cx/2-80, cx/20, cx/20, 0, PI );


//triangle eye
triangle(cx,cy/3,cx+50,cy/2,cx-50,cy/2);
line(cx,cy/3+24,cx,cy/3+32);
line(cx-8,cy/3+32 ,cx-10,cy/3+26);
line(cx+8,cy/3+32 ,cx+10,cy/3+26);
arc(cx, cy/3+45, cx/12, cx/20, 0, TWO_PI); 
arc(cx, cy/3+45, cx/60, cx/36, 0, TWO_PI); 
//bowtie
triangle(cx,cy/3+65,cx+15,cy/2-15,cx+15,cy/2-25);
triangle(cx,cy/3+65,cx-15,cy/2-15,cx-15,cy/2-25);
//legs
line(cx-20, cy/2, cx-20, cy/2 +30);
line(cx-20, cy/2+30, cx-12, cy/2 +15);
line(cx-12, cy/2+15, cx-12, cy/2 +35);
//right leg
line(cx+20, cy/2, cx+20, cy/2 +30);
line(cx+20, cy/2+30, cx+12, cy/2 +15);
line(cx+12, cy/2+15, cx+12, cy/2 +35);
//arms
//left
arc(cx-40, cy/3+35, cx/12, cx/8, HALF_PI, PI); 
arc(cx+40, cy/3+35, cx/12, cx/8, 0, HALF_PI); 
//hat
beginShape();
vertex(cx-20, cy/3);
vertex(cx-20, cy/3-5);
vertex(cx-10, cy/3-5);
vertex(cx-10, cy/3-40);
vertex(cx+10, cy/3-40);
vertex(cx+10, cy/3-5);
vertex(cx+20, cy/3-5);
vertex(cx+20, cy/3);
vertex(cx-20, cy/3);
endShape();


textSize(20);
text(getAmplitude(), cx,cy+100);
text(cx/4f , cx,cy+200);
//speakers
//speaker left
rectMode(CORNER);
rect(10, cy/5, 120, 365);
rect(130, cy/2+35, 120, 180);

rect(30, cy/2, 80, 180);

//speaker circle left
arc(68, cy/3, cx/15, cx/15, 0, TWO_PI); 
arc(68, cy/3, cx/10, cx/10, 0, TWO_PI);   
arc(68, cy/3, cx/8, cx/8, 0, TWO_PI);  
//speaker smaller circles left
//top
arc(68, cy/2+30+10, cx/20, cx/20, 0, TWO_PI); 
arc(68, cy/2+30+10, cx/15, cx/15, 0, TWO_PI);   
arc(68, cy/2+30+10, cx/12, cx/12, 0, TWO_PI);  
//middle    
arc(68, cy/2+30+50+10, cx/20, cx/20, 0, TWO_PI); 
arc(68, cy/2+30+50+10, cx/15, cx/15, 0, TWO_PI);   
arc(68, cy/2+30+50+10, cx/12, cx/12, 0, TWO_PI);    
//bottom
arc(68, cy/2+30+50+50+10, cx/20, cx/20, 0, TWO_PI); 
arc(68, cy/2+30+50+50+10, cx/15, cx/15, 0, TWO_PI);   
arc(68, cy/2+30+50+50+10, cx/12, cx/12, 0, TWO_PI); 
//left small speaker circle   

arc(190, cy/2+120, cx/15, cx/10, 0, TWO_PI); 
arc(190, cy/2+120, cx/10, cx/8, 0, TWO_PI);  
arc(190, cy/2+120, cx/8, cx/4, 0, TWO_PI);      

//speaker right
rect(width-130, cy/5, 120, 365);
rect(width-250, cy/2+35, 120, 180); 
rect(width-110, cy/2, 80, 180);

//speaker circle right
arc(954, cy/3, cx/15, cx/15, 0, TWO_PI); 
arc(954, cy/3, cx/10, cx/10, 0, TWO_PI);   
arc(954, cy/3, cx/8, cx/8, 0, TWO_PI); 
//speaker smaller circles left
//top
arc(954, cy/2+30+10, cx/20, cx/20, 0, TWO_PI); 
arc(954, cy/2+30+10, cx/15, cx/15, 0, TWO_PI);   
arc(954, cy/2+30+10, cx/12, cx/12, 0, TWO_PI);  
//middle    
arc(954, cy/2+30+50+10, cx/20, cx/20, 0, TWO_PI); 
arc(954, cy/2+30+50+10, cx/15, cx/15, 0, TWO_PI);   
arc(954, cy/2+30+50+10, cx/12, cx/12, 0, TWO_PI);    
//bottom
arc(954, cy/2+30+50+50+10, cx/20, cx/20, 0, TWO_PI); 
arc(954, cy/2+30+50+50+10, cx/15, cx/15, 0, TWO_PI);   
arc(954, cy/2+30+50+50+10, cx/12, cx/12, 0, TWO_PI);  
//right small speaker circle 
arc(width-190, cy/2+120, cx/15, cx/10, 0, TWO_PI); 
arc(width-190, cy/2+120, cx/10, cx/8, 0, TWO_PI);  
arc(width-190, cy/2+120, cx/8, cx/4, 0, TWO_PI);

//speaker effects
//left 
for(int i = 0 ; i < ab.size() ; i +=20)
{
noFill();
float c = map(i, 0, ab.size(), 0, 255);
stroke(c, 255, 255);
float f = lerpedBuffer[i] * halfH * 3.0f;
arc(68, cy/3, f*2, f*2, 0, TWO_PI);     

}
//right 
for(int i = 0 ; i < ab.size() ; i +=20)
{
noFill();
float c = map(i, 0, ab.size(), 0, 255);
stroke(c, 255, 255);
float f = lerpedBuffer[i] * halfH * 3.0f;
arc(954, cy/3, f*2, f*2, 0, TWO_PI);     

}

//small speaker effect left
for(int i = 0 ; i < ab.size() ; i += 30)
{
noFill();
float c = map(i, 0, ab.size(), 0, 255);
stroke(c, 255, 255);
float f = lerpedBuffer[i] * halfH * 3.0f;
arc(190, cy/2+120, f*2, f*2, 0, TWO_PI);     

} 
//small speaker effect right
for(int i = 0 ; i < ab.size() ; i += 30)
{
noFill();
float c = map(i, 0, ab.size(), 0, 255);
stroke(c, 255, 255);
float f = lerpedBuffer[i] * halfH * 3.0f;
arc(width-190, cy/2+120, f*2, f*2, 0, TWO_PI);     
} 


//waves
for(int i = (int)stageEdgeLeft ; i < stageEdgeRight ; i +=8)
{
{
// float c = map(ab.get(i), -1, 1, 0, 255);
float c = PApplet.map(i - 25, 0, ab.size(), 0, 255);
stroke(c, 255, 255);
float f = lerpedBuffer[i] * halfH/3.0f;
line(i, halfH-100 + f, i, halfH-100 - f);
    
}

}


//lasers
for(int i = 0; i<ab.size();i+=120)
{ 
float c = map(i, 0, ab.size(), 0, 255);
stroke(c, 255, 255);
float f = lerpedBuffer[i] * halfH * 4.0f;
line((cx/1.5f+((cx/7+cx/6)/2)-2),cx/2-80, random(0, cx), random(0 ,f-200));
line(((cx/1.5f*2)-((cx/7+cx/6)/2)+2),cx/2-80, random(cx, width), random(0 ,f-200));
}

//scanning eye
//timer every 10 second interval
if(millis() > last+20400)
{
last = millis();
}
if(m < 10200)
{
for(int i = 0; i<ab.size();i+=20)
{ 
    stroke(255, 255, 255);
    line(cx,cy/3+45,i,secondsToY);
}
}
else
{   
}


}      
*/