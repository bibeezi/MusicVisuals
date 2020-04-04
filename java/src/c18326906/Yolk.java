package c18326906;

import ie.tudublin.Visual;
import java.util.Random; 

public class Yolk extends Visual
{
    public void settings()
    {
        size(800, 800);
        //fullScreen();
    }

    boolean spiral = false;

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
        // if (key == '1')
        // {
        //     spiral = ! spiral;
        // }
    }

    Raindrop[] rain = new Raindrop[100];

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

    public int RandomNumber()
    {
        Random rand = new Random();
        return rand.nextInt(width);
    }

    public void draw()
    {
        background(0);
        colorMode(HSB);

        calculateAverageAmplitude();

        for(int i = 0; i < rain.length - 1; i++)
        {
            rain[i].update();
            rain[i].display();
        }
	}
}