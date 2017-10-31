import java.util.Calendar;

public class Uhr
{
    private Zeit zeit;
    private DigitalAnzeige anzeige;
    private Taktgeber taktgeber;
    private boolean running;
    private boolean vorwaerts;


    public Uhr()
    {
        running = true;
        vorwaerts = true;
        Calendar c = Calendar.getInstance();
        int stunde = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int sekunde = c.get(Calendar.SECOND);
        zeit=new Zeit(stunde,minute,sekunde);
        anzeige = new DigitalAnzeige();
        taktgeber = new Taktgeber(this);
       
    }
    
    public void takt()
    {
            zeit.erhoehen(vorwaerts);
            int stunden = zeit.gibStunden();
            int minuten = zeit.gibMinuten();
            int sekunden = zeit.gibSekunden();
            if(running ==true)
            {
                anzeige.setzeZeit(stunden, minuten, sekunden);
            }
    }
    

    public static void main (String[] args)
    {
        new Uhr();
    }
    
    public void stopGo()
    {
        running = !running;
    }
    
    public void richtungAendern()
    {
        vorwaerts = !vorwaerts;
    }
}
