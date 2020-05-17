# Music Visualiser Project

*Name:* Bianca Palileo
*Student Number:* C18326906

# Description of the assignment
For this assignment, I had to create "Something beautiful to listen to music".
The assignment is created by using *Java* code and its *processing* library.

I created 4 Effects:
- Strobelight
- Rainfall
- Rotating 3 x 3 Cubes
- Spiralling Circles

All visual effects react to music in their own way whether it is the frequency or the amplitude of the sound.

# Instructions
When compiled, the music and visual effects start.

You can turn the effects on and off by pressing:
1. b - strobelights
2. 1 - rainfall
3. 2 - cubes
4. 3 - circles

Pressing space restarts the song.

## Youtube Video
[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

# How it works
Yolk is the subclass of the Visual class. It calls methods from the other three classes; Raindrop, Sideways and Circles.

Yolk will create an object for each of the three classes.
```Java
	private Sideways s = new Sideways(this);
```

Then the three classes with visual effects have the Yolk class passed into them and referenced as 'egg'. Doing this, the other classes that are not subclasses of Visual can still use the processing library by referencing 'egg'.
For example:
```Java
	public Sideways(Yolk egg)
		{
			this.egg = egg;
		}

	public void display()
		{
			egg.stroke(0);
		}
```

Yolk will then call the method for these classes to display the visual effect.
```Java
	s.display();
```

## Strobelights - Yolk.java
The strobelights work by changing the background colour to something lighter when the amplitude of the sound was loud.
```Java
	background(getSmoothedAmplitude() * 100);
```

This creates an effect where lights appear to the beat of the song.

## Rainfall - 
For rainfall, I created a random number generator that chooses a number between 0 and the width. 
```Java
    public int RandomNumber()
    {
        Random rand = new Random();
        return rand.nextInt(egg.width);
	}
```
This is so that each raindrop is randomly placed on the x axis (width of the screen). As well as this, the raindrop is placed on a random place on the y axis since rainfall isn't uniform. The rain has a specific length of 60 pixels and never changes.
```Java
	x = RandomNumber();
	y1 = RandomNumber();
	y2 = y1 + rainlength;
```

The rain moves down the screen until it disappears and reappears from the top.
```Java
	y1 += 9;
	y2 += 9;

	if(y1 > egg.height)
	{
		y1 = 0;
		y2 = y1 + rainlength;
	}
```

The colour of the rain is random.
```Java
	colour = PApplet.map(RandomNumber(), 0, egg.width, 0, 255);
```

The amount of rain that shows up depends on the amplitude of the sound.
```Java
	rainAmount = ceil(map(getSmoothedAmplitude() * 100, 0, 100, 0, limit));
```

## Cubes
The sizes of the cubes are 10 pixels at the start so they are visible and added to the size of 300 by the amplitude of the sound so that the cubes change size depending on the amplitude of the music. The cubes rotate horizontally and vertically at the same time at a certain angle.
```Java
	egg.rotateY(angle);
	egg.rotateX(angle);
	egg.box(10 + egg.getSmoothedAmplitude() * size);
```

The colour of the cubes change depending of the frequency of the sound every 10 frames.
```Java
	if(count < 7 && egg.frameCount % 10 == 0)
    {
        colour = PApplet.map(egg.bands[count], 0, egg.bands.length, 0, 255);
    }
```

When the cubes hit the edge of the screen, they will change the opposite direction.
```Java
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
```

## Circles
The sizes of the circles are 50 pixels and as they multiply, they get smaller by 10 pixels.
```Java
	egg.ellipse(x, y, size, size);
	egg.ellipse(x1, y1, size, size);
	for(int i = 0; i < 5; i++)
	{
		egg.ellipse(x * (i * 0.8f), y * (i * 0.8f), size - (i * 10), size - (i * 10));
		egg.ellipse(x1 * (i * 0.8f), y1 * (i * 0.8f), size - (i * 10), size - (i * 10));
	}
```

The circles move using sin and cos of an angle with their x and y co-ordinates respectively. The radius of the spiral and angle increases every iteration by the amplitude of the sound.
```Java
	x = r * PApplet.cos(theta);
	y = r * PApplet.sin(theta);
	x1 = r * -PApplet.cos(theta);
	y1 = r * -PApplet.sin(theta);

	...

	r += egg.getSmoothedAmplitude();
	theta += egg.getSmoothedAmplitude() / 2;
```

Once the original circle's x co-ordinate passes the size/width of the screen, the circles reappear in their starting position again.
```Java
	if(x > egg.width / 3)
	{
		x = 0;
		y = 0;

		r = 0;
		theta = 0;
	}
```

## Turning on and off visual effects
All effects can be turned on an off with a boolean. When the boolean is true, the effect is on, otherwise it is off.
```Java
	private Boolean rain, square, circle, background;

	...

	circle = false;
	
	...

	if(circle == true)
	{
		c.display();
	}
```

# What I am most proud of in the assignment
I am most proud of the rainfall as it was the first idea that I had got working.
I also liked creating the circles going in the direction of a spiral as it used some Mathematical functions.
The best part of working on this assignment was getting the objects to respond to music.

# Songs Used
[hyperlink]https://soundcloud.com/kronopage/aaron-smith-dancin-remix-by
[hyperlink]https://www.youtube.com/watch?v=iLBBRuVDOo4