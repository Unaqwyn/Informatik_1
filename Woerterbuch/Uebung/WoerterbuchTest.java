package Uebung;


/**
 * Die KLasse WoerterbuchTest testet die Klasse Woerterbuch.
 * 
 * @author Martin Studer
 * @version 27.11.2011
 */
public class WoerterbuchTest
{
    /**
     * Konstruktor für Objekte der Klasse WoerterbuchTest
     */
    public WoerterbuchTest()
    {
    }

    /**
     * Teste die Klasse Woerterbuch.
     */
    public void test()
    {
        // Erzeuge ein Wörterbuch mit zwei Einträgen
        Woerterbuch wb = new Woerterbuch();
        wb.erfasse("rot", "red");
        wb.erfasse("weiss", "white");
        
        // Prüfe Methode gib Anzahl
        System.out.println("Anzahl Einträge. Erwartet: 2, Resultat: " + wb.gibAnzahl());
        
        // Prüfe Methode deutschNachEnglisch
        String englisch = wb.deutschNachEnglisch("rot");
        System.out.println("Übersetzung von rot: Erwartet: red, Resultat: " + englisch);
        englisch = wb.deutschNachEnglisch("unbekannt");
        System.out.println("Übersetzung von unbekannt: Erwartet: null, Resultat: " + englisch);
        
        // Prüfe Methode englischNachDeutsch
        String deutsch = wb.englischNachDeutsch("white");
        System.out.println("Übersetzung von white: Erwartet: weiss, Resultat: " + deutsch);
        
        // Prüfe Methode drucke
        wb.drucke();
        
        // Prüfe Methode loescheDeutsch
        wb.loescheDeutsch("weiss");
        System.out.println("Anzahl Einträge. Erwartet: 1, Resultat: " + wb.gibAnzahl());
        wb.loescheDeutsch("white");
        System.out.println("Anzahl Einträge. Erwartet: 1, Resultat: " + wb.gibAnzahl());
    }
    

}
