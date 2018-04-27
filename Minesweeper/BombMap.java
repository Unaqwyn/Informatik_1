import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class BombMap
{
    private Random random;
    private int[] bombs;
    private int[][] values;
    
    public BombMap()
    {
        random = new Random();
        generateBombs();
        generateValues();
    }
    
    public int[][] getValues()
    {
        return values;
    }

    public void generateBombs()
    {
        bombs=new int[Const.bombs];
        int max=Const.size*Const.size;
        for(int i=0;i<Const.bombs;i++)
        {
            int k=random.nextInt(max);
            for(int j=0;j<i;j++)
            {
                if(k==bombs[j])
                {
                    k=random.nextInt(max);
                    j=0;
                }
            }
            bombs[i]=k;
        }
    }
    
    public void generateValues()
    {
        values=new int[Const.size][Const.size];
        for(int i=0;i<bombs.length;i++)
        {
            values[bombs[i]%Const.size][bombs[i]/Const.size]=-1;
        }
        for(int y=0;y<Const.size;y++)
        {
            for(int x=0;x<Const.size;x++)
            {
                if(values[x][y]!=-1)
                {
                    values[x][y]=val(x,y);
                }
            }
        }
    }
    
    public int val(int x, int y)
    {
        int val=0;
        if(x>0&&y>0)
        {
            if(values[x-1][y-1]==-1)
            {
                ++val;
            }
        }
        if(y>0)
        {
            if(values[x][y-1]==-1)
            {
                ++val;
            }
        }
        if(x<Const.size-1&&y>0)
        {
            if(values[x+1][y-1]==-1)
            {
                ++val;
            }
        }
        if(x>0)
        {
            if(values[x-1][y]==-1)
            {
                ++val;
            }
        }
        if(values[x][y]==-1)
        {
                ++val;
        }
        if(x<Const.size-1)
        {
            if(values[x+1][y]==-1)
            {
                ++val;
            }
        }
        if(x>0&& y<Const.size-1)
        {
            if(values[x-1][y+1]==-1)
            {
                ++val;
            }
        }
        if(y<Const.size-1)
        {
            if(values[x][y+1]==-1)
            {
                ++val;
            }
        }
        if(x<Const.size-1 && y<Const.size-1)
        {
            if(values[x+1][y+1]==-1)
            {
                ++val;
            }
        }
        return val;
    }
    
    public void setMap(int x, int y)
    {
        while(values[x][y]!=0)
        {
            generateBombs();
            generateValues();
        }
    }
}
