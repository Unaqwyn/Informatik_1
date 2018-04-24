import java.awt.*;
import javax.swing.*;

public class ScreenDiff extends Screen
{
    
    public ScreenDiff()
    {
       setLayout(new BorderLayout());
       JPanel panel=new JPanel();
       panel.setPreferredSize(new Dimension(300,75));
       panel.setLayout(new GridLayout(3,1));
       
       JButton easy=new JButton("Easy");
       easy.setPreferredSize(new Dimension(300,125));
       panel.add(easy);
       
       JButton medium=new JButton("Medium");
       medium.setPreferredSize(new Dimension(300,125));
       panel.add(medium);
       
       JButton hard=new JButton("Hard");
       hard.setPreferredSize(new Dimension(300,125));
       panel.add(hard);
       
       add(panel, BorderLayout.CENTER);
    }

}
