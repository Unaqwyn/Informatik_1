import java.awt.*;
import javax.swing.*;

public class PlayUI extends JPanel
{
    public PlayUI()
    {
       setBackground(Color.white);
       setBounds(0,0,Const.sizeX, Const.sizeY-Const.sizeX);
       setPreferredSize(new Dimension(Const.sizeX, Const.sizeY-Const.sizeX));
    }
}
