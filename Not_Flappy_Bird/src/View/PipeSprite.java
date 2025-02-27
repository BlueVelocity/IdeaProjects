package View;

import javax.swing.*;
import java.awt.*;

public class PipeSprite extends JComponent {
    private int x = 400;
    private int y = 0;
    int openingSize = 200;
    private int pipeWidth = 75;
    private int botOfTopPipe;

    public PipeSprite(int x, int y, int width, int height) {

    }

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(this.x, this.y, this.pipeWidth, this.botOfTopPipe);
    }

}
