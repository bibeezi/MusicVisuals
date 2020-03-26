package ie.tudublin;

import example.CubeVisual;
import example.MyVisual;
import c18326906.*;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CubeVisual());		
	}

	public void screen()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new Yolk());
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.screen();			
	}
}