package View;

import javax.swing.*;
import java.awt.*;

public class PlayerSprite extends JComponent {
    int x;
    int y;
    int size;

    public PlayerSprite(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, size, size);
    }

    public void updateYCoord(int y) {
        this.y = y;
    }
}
