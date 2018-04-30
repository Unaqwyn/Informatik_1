import java.awt.*;
import javax.swing.*;


public class PlayArea extends JPanel
{
    private Tile[][] tiles;
    private int[][] values;
    private BombMap bombMap;
    private Minesweeper minesweeper;
    
    
    public PlayArea(BombMap bombMap, Minesweeper minesweeper)
    {
        this.bombMap=bombMap;
        this.minesweeper=minesweeper;
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
                 tiles[x][y]=new Tile(values[x][y], x, y, this);
                 add(tiles[x][y]);
            }
        }
    }
    
    public void chord(int x, int y)
    {
        if(x>0&&y>0)
        {
            tiles[x-1][y-1].flip(true);
        }
        if(y>0)
        {
            tiles[x][y-1].flip(true);
        }
        if(x<Const.size-1&&y>0)
        {
            tiles[x+1][y-1].flip(true);
        }
        if(x>0)
        {
            tiles[x-1][y].flip(true);
        }
        if(x<Const.size-1)
        {
            tiles[x+1][y].flip(true);
        }
        if(x>0&& y<Const.size-1)
        {
            tiles[x-1][y+1].flip(true);
        }
        if(y<Const.size-1)
        {
            tiles[x][y+1].flip(true);
        }
        if(x<Const.size-1 && y<Const.size-1)
        {
            tiles[x+1][y+1].flip(true);
        }
    }
    
    public void firstFlipped(int a, int b)
    {
        bombMap.setMap(a,b);
        values=bombMap.getValues();
        for(int y=0;y<Const.size;y++)
        {
            for(int x=0;x<Const.size;x++)
            {
                 tiles[x][y].setValue(values[x][y]);
            }
        }
    }
    
    public void end(boolean won)
    {
        System.out.println(won);
        minesweeper.setScreen(2);
    }
}
