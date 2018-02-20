import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.lang.Integer;

/**
 * Notizbuch.
 * 
 * @author Prof. René Pawlitzek, NTB
 * @version 14.11.2014
 */
public class NotizbuchGUI {
 
    // GUI
    private  JFrame     fenster;
    private  JLabel     statusBar = new JLabel ();
    private  JTextArea  textArea = new JTextArea ();
   
     // Speicher für eine beliebige Anzahl an Notizen.
    private ArrayList<String> notizen;
    
    public NotizbuchGUI() {
        notizen = new ArrayList<String>();
        fensterErzeugen();
    }
    
    private void updateStatus () {
        statusBar.setText ("Anzahl Notizen: " + gibAnzahlNotizen());
    }
    
    
    private void erzeugeMenuBar (JFrame fenster) {
              
        JMenuBar menuBar = new JMenuBar();
        fenster.setJMenuBar(menuBar);
        
        JMenu menu = new JMenu("Datei");
        menuBar.add(menu);
        
        JMenuItem item = new JMenuItem("Neue Notiz");
        item.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
              textArea.setEditable(true);
              textArea.setText(null);
           }
        });
        menu.add(item);
        
        item = new JMenuItem("Notiz speichern");
        item.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) { 
              speichereNotiz (textArea.getText());
              textArea.setEditable(false);
              textArea.setText(null);
              updateStatus(); 
           }
        });
        menu.add(item);
        
        item = new JMenuItem("Alle Notizen drucken");
        item.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) { 
              druckeNotizen();
           }
        });
        menu.add(item);    
        
        item = new JMenuItem("Notiz löschen");
        item.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) { 
              textArea.setEditable(true);
              textArea.setText(null);
           }
        });
        menu.add(item); 
        
        item = new JMenuItem("Notiz löschen bestätigen");
        item.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) { 
              int x=Integer.parseInt(textArea.getText());
              System.out.println(x);
              entferneNotiz(x);
              textArea.setEditable(false);
              textArea.setText(null);
              updateStatus();
           }
        });
        menu.add(item); 
        
        menu.addSeparator();
        
        item = new JMenuItem("Verlassen");
        item.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) { 
              System.exit(0);
           }
        });
        menu.add(item);
        
        menu = new JMenu("Editieren");
        menu.addMenuListener(new MenuListener() {
            public void menuSelected(MenuEvent e) {
                JMenu editMenu = (JMenu) e.getSource();
                erzeugeEditMenu(editMenu);
            }
            public void menuCanceled(MenuEvent e) {
            }
            public void menuDeselected(MenuEvent e) {
            }
        });
        menuBar.add (menu);
        
    }
    
    
    private void erzeugeEditMenu (JMenu menu) {
        menu.removeAll();
        for (int i = 0; i < gibAnzahlNotizen(); i++) {
           JMenuItem item = new JMenuItem((i + 1) + ". Notiz");
           item.setActionCommand("" + i);
           item.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 JMenuItem menuItem = (JMenuItem) e.getSource();
                 int notizNummer = Integer.parseInt(menuItem.getActionCommand());
                 String notiz = gibNotiz(notizNummer);
                 textArea.setEditable(false);                 
                 textArea.setText(notiz);
             } 
           });         
           menu.add(item);
        }
    }

    
    private void fensterErzeugen() {
        
        fenster = new JFrame("Notizbuch");
        erzeugeMenuBar(fenster);
        
        Container contentPane = fenster.getContentPane();
        contentPane.setLayout(new BorderLayout(6, 6));
        contentPane.add(textArea, BorderLayout.CENTER);
        contentPane.add(statusBar, BorderLayout.SOUTH);
        
        fenster.setPreferredSize (new Dimension (400, 300));
        fenster.pack();
        
        textArea.setEditable(false);
        updateStatus ();
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        fenster.setLocation(d.width/2 - fenster.getWidth()/2, d.height/2 - fenster.getHeight()/2);      
        fenster.setVisible(true);  
        
    }
    
    private boolean gueltigeNotizNummer(int notizNummer) {
        // TODO gueltigeNotizNummer
        if(notizNummer<notizen.size())
        {
            return true;
        }
        return false;
    } 


    private void speichereNotiz(String notiz) {
        notizen.add(notiz);
    }
    
    
    private String gibNotiz(int notizNummer) {
        // TODO gibNotiz
        return notizen.get(notizNummer);
    }

   
    private int gibAnzahlNotizen() {
        // TODO gibAnzahlNotizen
        return notizen.size();        
    }

    
    private void entferneNotiz(int notizNummer) {
        // TODO entferneNotiz
        notizen.remove(notizNummer);
    }
    
    
    private void druckeNotizen() {
        // TODO druckeNotizen
        System.out.print('\u000C');
        for(int i=0;i<notizen.size();i++)
        {
            System.out.println((i+1)+ ". Notiz");
            System.out.println(notizen.get(i));
        }
    } 
    

    
    public int test()
    {
        return textArea.getRows();
    }
}
