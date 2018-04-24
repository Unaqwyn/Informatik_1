import java.awt.*;
import javax.swing.*;

public class PlayUI extends JPanel
{
    private JButton newGame;
    private JButton flag;
    private JLabel remaining;
    
    public PlayUI()
    {
       setBackground(Color.white);
       setBounds(0,0,Const.sizeX, Const.sizeY-Const.sizeX);
       setPreferredSize(new Dimension(Const.sizeX, Const.sizeY-Const.sizeX));
       
       remaining=new JLabel("remaining" + 0);
       add(remaining);
       
       newGame=new JButton("new game");
       add(newGame);
       
       flag=new JButton("Flag");
       add(flag);
    }
    
    
}
