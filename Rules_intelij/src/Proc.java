import java.util.Random;

public class Proc extends Thread
{
    int startX,startY;
    Random r = new Random();
    public Proc(int startX,int startY)
    {
        this.startX = startX;
        this.startY = startY;
    }

    public void run()
    {
        for (int a = startX; a < startX+Main.chunk-1; a++)
        {
            for (int b = startY; b < startY+Main.chunk-1; b++)
            {
                if (Main.prev[a][b] == 1) {
                    if (num(a, b) % 2 == 0)
                        Main.data[a][b] = 1;
                }
                else {
                    if (num(a, b) % 2 == 1 || num(a, b) == 3)
                        Main.data[a][b] = 1;
                }
            }
        }
    }

    int num(int i, int j)
    {
        int cnt = 0;
        if (Main.prev[i][j] == 1) cnt++;
        if (Main.prev[i-1][j] == 1) cnt++;
        if (Main.prev[i][j-1] == 1) cnt++;
        if (Main.prev[i-1][j-1] == 1) cnt++;
        if (Main.prev[i+1][j] == 1) cnt++;
        if (Main.prev[i][j+1] == 1) cnt++;
        if (Main.prev[i+1][j+1] == 1) cnt++;
        if (Main.prev[i+1][j-1] == 1) cnt++;
        if (Main.prev[i-1][j+1] == 1) cnt++;
        return cnt;
    }
    /*
        ZANIMIVA PRAVILA:
         if (Main.prev[a][b] == 1 )
                {
                    if (num(a,b) % 2 == 0)
                        Main.data[a][b] = 1;  ----->>> ZAPOLNI N*N KVADRAT V SREDINI
                }else {
                    if (num(a,b) % 2 == 1 || num(a,b) == 3)
                        Main.data[a][b] = 1;
                }
     */
}
