package View;

import javax.swing.*;
import java.awt.*;

public class Instructions extends JComponent {
    private final int screenSize;
    private final String[] instructions;
    private boolean displayPressToStart = true;

    public Instructions(int screenSize, String[] instructions) {
        this.screenSize = screenSize;
        this.instructions = instructions;
    }

    private void drawBottomRightString(String s, int w, Graphics g, int xMargin, int yMargin) {
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s));
        int y = (fm.getAscent() + (w - (fm.getAscent() + fm.getDescent())));
        g.drawString(s, x - xMargin, y - yMargin);
    }

    private void drawBottomLeftString(String s, int w, Graphics g, int xMargin, int yMargin) {
        FontMetrics fm = g.getFontMetrics();
        int x = 0;
        int y = (fm.getAscent() + (w - (fm.getAscent() + fm.getDescent())));
        g.drawString(s, x + xMargin, y - yMargin);
    }


    public void paint(Graphics g) {
        int fontSize = 16;
        int yOffset = 0;

        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.PLAIN, fontSize));

        for (int i = 1; i < this.instructions.length; i++) {
            drawBottomRightString(instructions[i], screenSize, g, 24, 48 + yOffset);
            yOffset += fontSize + 10;
        }

        if (this.displayPressToStart) drawBottomLeftString(this.instructions[0], screenSize, g, 12, 48);

    }

    public void displayPressToStart(boolean bool) {
        this.displayPressToStart = bool;
    }

}
