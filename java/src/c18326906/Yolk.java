package c18326906;

import ie.tudublin.Visual;
import java.util.Random; 

public class Yolk extends Visual
{   
    int limit = 1000;
    
    Raindrop[] rain = new Raindrop[limit];

    public void settings()
    {
        size(1000, 1000);
        //fullScreen();
    }

    public void keyPressed()
    {
        //if (key == ' ')
        //{
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        //}
    }

    public void setup()
    {
        noCursor();
        setFrameSize(256);
        startMinim();
        //loadAudio("BassnectarBassHead.mp3");
        loadAudio("KidCudiCreepers.mp3");

        background(0);
        colorMode(HSB);

        for(int i = 0; i < rain.length; i++)
        {
            rain[i] = new Raindrop(this);
        }
    }

    public void draw()
    {
        calculateAverageAmplitude();

        int rainAmount = ceil(map(getSmoothedAmplitude() * 100, 0, 30, 0, limit));

        for(int i = 0; i < rainAmount; i++)
        {
            rain[i].display();
            rain[i].update();
        }
    }

    public int RandomNumber()
    {
        Random rand = new Random();
        return rand.nextInt(width);
    }
}