package c18326906;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class Yolk extends Visual
{
    private int limit = 500;
    private Raindrop[] r = new Raindrop[limit];

    private Sideways s = new Sideways(this);
    public float[] bands;

    private Circles c = new Circles(this);

    private Boolean rain, square, circle;
    
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
        if(key == '1')
        {
            rain = !rain;
        }
        if(key == '2')
        {
            square = !square;
        }
        if(key == '3')
        {
            circle = !circle;
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
            r[i] = new Raindrop(this);
        }

        rain = square = circle = true;
        
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
        

        if(rain == true)
        {
            int rainAmount = ceil(map(getSmoothedAmplitude() * 100, 0, 100, 0, limit));

            for(int i = 1; i < rainAmount; i++)
            {
                r[i].display();
                r[i].update();
            }
        }
        

        if(square == true)
        {
            bands = getSmoothedBands();
            s.display();
        }
        

        if(circle == true)
        {
            c.display();
        }
        
    }
}