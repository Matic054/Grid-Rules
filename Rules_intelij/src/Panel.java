import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel
{
    public Panel()
    {
        this.setPreferredSize(new Dimension(1000,1000));
        this.setFocusable(true);
        this.setBackground(Color.WHITE);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 1; i < 1002; i+=1)
            for (int j = 1; j < 1002; j+=1)
            {
                if (Main.data[i][j] == 1)
                    g2d.setColor(Color.GRAY);
                else
                    g2d.setColor(Color.WHITE);
                g2d.fillRect(i-1, j-1, 1, 1);
            }

		/*    for (int i = 1; i < 100; i++)
				for (int j = 1; j < 100; j++)
					if (Main.data[i][j] == 1)
					{
						g2d.setColor(Color.GRAY);
						g2d.fillRect(i*10, j*10, 10, 10);
					}
					else
					{
						g2d.setColor(Color.WHITE);
						g2d.fillRect(i*10, j*10, 10, 10);
					}
		*/
    }
}
