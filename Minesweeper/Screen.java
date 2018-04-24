import java.awt.*;
import javax.swing.*;

public abstract class Screen extends JFrame
{
    public Screen()
    {
        setBackground(Color.black);
        setBounds(0,0,Const.sizeX, Const.sizeY);
        setPreferredSize(Const.prefSize);
    }
    
   
}
