import java.awt.*;
import javax.swing.*;

public class ScreenDiff extends Screen
{
    private Minesweeper minesweeper;
    
    public ScreenDiff(Minesweeper x)
    {
       minesweeper = x;
       setLayout(new BorderLayout());
       JPanel panel=new JPanel();
       panel.setPreferredSize(new Dimension(300,75));
       panel.setLayout(new GridLayout(3,1));
       
       JButton easy=new JButton("Easy");
       easy.setPreferredSize(new Dimension(300,125));
       easy.addActionListener(e->setScreen(Const.EASY));
       panel.add(easy);
       
       JButton medium=new JButton("Medium");
       medium.setPreferredSize(new Dimension(300,125));
       medium.addActionListener(e->setScreen(Const.MEDIUM));
       panel.add(medium);
       
       JButton hard=new JButton("Hard");
       hard.setPreferredSize(new Dimension(300,125));
       hard.addActionListener(e->setScreen(Const.HARD));
       panel.add(hard);
       
       add(panel, BorderLayout.CENTER);
    }

    public void setScreen(int difficulty)
    {
        Const.setDiff(difficulty);
        minesweeper.setScreen(1);
    }
}
