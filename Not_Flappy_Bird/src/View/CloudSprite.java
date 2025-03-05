package View;

import javax.swing.*;
import java.awt.*;

public class CloudSprite extends JComponent {
    private int x;
    private int size;

    public CloudSprite(int x, int size) {
        this.x = x;
        this.size = size;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);

        g.fillRect(x, 100, this.size, this.size);
    }

}
