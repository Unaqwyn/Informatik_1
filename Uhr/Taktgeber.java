import java.util.*;

public class Taktgeber extends TimerTask
{
    private Uhr uhr;
    private Timer timer;
    


    public Taktgeber(Uhr uhr)
    {
        this.uhr = uhr;
        timer = new Timer();
        timer.scheduleAtFixedRate(this, 1000,1000);
    }
    
    public void run()
    {
        uhr.takt();
    }
}
