import java.util.Random;

/**
 * Beispiele von Robotersteuerprogrammen
 * 
 * @author NTB Zo
 * @version 1.2
 */
public class Robi {

    private RobiAPI robi;

    /**
     * Erzeugt ein Stellvertreterobjekt eines Roboters. Es wird dazu sofort eine
     * Verbindung zum zu steuernden Roboter hergestellt.
     * 
     * @param hostname
     *            Hostname des Roboters, z.B. robiInf001.ntb.ch
     */
    public Robi(String hostname) {
        robi = new RobiAPI(hostname);
    }

    /**
     * Erzeugt ein Stellvertreterobjekt eines realen Roboters. Es wird dazu
     * sofort eine Verbindung zum realen Roboter hergestellt.
     * 
     * @param hostname
     *            Hostname des Robi, z.B. robiInf001.ntb.ch
     * @param portNumber
     *            Port Nummer des zu steuernden, z.B. 2000
     */
    public Robi(String hostname, int portNummer) {
        robi = new RobiAPI(hostname, portNummer);
    }

    /**
     * Der Roboter fährt planlos herum. Er fährt zuerst geradeaus vorwärts, bis
     * er irgendwo an eine Wand anstösst. Danach fährt er ein kurzes Stück
     * zurück, dreht an Ort ab. Dann beginnt der nächste Zyklus. Das Verfahren
     * ist auch unter dem Begriff "random walk" bekannt.
     */
    public void planlosFahren(int maxWandberührungen) {
        final int RobiFährtVorwärts = 0;
        final int RobiFährtRückwärts = 1;
        final int RobiDrehtAb = 2;

        System.out.println("PLANLOS FAHREN");

        // Intitialisieren
        int anzahlWandberührungen = 0;
        SandUhr uhr = new SandUhr();
        int zustand = RobiFährtVorwärts;

        robi.verbinden();
        robi.drive(5);
        System.out.println("Robi fährt vorwärts");

        while (anzahlWandberührungen < maxWandberührungen) {
            switch (zustand) {
                case RobiFährtVorwärts: {
                    robi.getDistSensorValues();
                    if (anWand()) {
                        bodenSensorWerteAusgeben();
                        robi.drive(-10);
                        uhr.starten(1000);
                        zustand = RobiFährtRückwärts;
                        System.out.println("Robi fährt rückwärts");
                    }
                    else
                    {
                        if(uhr.abgelaufen())
                        {
                            robi.turn(randomSpeed());
                            uhr.starten(randomTime()+500);
                            while(!(uhr.abgelaufen()))
                            {}
                            robi.drive(5);
                        }
                    }
                    break;
                }
                case RobiFährtRückwärts: {
                    if (uhr.abgelaufen()) {
                       robi.turn(directionSpeed());
                        uhr.starten(randomTime()+500);
                        zustand = RobiDrehtAb;
                        System.out.println("Robi dreht ab");
                    }
                    break;
                }
                case RobiDrehtAb: {
                    if (uhr.abgelaufen()) {
                        anzahlWandberührungen++;
                        robi.drive(5);
                        zustand = RobiFährtVorwärts;
                        System.out.println("Robi fährt vorwärts");
                    }
                    break;
                }
            }
        }
        robi.stop();
        robi.trennen();

        System.out.println("FERTIG");
        System.out.println();
    }

    private boolean anWand() {
        for (int i = 2; i < 16; i++) {
            if (robi.readSensor(i) > 100) {
                return true;
            }
        }
        return false;
    }

    private void bodenSensorWerteAusgeben() {
        for (int i = 2; i < 16; i++) {
            System.out.print(robi.readSensor(i) + " ");
        }
        System.out.println();
    }
    
    private int randomTime()
    {
        Random random=new Random();
        int randomTime=random.nextInt(1000);
        return(randomTime);
    }

    private int randomSpeed()
    {
        Random random=new Random();
        int randomDirection=random.nextInt(2);
        int turnSpeed = 20;
        if(randomDirection==0)
        {
            turnSpeed=-20;
        }
        return turnSpeed;
    }
    
    private int directionSpeed()
    {
        int direction=20;
        for(int i=10;i<13;i++)
        {
            if(robi.readSensor(i)>=100)
            {
                direction=-20;
            }
            
        }
        return direction;
    }
}
