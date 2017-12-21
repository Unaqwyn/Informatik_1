package Uebung;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


/**
 * Die Klasse Woerterbuch beschreibt ein 
 * Deutsch-Englisch Wörterbuch
 * 
 * @author Martin Studer
 * @version 27.11.2011
 */
public class Woerterbuch
{
   // TODO: Hier kommen Ihr(e) Datenfeld(er)
   
    ArrayList<String> englischeWoerter;
    ArrayList<String> deutscheWoerter;
    private Scanner scanner;
    private Random random;

    /**
     * Konstruktor für Objekte der Klasse Woerterbuch
     */
    public Woerterbuch()
    {
        // TODO
        random=new Random();
        scanner=new Scanner(System.in);
        System.out.print('\u000C');
        englischeWoerter=new ArrayList<>();
        deutscheWoerter=new ArrayList<>();
    }

    /**
     * Erfasse einen neuen Eintrag.
     * 
     * @param deutsch das deutsche Wort
     * @param englisch das englische Wort
     */
    public void erfasse(String deutsch, String englisch)
    {
        // TODO
        englischeWoerter.add(englisch);
        deutscheWoerter.add(deutsch);
    }
    
    /**
     * Gib die Anzahl Einträge zurück.
     * 
     * @return die Anzahl Einträge.
     */
    public int gibAnzahl() {
        // TODO
        return englischeWoerter.size();
    }

    /**
     * Übersetze von deutsch nach englisch.
     * 
     * @param deutsch das deutsche Wort
     * @return das englische Wort oder null, 
     *         falls das deutsche Wort nicht vorkommt
     */
    public String deutschNachEnglisch(String deutsch) {
        // TODO    
        int index=sucheDeutsch(deutsch);
        if(index!=-1)
        {
            return englischeWoerter.get(index);
        }
        return null;
    }
    
    /**
     * Übersetze von englisch nach deutsch.
     * 
     * @param englisch das englische Wort
     * @return das deutsche Wort oder null, 
     *         falls das englische Wort nicht vorkommt
     */
    public String englischNachDeutsch(String englisch) {
        // TODO
        int index=sucheEnglisch(englisch);
        if(index!=-1)
        {
            return deutscheWoerter.get(index);
        }
        return null;
    }

    /**
     * Drucke alle Einträge.
     */
    public void drucke() {
        // TODO
        for(int i=0;i<englischeWoerter.size();i++)
        {
            System.out.println(englischeWoerter.get(i)+ "   "+deutscheWoerter.get(i));
        }
    }

    /**
     * Lösche den Eintrag mit dem gegebenen deutschen Wort.
     * Falls kein Eintrag mit dem gegebenen Wort vorkommt, passiert nichts.
     * 
     * @param deutsch das deutsche Wort des zu löschenden Eintrages
     */
    public void loescheDeutsch(String deutsch) {
        // TODO
        if(sucheDeutsch(deutsch)!=-1)
        {
            for(int i=0;i<deutscheWoerter.size();i++)
            {
                if(deutscheWoerter.get(i).equals(deutsch))
                {
                    deutscheWoerter.remove(i);
                    englischeWoerter.remove(i);
                    i--;
                }
            }
        }
    }
    
    public int sucheDeutsch(String deutsch)
    {
        for(int i=0;i<deutscheWoerter.size();i++)
        {
            if(deutscheWoerter.get(i).equals(deutsch))
            {
                return i;
            }
        }
        return -1;
    }
    
    public int sucheEnglisch(String englisch)
    {
        for(int i=0;i<englischeWoerter.size();i++)
        {
            if(englischeWoerter.get(i).equals(englisch))
            {
                return i;
            }
        }
        return -1;
    }
    
    public String gibEingabe() 
    {
        System.out.print("> ");   // Eingabebereitschaft anzeigen
        String eingabezeile = scanner.nextLine();

        return eingabezeile;
    }
    
    public void testenENachD()
    {
        int index=random.nextInt(deutscheWoerter.size());
        System.out.println(englischeWoerter.get(index));
        String deutsch=gibEingabe();
        System.out.println(deutscheWoerter.get(index));
        if(deutscheWoerter.get(index).equals(deutsch))
        {
            System.out.println("korrekt");
        }
        else
        {
            System.out.println("falsch");
        }
    }
    
    public void testenDNachE()
    {
        int index=random.nextInt(englischeWoerter.size());
        System.out.println(deutscheWoerter.get(index));
        String englisch=gibEingabe();
        System.out.println(englischeWoerter.get(index));
        if(englischeWoerter.get(index).equals(englisch))
        {
            System.out.println("korrekt");
        }
        else
        {
            System.out.println("falsch");
        }
    }
    
    public void testenENachD(int wiederholungen)
    {
        for(int i=0;i<wiederholungen;i++)testenENachD();
    }
    
    public void testenDNachE(int wiederholungen)
    {
        for(int i=0;i<wiederholungen;i++)testenDNachE();
    }
       
    public void test()
    {
        erfasse("rot","red");
        erfasse("blau","blue");
        erfasse("grün","green");
        erfasse("schwarz","black");
        erfasse("grau","grey");
    }
}
