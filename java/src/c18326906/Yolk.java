package c18326906;

import ie.tudublin.Visual;

public class Yolk extends Visual
{
    public void settings()
    {
        size(1024, 500);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();

        loadAudio("");
    }

    public void draw()
    {
        background(0);
        rect(100, 100, 10, 10);
    }
}