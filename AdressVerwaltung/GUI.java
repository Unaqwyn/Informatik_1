 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

/**
 * 
 * @author NTB, Rene Pawlitzek
 * @version 5.10.2014
 */
public class GUI {

    static final String appTitel = "Fahrkartenautomat";

    // Fahrkarteautomat Modell
    private  Modell  meinModell;

    // Anzeigen für Guthaben und Fahrkartepreis
    private  JLabel   guthabenAnzeige    = new JLabel (" --.-- ", SwingConstants.RIGHT);
    private  JLabel   fahrkartenPreisAnzeige = new JLabel (" --.-- ", SwingConstants.RIGHT);

    // Buttons für Fahrkarteausgabe und Wechselgeld
    private  JButton  fahrkarteDrucken = new JButton (" Fahrkarte kaufen ");
    private  JButton  wechselGeld = new JButton (" Guthaben auszahlen ");

    // Fenster der Applikation
    private  JFrame  frame;

    private String gibAnzeigeWert (int wert) {
        return String.format ("%4.2f Franken", (float) wert / 100.f);
    } // gibAnzeigeWert

    private void guiAktualisieren () {
        int guthaben = meinModell.gibGuthaben();
        String tmp = gibAnzeigeWert (guthaben);
        guthabenAnzeige.setText (tmp);        
    } // guiAnzeigeAktualisieren

    public GUI(Modell modell) {

        // Fahrkarteautomat Modell speichern
        meinModell = modell;

        // Fenster erzeugen
        frame = new JFrame ("Fahrkartenautomat");

        // Font für die Anzeigen erzeugen
        Font font = new Font("Arial", Font.BOLD, 24);

        // Farbe für Anzeige erzeugen
        Color color = new Color (173, 230, 196);

        /* ----- rechte Seite ----- */

        // Panel mit Guthaben Anzeige
        guthabenAnzeige.setFont (font);
        guthabenAnzeige.setOpaque (true);
        guthabenAnzeige.setBackground (color);
        JPanel guthabenPanel = new JPanel (new BorderLayout ());
        guthabenPanel.add (guthabenAnzeige, BorderLayout.CENTER);
        TitledBorder guthabenTitel = BorderFactory.createTitledBorder("Guthaben");
        guthabenTitel.setTitleJustification(TitledBorder.CENTER); 
        guthabenPanel.setBorder (guthabenTitel);

        // Panel mit Münztasten
        JPanel muenzPanel = new JPanel (new GridLayout (3, 2, 5, 5));
        JButton  muenzButton5Franken = new JButton (" 5 Franken ");
        muenzButton5Franken.addActionListener (new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    modell.geldEinwerfen(500);
                    guiAktualisieren ();
                } // actionPerformed
            });
        JButton  muenzButton2Franken = new JButton (" 2 Franken ");
        muenzButton2Franken.addActionListener (new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    modell.geldEinwerfen(200);
                    guiAktualisieren ();
                } // actionPerformed
            });
        JButton  muenzButton1Franken = new JButton (" 1 Franken ");
        muenzButton1Franken.addActionListener (new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    modell.geldEinwerfen(100);
                    guiAktualisieren ();
                } // actionPerformed
            });
        JButton  muenzButton50Rappen = new JButton (" 50 Rappen ");
        muenzButton50Rappen.addActionListener (new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    modell.geldEinwerfen(50);
                    guiAktualisieren ();
                } // actionPerformed
            }); 
        JButton  muenzButton20Rappen = new JButton (" 20 Rappen ");
        muenzButton20Rappen.addActionListener (new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    modell.geldEinwerfen(20);
                    guiAktualisieren ();
                } // actionPerformed
            });
        JButton  muenzButton10Rappen = new JButton (" 10 Rappen ");
        muenzButton10Rappen.addActionListener (new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    modell.geldEinwerfen(10);
                    guiAktualisieren ();
                } // actionPerformed
            });         
        muenzPanel.add (muenzButton5Franken);
        muenzPanel.add (muenzButton50Rappen);
        muenzPanel.add (muenzButton2Franken);
        muenzPanel.add (muenzButton20Rappen);
        muenzPanel.add (muenzButton1Franken);   
        muenzPanel.add (muenzButton10Rappen);
        muenzPanel.setBorder (new EmptyBorder (5, 5, 5, 5));

        // Panel mit Guthaben-Anzeige und Münztasten
        JPanel panel1 = new JPanel ();
        panel1.setLayout (new BoxLayout (panel1, BoxLayout.Y_AXIS));
        panel1.add (guthabenPanel);
        panel1.add (muenzPanel);

        // Panel mit Guthaben Anzeige und Münztasten im Norden, damit der untere Teil frei bleibt
        JPanel geldeinwurfPanel = new JPanel (new BorderLayout ());
        geldeinwurfPanel.add (panel1, BorderLayout.NORTH);
        geldeinwurfPanel.setBorder (new TitledBorder ("Geldeinwurf"));

        /* ----- linke Seite ----- */

        // Panel mit Fahrkartepreis Anzeige
        String tmp = gibAnzeigeWert (modell.gibPreis());        
        fahrkartenPreisAnzeige.setText (tmp);
        fahrkartenPreisAnzeige.setFont (font);
        fahrkartenPreisAnzeige.setOpaque (true);
        fahrkartenPreisAnzeige.setBackground (color);        
        JPanel fahrkartePreisPanel = new JPanel (new BorderLayout ());
        fahrkartePreisPanel.add (fahrkartenPreisAnzeige, BorderLayout.CENTER);
        TitledBorder fahrkartesTitel = BorderFactory.createTitledBorder("Preis");
        fahrkartesTitel.setTitleJustification(TitledBorder.CENTER);         
        fahrkartePreisPanel.setBorder (fahrkartesTitel);

        // Panel mit Fahrkartes
        JPanel fahrkartePanel = new JPanel (new GridLayout (3, 1, 5, 5));
        ArrayList<JRadioButton> fahrkartenRadios = new ArrayList<JRadioButton>();
        fahrkartenRadios.add(new JRadioButton (meinModell.gibBezeichnung()));
        fahrkartenRadios.add(new JRadioButton ("Balzers-Sargans"));
        fahrkartenRadios.add(new JRadioButton ("Balzers-Chur"));
        for (JRadioButton button: fahrkartenRadios) {
            button.setEnabled(false);
            fahrkartePanel.add (button);
        }
        fahrkartenRadios.get(0).setEnabled (true);
        fahrkartenRadios.get(0).setSelected (true);
        ButtonGroup  fahrkartenGruppe = new ButtonGroup ();
        fahrkartenGruppe.add (fahrkartenRadios.get(0));

        // Panel mit Fahrkartepreis und Fahrkartes
        JPanel panel2 = new JPanel ();
        panel2.setLayout (new BoxLayout (panel2, BoxLayout.Y_AXIS));
        panel2.add (fahrkartePreisPanel);
        panel2.add (fahrkartePanel);

        // Panel mit Fahrkartepreis und Fahrkartes im Norden, damit der untere Teil frei bleibt
        JPanel fahrkartenPanel = new JPanel (new BorderLayout ());
        fahrkartenPanel.add (panel2, BorderLayout.NORTH);
        fahrkartenPanel.setBorder (new TitledBorder ("Fahrkarten"));

        /* ----- unterer Teil ----- */

        // Panel mit Tasten zum Drucken einer Fahrkarte und Wechselgeld ausgeben
        JPanel befehlePanel = new JPanel (new FlowLayout ());
        fahrkarteDrucken.addActionListener (new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    int nochZuZahlen = modell.gibPreis() - modell.gibGuthaben();
                    if (nochZuZahlen > 0) {
                        String tmp = gibAnzeigeWert (nochZuZahlen);
                        JOptionPane.showMessageDialog (frame, "Bitte werfen Sie noch " + tmp + " ein.", appTitel, JOptionPane.INFORMATION_MESSAGE);                
                    } else {
                        modell.fahrkarteKaufen ();
                        guiAktualisieren ();
                        JOptionPane.showMessageDialog (frame, "Hier ist ihre Fahrkarte:\n" + fahrkartenRadios.get(0).getText() ,appTitel, JOptionPane.INFORMATION_MESSAGE);
                    } 
                } 
            });
        wechselGeld.addActionListener (new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    int wechselgeld = modell.guthabenAuszahlen ();
                    guiAktualisieren ();
                    String tmp = gibAnzeigeWert (wechselgeld);
                    JOptionPane.showMessageDialog (frame, "Hier ist Ihr Guthaben:\n" + tmp, appTitel, JOptionPane.INFORMATION_MESSAGE);
                } 
            });
        befehlePanel.add (fahrkarteDrucken);
        befehlePanel.add (wechselGeld);

        /* ----- Panel kombinieren ----- */

        // Panel mit linkem und rechtem Panel
        JPanel panel3 = new JPanel (new GridLayout (1, 2));
        panel3.add (fahrkartenPanel);
        panel3.add (geldeinwurfPanel);

        // Panels zusammenfügen
        JPanel guiPanel = new JPanel (new BorderLayout ());
        guiPanel.add (panel3, BorderLayout.CENTER);
        guiPanel.add (befehlePanel, BorderLayout.SOUTH);

        // GUI Panel zum Fenster hinzufügen
        guiAktualisieren ();
        frame.setContentPane (guiPanel);

        // Fenster sichtbar machen
        frame.setPreferredSize (new Dimension (500, 300));
        frame.pack ();
        frame.setVisible (true);

    } 
}
