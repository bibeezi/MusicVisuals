package c18326906;

import ie.tudublin.Visual;
import java.util.Random; 

public class Yolk extends Visual
{
    int boundary = 1000;

    Raindrop[] rain = new Raindrop[boundary];

    public void settings()
    {
        size(1000, 1000);
        //fullScreen();
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void setup()
    {
        noCursor();
        setFrameSize(256);
        startMinim();
        //loadAudio("BassnectarBassHead.mp3");
        loadAudio("KidCudiCreepers.mp3");

        for(int i = 0; i < rain.length; i++)
        {
            rain[i] = new Raindrop();
        }
    }

    public float RandomNumber()
    {
        Random rand = new Random();
        return rand.nextInt(width);
    }

    public void display(float x, float y1, float y2)
    {
        colorMode(HSB);
        float colour = map(RandomNumber(), 1, 1000, 0, 255);
        stroke(colour, 255, 255);
        line(x, y1, x, y2);
        
        for(int i = 0; i < rain.length; i++)
        {
            rain[i].update();
        }

        //noStroke();
        fill(0, 0, 0);
        ellipse(width / 2, height, 300, 500);
    }

    public void draw()
    {
        background(0);

        calculateAverageAmplitude();

        int rainAmount = ceil(map(getSmoothedAmplitude() * 1000, 0, 250, 0, 250));

        for(int i = 0; i < rainAmount; i++)
        {
            display(rain[i].x, rain[i].y1, rain[i].y2);
        }
    }
}