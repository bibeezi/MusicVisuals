package c18326906;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class Yolk extends Visual
{
    int limit = 1000;
    Raindrop[] rain = new Raindrop[limit];

    Sideways s = new Sideways(this);
    float[] bands;

    float max = 0;
    
    public void settings()
    {
        size(1000, 1000, P3D);
        //fullScreen();
    }

    public void keyPressed()
    {
        //if (key == ' ')
        //{
            // getAudioPlayer().cue(0);
            getAudioPlayer().play();
        //}
    }

    public void setup()
    {
        noCursor();
        setFrameSize(256);
        startMinim();
        colorMode(HSB);

        loadAudio("Dancin.mp3");
        //loadAudio("KidCudiCreepers.mp3");

        for(int i = 0; i < limit; i++)
        {
            rain[i] = new Raindrop(this);
        }
        
    }

    public void draw()
    {   
        background(0);
        
        calculateAverageAmplitude();
        try
        {
            calculateFFT();
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        calculateFrequencyBands();

        while(max < getSmoothedAmplitude() * 100)
        {
            max = getSmoothedAmplitude() * 100;
            println(max);
        }
        
        int rainAmount = ceil(map(getSmoothedAmplitude() * 100, 0, 50, 0, limit));

        for(int i = 1; i < rainAmount; i++)
        {
            rain[i].display();
            rain[i].update();
        }

        bands = getSmoothedBands();
        s.display();
    }
}