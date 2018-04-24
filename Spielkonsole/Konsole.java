import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
/**
 * Write a description of class Konsole here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Konsole
{
    private JFrame fenster;
    
    public Konsole()
    {
        fenster=new JFrame("Konsole");
        Container contentPane=fenster.getContentPane();
        contentPane.setLayout(new GridLayout(1,2));
        
        JLabel bild=new JLabel();
        bild.setIcon(new ImageIcon("screen.png"));
        contentPane.add(bild);
        
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(0,1));
        
        JLabel platzhalter=new JLabel();
        panel.add(platzhalter);
        
        
        JPanel steuerKreuz=new JPanel();
        steuerKreuz.setLayout(new GridLayout(3,3));
        String[] kreuz={"","up","","left","Jump","right","","down",""};
        
        for(int i=0;i<kreuz.length;i++)
        {
            if(!kreuz[i].equals(""))
            {
            JButton label=new JButton(kreuz[i]);
            if(kreuz[i].equals("Jump"))
            {
                label.addActionListener(
                    (ActionEvent e)-> {jump();}
                    );
            }
            steuerKreuz.add(label);
        }
        else
        {
            JLabel label=new JLabel(kreuz[i]);
            steuerKreuz.add(label);
        }
        }
        
        panel.add(steuerKreuz);
        contentPane.add(panel);
        
        fenster.pack();
        fenster.setVisible(true);
    }
    
    public void jump()
    {
        JOptionPane.showMessageDialog(fenster, "Jump","Jump", JOptionPane.INFORMATION_MESSAGE);
    }
}
