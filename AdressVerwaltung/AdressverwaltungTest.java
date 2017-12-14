
/**
 * Teste die Klasse Adressverwaltung.
 * 
 * @author Martin Studer
 * @version 27.11.2011
 */
public class AdressverwaltungTest
{

    public void test()
    {
        Adressverwaltung adressen = new Adressverwaltung();

        // Die Methode erfassen dient der Erfassung neuer Adressen.
        adressen.erfasse("Fritz", "Fischer", "3434", "Fingen");
        adressen.erfasse("Max", "Mettler", "5656", "Murgen");
        adressen.erfasse("Hans", "Huber", "7878", "Humbel");

        // Die Methode gibAnzahl liefert die Anzahl Adressen zurück.
        System.out.println(adressen.gibAnzahl());

        // Die Methode drucke druckt alle Adressen auf die Konsole
        adressen.drucken();
        
        adressen.sucheNachname("Mettler");
    }
}

