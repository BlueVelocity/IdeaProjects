package View;

import javax.swing.*;
import java.awt.*;

public class CloudSprite extends JComponent {
    private int x;
    private int y;
    private int size;

    public CloudSprite(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);

        g.fillOval(x, y, this.size, this.size);
        g.fillOval(x, y - 20, this.size, this.size);
        g.fillOval(x - 20, y + 10, this.size, this.size);
        g.fillOval(x - 25, y - 15, this.size, this.size);
        g.fillOval(x + 25, y + 5, this.size, this.size);
        g.fillOval(x + 30, y - 10, this.size, this.size);
        g.fillOval(x + 40, y - 20, this.size, this.size);
        g.fillOval(x - 40, y - 15, this.size, this.size);
    }

}
