package c18326906;

class Raindrop extends Yolk
{
    float x;
    float y1;
    float y2;

    public Raindrop()
    {
        x = RandomNumber();
        y1 = RandomNumber();
        y2 = y1 + 40;
    }

    void update()
    {
        y1++;
        y2++;

        if(y2 > height)
        {
            y1 = 0;
            y2 = y1 + 40;
        }
    }

    void display()
    {
        stroke(x % 255, 255, 255);
        line(x, y1, x, y2);
    }
}