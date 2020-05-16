package c18326906;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class Yolk extends Visual
{
    int limit = 500;
    Raindrop[] rain = new Raindrop[limit];

    Sideways s = new Sideways(this);
    float[] bands;

    float max = 0;
    
    public void settings()
    {
        fullScreen(P3D);
    }

    public void setup()
    {
        noCursor();
        setFrameSize(256);
        startMinim();
        colorMode(HSB);

        loadAudio("Dancin.mp3");
        //loadAudio("KidCudiCreepers.mp3");
        getAudioPlayer().play();

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
        

        // int rainAmount = ceil(map(getSmoothedAmplitude() * 100, 0, 100, 0, limit));
        // for(int i = 1; i < rainAmount; i++)
        // {
        //     rain[i].display();
        //     rain[i].update();
        // }


        // bands = getSmoothedBands();
        // s.display();

        x = r * cos(theta);
        y = r * sin(theta);
        x1 = r * -cos(theta);
        y1 = r * -sin(theta);

        translate(width / 2, height / 2);

        stroke(255, 255, 255);

        ellipse(x, y, 10, 10);
        ellipse(x1, y1, 10, 10);

        r += 0.1;
        theta += 0.02;
    }

    float x, y, r, theta, x1, y1;
}