package c18326906;

import processing.core.*;
import java.util.Random; 

public class Raindrop
{
    Yolk egg;

    float x;
    float y1;
    float y2;
    int rainlength = 80;

    public Raindrop(Yolk egg)
    {
        this.egg = egg; 

        x = RandomNumber();
        y1 = RandomNumber();
        y2 = y1 + rainlength;
    }

    public void update()
    {
        y1++;
        y2++;

        if(y1 > egg.height)
        {
            y1 = 0;
            y2 = y1 + rainlength;
        }
    }

    public void display()
    {
        float colour = PApplet.map(RandomNumber(), 0, 1000, 0, 255);

        egg.stroke(colour, 150, 255);
        egg.strokeWeight(2);
        egg.line(x, y1, x, y2);
    }

    public int RandomNumber()
    {
        Random rand = new Random();
        return rand.nextInt(egg.width);
    }
}