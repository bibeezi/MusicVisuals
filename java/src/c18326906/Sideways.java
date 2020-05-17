package c18326906;

import processing.core.*;

public class Sideways
{
    Yolk egg;

    float cubeX, cubeY;
    float angle;
    float size;

    Boolean switchX = true;
    Boolean switchY = true;
    
    int count, speed;
    float colour;

    public Sideways(Yolk egg)
    {
        this.egg = egg;

        size = 300;
        cubeX = 0;
        cubeY = 0;
        count = 0;
        speed = 5;
    }

    public void display()
    {
        for(float i = 0.2f; i < 1; i += 0.3f)
        {
            egg.stroke(0);
            egg.strokeWeight(5);
            if(count < 7 && egg.frameCount % 10 == 0)
            {
                colour = PApplet.map(egg.bands[count], 0, egg.bands.length, 0, 255);
            }
            egg.fill(colour % 255, 255, 255);

            egg.pushMatrix();
            egg.translate(cubeX, egg.height * i, 0);
            egg.rotateY(angle);
            egg.rotateX(angle);
            egg.box(10 + egg.getSmoothedAmplitude() * size);
            egg.popMatrix();
            
            egg.pushMatrix();
            egg.translate(egg.width * i, cubeY, 0);
            egg.rotateY(-angle);
            egg.rotateX(-angle);
            egg.box(10 + egg.getSmoothedAmplitude() * size);
            egg.popMatrix();

            count = (count > 7) ? 0 : count++;
        }

        angle += 0.01f;

        if(cubeX == egg.width || cubeX < 0)
        {
            switchX = !switchX;
        }
        
        if(cubeY == egg.height || cubeY < 0)
        {
            switchY = !switchY;
        }

        cubeX = (switchX == true) ? cubeX + speed : cubeX - speed;
        cubeY = (switchY == true) ? cubeY + speed : cubeY - speed;
    }
}