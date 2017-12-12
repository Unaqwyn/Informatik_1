import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Write a description of class zufallsZahlenTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class zufallsZahlenTester
{
    // instance variables - replace the example below with your own
    Random random;

    /**
     * Constructor for objects of class zufallsZahlenTester
     */
    public zufallsZahlenTester()
    {
        random = new Random();
    }

    public int eineZufallsZahlAusgeben()
    {
        return random.nextInt(1000);
    }
    
    public int[] zufallsZahlenAusgeben(int anzahl)
    {
        int[] zahl=new int[anzahl];
        for(int i=0;i<anzahl;i++)
        {
            Arrays.fill(zahl, i,(i+1), random.nextInt(1000));
        }
        return zahl;
    }
    
    public int wuerfeln()
    {
        int zahl = random.nextInt(6);
        zahl++;
        return zahl;
    }
    
    public String gibAntwort()
    {
        ArrayList<String> antworten = new ArrayList<>();
        antworten.add("ja");
        antworten.add("nein");
        antworten.add("vielleicht");
        int zahl = random.nextInt(3);
        return antworten.get(zahl);
    }
    
    public int eineZufallsZahlAusgeben(int max)
    {
        int zahl=random.nextInt(max);
        zahl++;
        return zahl;
    }
    
    public int eineZufallsZahlAusgeben(int max, int min)
    {
        if(max<min)
        {
            int minimum=max;
            max=min;
            min=minimum;
        }
        int zahl=random.nextInt((max-min)+1);
        zahl+=min;
        return zahl;
    }
    
    public void test()
    {
        for(int i=0;i<10;i++)System.out.println(eineZufallsZahlAusgeben(3,5));
    }
}
