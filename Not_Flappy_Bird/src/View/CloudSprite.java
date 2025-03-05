package View;

import javax.swing.*;
import java.awt.*;

public class CloudSprite extends JComponent {
    private int x;
    private int y;
    private int size;
    private int[] yCoordinates;

    public CloudSprite(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);

        g.fillOval(x, this.y , this.size, this.size);
        g.fillOval(x + 15, this.y + 10 , this.size, this.size);
        g.fillOval(x + 20, this.y, this.size, this.size);
        g.fillOval(x + 25, this.y - 10, this.size, this.size);
        g.fillOval(x + 30, this.y , this.size, this.size);
        g.fillOval(x + 35, this.y + 10, this.size, this.size);
        g.fillOval(x + 40, this.y - 10, this.size, this.size);
        g.fillOval(x + 55, this.y , this.size, this.size);
    }

}
