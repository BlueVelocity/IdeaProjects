package View;

import javax.swing.*;
import java.awt.*;

public class GameOverScreen extends JComponent {
    private int screenSize;

    public GameOverScreen(int screenSize) {
        this.screenSize = screenSize;
    }

    private void drawCenteredString(String s, int w, int h, Graphics g, int yBias) {
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s)) / 2;
        int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
        g.drawString(s, x, y + yBias);
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("SansSerif", Font.BOLD, 48));

        drawCenteredString("GAME OVER", screenSize, screenSize, g, -40);

        g.setFont(new Font("SansSerif", Font.BOLD, 24));

        drawCenteredString("Press \"r\" to restart", screenSize, screenSize, g, 0);
    }

}
