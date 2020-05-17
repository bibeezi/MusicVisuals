package c18326906;

import processing.core.*;

public class Circles
{
    Yolk egg;

    float x, y;
    float x1, y1;
    float r, theta;
    float count;
    float size;

    public Circles(Yolk egg)
    {
        this.egg = egg;

        size = 50;
    }

    public void display()
    {
        egg.translate(egg.width / 2, egg.height / 2);

        x = r * PApplet.cos(theta);
        y = r * PApplet.sin(theta);
        x1 = r * -PApplet.cos(theta);
        y1 = r * -PApplet.sin(theta);

        egg.fill(egg.getSmoothedAmplitude() * 1000 % 255, 255, 255);
        egg.noStroke();

        egg.ellipse(x, y, size, size);
        egg.ellipse(x1, y1, size, size);
        for(int i = 0; i < 5; i++)
        {
            egg.ellipse(x * (i * 0.8f), y * (i * 0.8f), size - (i * 10), size - (i * 10));
            egg.ellipse(x1 * (i * 0.8f), y1 * (i * 0.8f), size - (i * 10), size - (i * 10));
        }
       
        r += egg.getSmoothedAmplitude();
        theta += egg.getSmoothedAmplitude() / 2;

        if(x > egg.width / 3)
        {
            x = 0;
            y = 0;

            r = 0;
            theta = 0;
        }
    }
}