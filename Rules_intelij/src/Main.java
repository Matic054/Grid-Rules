import java.awt.Color;
import java.util.PriorityQueue;
import java.util.Random;

import javax.swing.JFrame;

public class Main
{
    static int[][] data = new int[1002][1002];
    static int [][] prev;
    static Random r;
    static int chunk = 500;
    public static void main(String[] args)
    {
        r = new Random();
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setSize(1000,1000);

        Panel p = new Panel();
        jf.add(p);

        initData();

        Proc[] cal = new Proc[4];
        while (true)
        {
       //     calculate();
            prev = data.clone();
            data = new int [1002][1002];
            cal[0] = new Proc(1, 1);
            cal[1] = new Proc(501, 1);
            cal[2] = new Proc(1, 501);
            cal[3] = new Proc(501, 501);
            for (int i = 0; i < 4; i++)
                cal[i].start();
            try {
                cal[0].join();cal[1].join();cal[2].join();cal[3].join();
            } catch (Exception e) {
                System.out.println("Ups");
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.repaint();
        }
    }

    static void initData()
    {
	  /*  for (int i = 1; i < 1001; i++)
        {
            data[i][501] = 1;
            data[501][i] = 1;
            data[i][1001-i] = 1;
            data[i][i] = 1;
        }*/
        for (int i = 451; i < 551; i++)
            for (int j = 451; j < 551; j++)
                data[i][j] = 1;
 /*       data[250][250] = 1;
        data[250][750] = 1;
        data[750][250] = 1;
        data[750][750] = 1;
        data[500][500] = 1;
      */
    }

	/*
	  if (prev[i][j] == 1 )
				{
					if (num(i,j,prev) % 2 == 1)
						data[i][j] = 1;
				}else {
					if (num(i,j,prev) >= 3 )
						data[i][j] = 1;
				}

		if (prev[i][j] == 1 )
				{
					if (num(i,j,prev) % 2 == 1)
						data[i][j] = 1;
				}else {
					if ((num(i,j,prev)) % 2 == 1 ali 0)
						data[i][j] = 1;
				}

		if (prev[i][j] == 1)
				{
					if (isPrim(numPrim(i,j,prev)))
						data[i][j] = 1;
				}else {
					if (isPrim(numPrim(i,j,prev)) || num(i,j,prev)  % 8 == 7)
						data[i][j] = 1;
				}

		if (prev[i][j] == 1 )
				{							ali 'ali' ali xor
					if (num(i,j,prev) % 3 == 1 && num(i,j,prev) % 2 == 1)
						data[i][j] = 1;
				}else {
					if ((num(i,j,prev)) % 3 == 1 && num(i,j,prev) % 2 == 1)
						data[i][j] = 1;
				}
	 */
}
