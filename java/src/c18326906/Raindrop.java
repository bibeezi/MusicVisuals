package c18326906;

import processing.core.*;

public class Raindrop
{
    Yolk egg;

    float x;
    float y1;
    float y2;
    int rainlength = 60;

    public Raindrop(Yolk egg)
    {
        this.egg = egg; 

        x = egg.RandomNumber();
        y1 = egg.RandomNumber();
        y2 = y1 + rainlength;
    }

    public void update()
    {
        y1++;
        y2++;

        if(y2 > egg.height)
        {
            y1 = 0;
            y2 = y1 + rainlength;
        }
    }

    public void display()
    {
        float colour = PApplet.map(egg.RandomNumber(), 0, 1000, 0, 255);

        egg.stroke(colour, 255, 255);
        egg.line(x, y1, x, y2);

        egg.noStroke();
        egg.fill(0, 0, 0);
        egg.ellipse(egg.width / 2, egg.height, 300, 500);
    }
}