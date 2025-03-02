package View;

import javax.swing.*;
import java.awt.*;

public class Instructions extends JComponent {
    private int screenSize;
    private String[] instructions;

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

    public void paint(Graphics g) {
        int fontSize = 16;
        int yOffset = 0;

        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.PLAIN, fontSize));

        for (String instruction : this.instructions) {
            drawBottomRightString(instruction, screenSize, g, 12, 48 + yOffset);
            yOffset += fontSize + 10;
        }

    }

}
