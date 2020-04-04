package c18326906;

class Raindrop extends Yolk
{
    float x;
    float y1;
    float y2;
    int rainlength = 60;

    Raindrop()
    {
        x = RandomNumber();
        y1 = RandomNumber();
        y2 = y1 + rainlength;
    }

    void update()
    {
        y1++;
        y2++;

        if(y2 > boundary)
        {
            y1 = 0;
            y2 = y1 + rainlength;
        }
    }
}