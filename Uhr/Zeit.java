
/**
 * Write a description of class Zeit here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Zeit
{
    private int stunden;
    private int minuten;
    private int sekunden;


    public Zeit(int stunde, int minute, int sekunde)
    {
        stunden = stunde;
        minuten = minute;
        sekunde = sekunde;

    }
    
    public void erhoehen(boolean richtung)
    {
        int schritt;
        if (richtung == true)
        {
            schritt = 1;
        }
        else 
        {
            schritt = -1;
        }
        if(richtung == true)
        {
            if(sekunden < 59)
            {
                sekunden+=schritt;
            }
            else
            {
                sekunden = 0;
                if(minuten < 59)
                {
                    minuten+=schritt;
                }
                else
                {
                    minuten = 0;
                    if(stunden < 23)
                    {
                        stunden+=schritt;
                    }
                    else
                    {
                        stunden=0;
                    }
                }
            }
        }
        if(richtung == false)
        {
            if(sekunden >0)
            {
                sekunden+=schritt;
            }
            else
            {
                sekunden = 59;
                if(minuten >0)
                {
                    minuten+=schritt;
                }
                else
                {
                    minuten = 59;
                    if(stunden >0)
                    {
                        stunden+=schritt;
                    }
                    else
                    {
                        stunden=23;
                    }
                }
            }
        }
    }
    
    public int gibStunden()
    {
        return stunden;
    }
    
    public int gibMinuten()
    {
        return minuten;
    }
    
    public int gibSekunden()
    {
        return sekunden;
    }
    
    public void setZeit(int stunde, int minute, int sekunde)
    {
       stunden = stunde;
       minuten = minute;
       sekunde = sekunde;
    }

}
