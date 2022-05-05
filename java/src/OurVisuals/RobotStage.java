package OurVisuals;

import processing.core.PApplet;

public class RobotStage {
    GameOfNode gon;
    String name;

    public RobotStage(GameOfNode gon) {
        this.gon = gon;
    }

    public void renderRobot(float x, float y, String name, boolean left, boolean isSync)
    {
        this.name = name;
        
        gon.stroke(255);
        gon.strokeWeight(1);
        float halfW = (gon.width/2);
        float size = halfW/8;
        //height/9
        if (left == true && isSync == false)
        {
            //
            gon.arc(x-((halfW/7)/2), y+20 , halfW/6, halfW/6, PApplet.PI, PApplet.PI+ PApplet.HALF_PI); 
            gon.arc(x-((halfW/7)/2), y+20 , halfW/7, halfW/7, PApplet.PI, PApplet.PI+PApplet.HALF_PI); 
            gon.arc(x+((halfW/7)/2), y+20-80 , halfW/6, halfW/6, 0, PApplet.HALF_PI); 
            gon.arc(x+ ((halfW/7)/2), y+20-80 , halfW/7, halfW/7, 0, PApplet.HALF_PI ); 
            //Hands
            gon.arc(x-((halfW/7+halfW/6)/2)+2,y+halfW/6+20-70, halfW/20, halfW/20, PApplet.PI, PApplet.TWO_PI );
            gon.arc(x+((halfW/7+halfW/6)/2)-2,y-halfW/6+10, halfW/20, halfW/20, 0, PApplet.PI ); 
        }

        else if (left == false && isSync == false)
        {
            //ARMS
                gon.arc((x/1.5f*1.5f)-((halfW/7)/2), y-20-40 , halfW/6, halfW/6, PApplet.HALF_PI, PApplet.PI); 
                gon.arc((x/1.5f*1.5f)-((halfW/7)/2), y-20-40 , halfW/7, halfW/7, PApplet.HALF_PI, PApplet.PI); 
                gon.arc((x/1.5f*1.5f)+((halfW/7)/2), y+20, halfW/6, halfW/6, PApplet.PI+PApplet.HALF_PI, PApplet.TWO_PI); 
                gon.arc((x/1.5f*1.5f)+ ((halfW/7)/2), y+20, halfW/7, halfW/7, PApplet.PI+PApplet.HALF_PI, PApplet.TWO_PI); 
                //Hands
                gon.arc((x/1.5f*1.5f)+((halfW/7+halfW/6)/2)-2,y+30, halfW/20, halfW/20, PApplet.PI, PApplet.TWO_PI );
                gon.arc((x/1.5f*1.5f)-((halfW/7+halfW/6)/2)+2,y-40-30, halfW/20, halfW/20, 0, PApplet.PI );
        }

        else if (left == true && isSync == true)
        {
            //Arm
            if(gon.kick.hitEffect || gon.snare.hitEffect || gon.hat.hitEffect)
            {
                gon.arc(x-((halfW/7)/2), y+20 , halfW/6, halfW/6, PApplet.PI, PApplet.PI+ PApplet.HALF_PI); 
                gon.arc(x-((halfW/7)/2), y+20 , halfW/7, halfW/7, PApplet.PI, PApplet.PI+PApplet.HALF_PI); 
                gon.arc(x+((halfW/7)/2), y+20-80 , halfW/6, halfW/6, 0, PApplet.HALF_PI); 
                gon.arc(x+ ((halfW/7)/2), y+20-80 , halfW/7, halfW/7, 0, PApplet.HALF_PI ); 
                //Hands
                gon.arc(x-((halfW/7+halfW/6)/2)+2,y+halfW/6+20-70, halfW/20, halfW/20, PApplet.PI, PApplet.TWO_PI );
                gon.arc(x+((halfW/7+halfW/6)/2)-2,y-halfW/6+10, halfW/20, halfW/20, 0, PApplet.PI ); 
            }
            else
            {
                gon.arc((x/1.5f*1.5f)-((halfW/7)/2), y-20-40 , halfW/6, halfW/6, PApplet.HALF_PI, PApplet.PI); 
                gon.arc((x/1.5f*1.5f)-((halfW/7)/2), y-20-40 , halfW/7, halfW/7, PApplet.HALF_PI, PApplet.PI); 
                gon.arc((x/1.5f*1.5f)+((halfW/7)/2), y+20, halfW/6, halfW/6, PApplet.PI+PApplet.HALF_PI, PApplet.TWO_PI); 
                gon.arc((x/1.5f*1.5f)+ ((halfW/7)/2), y+20, halfW/7, halfW/7, PApplet.PI+PApplet.HALF_PI, PApplet.TWO_PI); 
                //Hands
                gon.arc((x/1.5f*1.5f)+((halfW/7+halfW/6)/2)-2,y+30, halfW/20, halfW/20, PApplet.PI, PApplet.TWO_PI );
                gon.arc((x/1.5f*1.5f)-((halfW/7+halfW/6)/2)+2,y-40-30, halfW/20, halfW/20, 0, PApplet.PI );
            }   
        }
        //float size = halfW/8;
        //height/9

        else if (left == false && isSync == true)
        {
            if(gon.kick.hitEffect || gon.snare.hitEffect || gon.hat.hitEffect)
            {
                gon.arc((x/1.5f*1.5f)-((halfW/7)/2), y-20-40 , halfW/6, halfW/6, PApplet.HALF_PI, PApplet.PI); 
                gon.arc((x/1.5f*1.5f)-((halfW/7)/2), y-20-40 , halfW/7, halfW/7, PApplet.HALF_PI, PApplet.PI); 
                gon.arc((x/1.5f*1.5f)+((halfW/7)/2), y+20, halfW/6, halfW/6, PApplet.PI+PApplet.HALF_PI, PApplet.TWO_PI); 
                gon.arc((x/1.5f*1.5f)+ ((halfW/7)/2), y+20, halfW/7, halfW/7, PApplet.PI+PApplet.HALF_PI, PApplet.TWO_PI); 
                //Hands
                gon.arc((x/1.5f*1.5f)+((halfW/7+halfW/6)/2)-2,y+30, halfW/20, halfW/20, PApplet.PI, PApplet.TWO_PI );
                gon.arc((x/1.5f*1.5f)-((halfW/7+halfW/6)/2)+2,y-40-30, halfW/20, halfW/20, 0, PApplet.PI );
            }
            else
            {
                gon.arc(x-((halfW/7)/2), y+20 , halfW/6, halfW/6, PApplet.PI, PApplet.PI+ PApplet.HALF_PI); 
                gon.arc(x-((halfW/7)/2), y+20 , halfW/7, halfW/7, PApplet.PI, PApplet.PI+PApplet.HALF_PI); 
                gon.arc(x+((halfW/7)/2), y+20-80 , halfW/6, halfW/6, 0, PApplet.HALF_PI); 
                gon.arc(x+ ((halfW/7)/2), y+20-80 , halfW/7, halfW/7, 0, PApplet.HALF_PI ); 
                //Hands
                gon.arc(x-((halfW/7+halfW/6)/2)+2,y+halfW/6+20-70, halfW/20, halfW/20, PApplet.PI, PApplet.TWO_PI );
                gon.arc(x+((halfW/7+halfW/6)/2)-2,y-halfW/6+10, halfW/20, halfW/20, 0, PApplet.PI ); 
            }   
        }
        
        
        gon.textAlign(PApplet.CENTER);
        gon.textSize(20); 
        gon.fill(255);
        gon.text(name,(x), y);
        gon.noFill();
        gon.stroke(255);
        gon.rectMode(PApplet.CENTER);
        gon.rect(x, y, size, halfW/8);
        gon.rect(x, y, halfW/9, halfW/10);
        gon.arc(x, y-32, halfW/9, halfW/6, PApplet.PI, PApplet.TWO_PI); 
        gon.arc(x-15, y-50, halfW/30, halfW/30, 0, PApplet.TWO_PI);
        gon.arc(x+15, y-50, halfW/30, halfW/30, 0, PApplet.TWO_PI);
        gon.arc(x-15, y-50, halfW/50, halfW/50, 0, PApplet.TWO_PI);
        gon.arc(x+15, y-50, halfW/50, halfW/50, 0, PApplet.TWO_PI);
        //LEGS + SHOES  
        gon.line(x-20, y+32, x-20 , y+32+40 );
        gon.line(x-10, y+32, x-10 , y+32+53 );
        gon.line(x+20, y+32, x+20 , y+32+40 );
        gon.line(x+10, y+32, x+10 , y+32+53 ); 
        gon.arc(x-10, y+32+53 , halfW/8, halfW/20, PApplet.PI, PApplet.PI+ PApplet.HALF_PI); 
        gon.arc(x+10, y+32+53 , halfW/8, halfW/20, PApplet.PI+PApplet.HALF_PI, PApplet.TWO_PI);   
            
        
    }
}