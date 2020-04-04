package c18326906;

class Raindrop extends Yolk
{
    float x;
    float y1;
    float y2;

    Raindrop()
    {
        x = RandomNumber();
        y1 = RandomNumber();
        y2 = y1 + 40;
    }

    void update()
    {
        y1 += 0.1;
        y2 += 0.1;

        if(y2 > boundary)
        {
            y1 = 0;
            y2 = y1 + 40;
        }
    }
}