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
        System.out.print('\u000C');
        final int RobiFährtVorwärts = 0;
        final int RobiFährtRückwärts = 1;
        final int RobiDrehtAb = 2;
        boolean zaehlt=false;

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
                        zaehlt=false;
                    }
                    /*
                     else
                    {
                        Random random=new Random();
                        if(random.nextInt(70000)==10568)
                        {
                            robi.turn(randomSpeed());
                            uhr.starten(randomTime()+500);
                            while(!(uhr.abgelaufen()))
                            {}
                            robi.drive(5);
                        }
                    }
                    */
                    
                     else if(zaehlt==false)
                    {
                        uhr.starten(5*randomTime()+2000);
                        zaehlt=true;
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
                            zaehlt=false;
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
                        zaehlt=false;
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
    
    public void pendeln(int anzahlDurchgaenge, int vVorwaerts, int vRueckwaerts, int tVorwaerts, int tVorneWarten, int tRueckwaerts, int tHintenWarten)
    {
        System.out.print('\u000C');
        
        final int vorwaerts=1;
        final int wartenVorne=2;
        final int rueckwaerts=3;
        final int wartenHinten=4;
        
        int zustand = vorwaerts;
        
        SandUhr uhr = new SandUhr();
        robi.verbinden();
        robi.drive(vVorwaerts);
        System.out.println("Robi fährt vorwärts");
        int durchgaenge = 0;
        uhr.starten(tVorwaerts);
        
        
        while(durchgaenge<=anzahlDurchgaenge)
        {
            switch(zustand)
            {
               case vorwaerts:{
                   if(uhr.abgelaufen())
                   {
                       uhr.starten(tVorneWarten);
                       robi.stop();
                       System.out.println("wartet vorne");
                       zustand=wartenVorne;
                    }
                    break;
                } 
               case wartenVorne:
               {
                   if(uhr.abgelaufen())
                   {
                       uhr.starten(tRueckwaerts);
                       robi.drive((-1)*vRueckwaerts);
                       System.out.println("Robi fährt rückwärts");
                       zustand=rueckwaerts;
                    }
                    break;
                }
               case rueckwaerts:
               {
                   if(uhr.abgelaufen())
                   {
                       uhr.starten(tHintenWarten);
                       robi.stop();
                       System.out.println("wartet hinten");
                       zustand=wartenHinten;
                    }
                    break;
                }
               case wartenHinten:
               {
                   if(uhr.abgelaufen())
                   {
                       uhr.starten(tVorwaerts);
                       robi.drive(vVorwaerts);
                       durchgaenge++;
                       System.out.println("Robi fährt vorwärts");
                       zustand=vorwaerts;
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
    
    public void singleEdgeFollow(int zeit)
    {
        System.out.print('\u000C');
        
        SandUhr uhr = new SandUhr();
        robi.verbinden();
        robi.drive(10);
        System.out.println("Robi fährt vorwärts");
        SandUhr generalUhr = new SandUhr();
        generalUhr.starten(zeit);
        robi.getDistSensorValues();
        while(!generalUhr.abgelaufen()&&robi.readSensor(0)>=100)
        {
            robi.getDistSensorValues();
            robi.drive(10);
            uhr.starten(100);
            while(!uhr.abgelaufen()){}
        }

            while(!generalUhr.abgelaufen())
            {
                robi.getDistSensorValues();
                if(robi.readSensor(0)>=100)
                {
                    linksKurve();
                }
                else if(robi.readSensor(0)<100)
                {
                    rechtsKurve();
                }
                uhr.starten(100);
                    while(!uhr.abgelaufen()){}
            }
            System.out.println("Fertig");
        
            robi.stop();
            robi.trennen();

            System.out.println("FERTIG");
            System.out.println();
    }
    
    public void doubleEdgeFollow(int zeit)
    {
        System.out.print('\u000C');
        
        SandUhr uhr = new SandUhr();
        robi.verbinden();
        robi.drive(10);
        System.out.println("Robi fährt vorwärts");
        SandUhr generalUhr = new SandUhr();
        generalUhr.starten(zeit);
        robi.getDistSensorValues();
        if(robi.readSensor(0)<100^robi.readSensor(1)>=100)
        {
            
        }
        else if(robi.readSensor(0)<100)
        {
            while(!generalUhr.abgelaufen()&&robi.readSensor(0)<100)
            {
                robi.getDistSensorValues();
                robi.drive(10);
                //zickzackFahren();
            }
        }
        else if(robi.readSensor(0)>=100)
        {
            while(!generalUhr.abgelaufen()&&robi.readSensor(0)>=100)
            {
                robi.getDistSensorValues();
                robi.drive(10);
                //zickzackFahren();
            }
        }
        
        
        
        

            while(!generalUhr.abgelaufen())
            {
                robi.getDistSensorValues();
                if(robi.readSensor(0)<100&&robi.readSensor(1)>=100)
                {
                    robi.drive(10);
                }
                else if(robi.readSensor(0)>=100&&robi.readSensor(1)>=100)
                {
                    linksKurve();
                }
                else if(robi.readSensor(1)<100&&robi.readSensor(0)<100)
                {
                    rechtsKurve();
                }
            }
        
            robi.stop();
            robi.trennen();

            System.out.println("FERTIG");
            System.out.println();
    }
    
    public void lightFollow(int zeit)
    {
        System.out.print('\u000C');
        
        SandUhr uhr = new SandUhr();
        robi.verbinden();
        robi.drive(10);
        System.out.println("Robi fährt vorwärts");
        SandUhr generalUhr = new SandUhr();
        generalUhr.starten(zeit);
        robi.getDistSensorValues();
        
        while(!generalUhr.abgelaufen())
        {
            robi.getDistSensorValues();
            if(whereLight()==2)
            {
                robi.drive(10);
            }
            else if(whereLight()>3&&whereLight()<10)
            {
                robi.turn(-20);
            }
            else if(whereLight()<16&&whereLight()>9)
            {
                robi.turn(20);
            }
            else if(whereLight()==3)
            {
                robi.drive(-10);
            }
        }

        
        
        robi.stop();
        robi.trennen();

        System.out.println("FERTIG");
        System.out.println();
    }
    
    public void wallFollow(int zeit)
    {
        System.out.print('\u000C');
        
        
        SandUhr uhr = new SandUhr();
        robi.verbinden();
        robi.drive(10);
        System.out.println("Robi fährt vorwärts");
        SandUhr generalUhr = new SandUhr();
        generalUhr.starten(zeit);
        robi.getDistSensorValues();
        while(!generalUhr.abgelaufen()&&!anWand())
        {
            zickzackFahren();
            robi.getDistSensorValues();
        }
        
        while(!generalUhr.abgelaufen())
        {
            robi.getDistSensorValues();
            if((robi.readSensor(6)==robi.readSensor(7))&&(whereLight()==6||whereLight()==7))
            {
                robi.drive(20);
            }
            else if(whereLight()==6)
            {
                rechtsKurve();
            }
            else if((whereLight()>=7&&whereLight()<=9)||whereLight()==3)
            {
                linksKurve();
            }
            else
            {
                robi.turn(20);
            }
        }

        robi.stop();
        robi.trennen();

        System.out.println("FERTIG");
        System.out.println();
    }
    
    public void wallFollowCases(int zeit)
    {
        System.out.print('\u000C');
        
        final int wandSuchen=1;
        final int anWand=2;
        final int anEcke=3;
        int zustand = wandSuchen;
        
        SandUhr uhr = new SandUhr();
        robi.verbinden();
        robi.drive(10);
        System.out.println("Robi fährt vorwärts");
        SandUhr generalUhr = new SandUhr();
        generalUhr.starten(zeit);
        robi.getDistSensorValues();
        while(!generalUhr.abgelaufen())
        {
            robi.getDistSensorValues();
            switch(zustand)
            {
                case wandSuchen:
                {
                    zickzackFahren();
                    if(anWand())
                    {
                        zustand=anWand;
                    }
                    break;
                }
                case anWand:
                {
                            if(robi.readSensor(2)>=100)
                            {
                                robi.turn(20);
                                zustand=anEcke;
                            }
                            else if((robi.readSensor(6)==robi.readSensor(7))&&(whereLight()==6||whereLight()==7))
                            {
                               robi.setRightDriveSpeed(19);
                               robi.setLeftDriveSpeed(20);
                            }
                            
                            else if(whereLight()<=6&&whereLight()>=4)
                            {
                                rechtsKurve();
                            }
                            else if((whereLight()>=7&&whereLight()<=9)||whereLight()==3)
                            {
                                linksKurve();
                            }
                            else if(whereLight()>=10&&whereLight()<=15)
                            {
                                robi.turn(20);
                            }
                            else if(!anWand())
                            {
                                zustand=wandSuchen;
                            }
                            break;
                }
                case anEcke:
                {
                    if(robi.readSensor(2)<100)
                    {
                        zustand=anWand;
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
    
    public void obstacleWarten(int zeit)
    {
        System.out.print('\u000C');
        
        final int hindernis=1;
        final int keinHindernis=2;
        int zustand = keinHindernis;
        
        SandUhr uhr = new SandUhr();
        robi.verbinden();
        robi.drive(10);
        System.out.println("Robi fährt vorwärts");
        SandUhr generalUhr = new SandUhr();
        generalUhr.starten(zeit);
        robi.getDistSensorValues();
        while(!generalUhr.abgelaufen())
        {
            robi.getDistSensorValues();
            switch(zustand)
            {
                case hindernis:
                {
                    if(robi.readSensor(2)<100)
                    {
                        zustand=keinHindernis;
                        robi.drive(10);
                    }
                break;
                }
                case keinHindernis:
                {
                    if(robi.readSensor(2)>=100)
                    {
                        zustand=hindernis;
                        robi.stop();
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
    
        public void streifen()
    {
        System.out.print('\u000C');
        
        final int hell=1;
        final int dunkel=2;
        int zustand = hell;
        int streifenzaehlen=0;
        
 
        robi.verbinden();
        robi.drive(10);
        System.out.println("Robi fährt vorwärts");


        robi.getDistSensorValues();
        while(streifenzaehlen!=3)
        {
            robi.getDistSensorValues();
            switch(zustand)
            {
                case hell:
                {
                    if(robi.readSensor(0)<100)
                    {
                        zustand=dunkel;
                    }
                break;
                }
                case dunkel:
                {
                    if(robi.readSensor(0)>=100)
                    {
                        zustand=hell;
                        streifenzaehlen++;
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
    
    private int whereLight()
    {
        int sensor=2;
        double max=robi.readSensor(2)+20;
        for (int i = 2; i < 16; i++) {
            if (robi.readSensor(i) > max) {
                max=robi.readSensor(i);
                sensor=i;
            }
        }
        if(max>=100)
        {
            return sensor;
        }
        else
        {
            return 2;
        }
    }
    
    public void zickzackFahren()
    {
            Random random=new Random();
            SandUhr zickzackUhr = new SandUhr();
                if(random.nextInt(30000)==5)
                        {
                         robi.turn(randomSpeed());
                         zickzackUhr.starten(randomTime()+500);
                         while(!(zickzackUhr.abgelaufen()))
                            {}
                         robi.drive(20);
                        }
    }
    
    private void linksKurve()
    {
        robi.setRightDriveSpeed(-20);
        robi.setLeftDriveSpeed(-15);
    }
    
    private void rechtsKurve()
    {
        robi.setRightDriveSpeed(15);
        robi.setLeftDriveSpeed(20);
    }

    public void pendeln()
    {
        pendeln(3,10,5,2000,1000,4000,3000);
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
        int max = robi.readSensor(2);
        int direction=20;
        for(int i=10;i<13;i++)
        {
            if(robi.readSensor(i)>=max)
            {
                direction=-20;
            }
            
        }
        return direction;
    }
}
