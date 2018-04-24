import java.awt.*;
import javax.swing.*;

public class Const
{
    public static int sizeX=500;
    public static int sizeY=700;
    
    public static Dimension prefSize=new Dimension(sizeY,sizeX);
    
    public static final int EASY=15651;
    public static final int MEDIUM=181586;
    public static final int HARD=566811;
    public static int diff=EASY;
    public static int bombs=10;
    public static int size=8;
    public static int sizeTiles=40;
    public static boolean flagging=false;
    
    public Const()
    {
        
    }

    public static void setDiff(int difficulty)
    {
        difficulty=diff;
        if(diff==EASY)
        {
            bombs=10;
            size=8;
            sizeTiles=40;
        }
        else if(diff==MEDIUM)
        {
            bombs=40;
            size=16;
            sizeTiles=20;
        }
        else if(diff==HARD)
        {
            bombs=99;
            size=32;
            sizeTiles=10;
        }
    }
}
