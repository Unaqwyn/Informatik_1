import java.awt.*;
import javax.swing.*;


public class PlayArea extends JPanel
{
    private Tile[][] tiles;
    private int[][] values;
    
    
    public PlayArea(BombMap bombMap)
    {
        setBackground(Color.black);
        setBounds(0,200,Const.sizeX, Const.sizeX);
        setPreferredSize(new Dimension(Const.sizeX, Const.sizeX));
        setLayout(new GridLayout(Const.size, Const.size));
        values=bombMap.getValues();
        tiles=new Tile[Const.size][Const.size];
        for(int y=0;y<Const.size;y++)
        {
            for(int x=0;x<Const.size;x++)
            {
                 tiles[x][y]=new Tile(values[x][y]);
                 add(tiles[x][y]);
            }
        }
    }
    
    public void chord(int x, int y)
    {
        if(x>0&&y>0)
        {
            tiles[x-1][y-1].flip();
        }
        if(y>0)
        {
            tiles[x][y-1].flip();
        }
        if(x<Const.size-1&&y>0)
        {
            tiles[x+1][y-1].flip();
        }
        if(x>0)
        {
            tiles[x-1][y].flip();
        }
        if(x<Const.size-1)
        {
            tiles[x+1][y].flip();
        }
        if(x>0&& y<Const.size-1)
        {
            tiles[x-1][y+1].flip();
        }
        if(y<Const.size-1)
        {
            tiles[x][y+1].flip();
        }
        if(x<Const.size-1 && y<Const.size-1)
        {
            tiles[x+1][y+1].flip();
        }
    }
    
    public void firstFlipped(int x, int y)
    {
        
    }
}
