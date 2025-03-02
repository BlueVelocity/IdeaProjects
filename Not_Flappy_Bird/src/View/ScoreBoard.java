package View;

import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JComponent {
    private int screenSize;
    private int score = 0;

    public ScoreBoard(int screenSize) {
        this.screenSize = screenSize;
    }

    private void drawTopCenteredString(String s, int w, Graphics g, int yBias) {
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s)) / 2;
        g.drawString(s, x, yBias);
    }

    public void paint(Graphics g) {
        int fontSize = 36;

        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.BOLD, fontSize));

        drawTopCenteredString(Integer.toString(this.score), screenSize, g, 10 + fontSize);
    }

    public void setScore(int score) {
        this.score = score;
    }
}
