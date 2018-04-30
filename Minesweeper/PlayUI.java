import java.awt.*;
import javax.swing.*;

public class PlayUI extends JPanel
{
    private JButton newGame;
    private JButton flag;
    private JLabel remaining;
    private Minesweeper minesweeper;
    
    public PlayUI(Minesweeper minesweeper)
    {
       this.minesweeper=minesweeper; 
       setBackground(Color.white);
       setBounds(0,0,Const.sizeX, Const.sizeY-Const.sizeX);
       setPreferredSize(new Dimension(Const.sizeX, Const.sizeY-Const.sizeX));
       
       remaining=new JLabel("remaining: " + 0);
       add(remaining);
       
       newGame=new JButton("new game");
       newGame.addActionListener(e->newGame());
       add(newGame);
       
       flag=new JButton("Flag");
       flag.setBackground(Color.red);
       flag.addActionListener(e->flagging());
       add(flag);
    }
    
    private void flagging()
    {
        if(!Const.flagging)
        {
            Const.flagging=!Const.flagging;
            flag.setBackground(Color.blue);
        }
        else if(Const.flagging)
        {
            Const.flagging=!Const.flagging;
            flag.setBackground(Color.red);
        }
    }
    
    private void newGame()
    {
        minesweeper.setScreen(1);
        Const.newGame();
    }
}
