package c18326906;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class Yolk extends Visual
{
    private int limit = 500;
    private Raindrop[] rain = new Raindrop[limit];

    private Sideways s = new Sideways(this);
    public float[] bands;

    private Circles c = new Circles(this);
    
    private Wave w = new Wave(this);
    
    public void settings()
    {
        fullScreen(P3D);
    }

    public void keyPressed()
    {
        if(key == ' ')
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
        colorMode(HSB);

        for(int i = 0; i < limit; i++)
        {
            rain[i] = new Raindrop(this);
        }
        
        background(0);
        loadAudio("Dancin.mp3");
        getAudioPlayer().play();
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
        

        int rainAmount = ceil(map(getSmoothedAmplitude() * 100, 0, 100, 0, limit));
        for(int i = 1; i < rainAmount; i++)
        {
            rain[i].display();
            rain[i].update();
        }


        bands = getSmoothedBands();
        s.display();

        
        c.display();
    }
}