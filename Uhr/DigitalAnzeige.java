import javax.swing.*;
import java.awt.*;


public class DigitalAnzeige
{
    JTextField textFeld;
    
    public DigitalAnzeige()
    {
        JFrame fenster = new JFrame("Digitale Uhr");
        Container inhalt = fenster.getContentPane();
        textFeld = new JTextField();
        textFeld.setFont(new Font("Arial", Font.PLAIN, 72));
        inhalt.add(textFeld);
        setzeZeit(0,0,0);
        fenster.pack();
        fenster.setVisible(true);

    }
    
    public void setzeZeit(int stunden, int minuten, int sekunden) 
    {
        String s = String.format("%02d:%02d:%02d", stunden, minuten, sekunden);
        textFeld.setText(s);
    }
}
