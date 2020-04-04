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
        y1++;
        y2++;

        if(y2 > height)
        {
            y1 = RandomNumber();
            y2 = y1 + 40;
        }
    }
}