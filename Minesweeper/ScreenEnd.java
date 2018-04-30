import java.awt.*;
import javax.swing.*;

public class ScreenEnd extends Screen
{
    private JButton newGame;
    private Minesweeper minesweeper;
    
    public ScreenEnd(Minesweeper minesweeper)
    {
        this.minesweeper=minesweeper;
       newGame=new JButton("new Game");
       newGame.addActionListener(e->newGame());
       add(newGame);
    }

    private void newGame()
    {
        minesweeper.setScreen(1);
        Const.newGame();
    }
}
