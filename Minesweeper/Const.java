import java.awt.*;
import javax.swing.*;
import javafx.scene.text.Font;


public class Const
{
    public static int sizeX=960;
    public static int sizeY=1000;
    
    public static Dimension prefSize=new Dimension(sizeX,sizeY);
    
    public static final int EASY=15651;
    public static final int MEDIUM=181586;
    public static final int HARD=566811;
    public static int diff=EASY;
    public static int bombs=10;
    public static int size=8;
    public static int sizeTiles=40;
    public static Dimension prefSizeTile=new Dimension(sizeTiles, sizeTiles);
    public static boolean flagging=false;
    public static boolean firstFlipped=false;
    public static Font font=new Font(20);
    public static int winCon=size*size-bombs+1;
    public static int tilesFlipped=0;
    
    public Const()
    {
        
    }

    public static void setDiff(int difficulty)
    {
        diff=difficulty;
        if(diff==EASY)
        {
            bombs=10;
            size=8;
            sizeTiles=40;
            prefSizeTile=new Dimension(sizeTiles, sizeTiles);
            winCon=size*size-bombs+1;
        }
        else if(diff==MEDIUM)
        {
            bombs=40;
            size=16;
            sizeTiles=20;
            prefSizeTile=new Dimension(sizeTiles, sizeTiles);
            font=new Font(15);
            winCon=size*size-bombs+1;
        }
        else if(diff==HARD)
        {
            bombs=99;
            size=32;
            sizeTiles=10;
            prefSizeTile=new Dimension(sizeTiles, sizeTiles);
            font=new Font(10);
            winCon=size*size-bombs+1;
        }
    }
    
    public static void newGame()
    {
         flagging=false;
         firstFlipped=false;
         tilesFlipped=0;
    }
}
