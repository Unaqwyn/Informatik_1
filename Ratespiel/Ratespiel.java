 import java.util.Random;

/**
 * Write a description of class Ratespiel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ratespiel
{
    // instance variables - replace the example below with your own
    private int gesucht;
    private boolean gewonnen;
    private double counter;
    private int games;
    private int min;
    private int max;
    private double result;
    private double avr;

    /**
     * Constructor for objects of class Ratespiel
     */
    public Ratespiel()
    {
        games = 0;
        gewonnen = true;
        neuesSpiel();
        result = 0;
        avr = 0;
    }

    public void neuesSpiel ()
    {
        if (gewonnen == true)
        {
            System.out.print('\u000C');
            Random zufallsGenerator = new Random();
            gesucht = zufallsGenerator.nextInt(1000);
            System.out.println("Nächste Runde beginnt!");
            gewonnen = false;
            counter = 0;
            min = 0;
            max = 999;
        }
        else
        {
            System.out.println("Spiele zuerst fertig.");
        }
    }

    public void raten(int geraten)
    {
        counter ++;
        if(geraten<gesucht)
        {
            System.out.println(geraten + " ist zu klein.");
            min = geraten;
        }
        else if(geraten > gesucht)
        {
            System.out.println(geraten + " ist zu gross.");
            max = geraten;
        }
        else if(geraten == gesucht)
        {
            System.out.println(geraten + " ist richtig.");
            System.out.println("Du musstest " + counter + " mal raten.");
            gewonnen = true;
            games++;
            result += counter;
            avr = result / games;
            avr = 100*avr;
            int avrRunden = (int) avr;
            avr = (double) avrRunden;
            avr = (avr/100);
            System.out.println("Du musstest in den letzten " + games + " Spielen im Schnitt " + avr + " mal raten.");
        }
        
   }
   
   public void autoRaten()
   {
       while(gewonnen == false)
       {
           int raten = (min + max)/2;
           raten(raten);
       }
   }

}
