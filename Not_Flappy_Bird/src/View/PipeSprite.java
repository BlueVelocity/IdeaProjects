package View;

import javax.swing.*;
import java.awt.*;

public class PipeSprite extends JComponent {
    private int x;
    private int width;
    private int totalHeight;
    private int topPipeBottomY;
    private int topBottomPipe;

    public PipeSprite(int x, int topPipeBottomY, int topBottomPipe, int width, int height) {
        this.x = x;
        this.width = width;
        this.totalHeight = height;
        this.topPipeBottomY = topPipeBottomY;
        this.topBottomPipe = topBottomPipe;
    }

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);

        int[] pTop = this.getTopPipeData();
        g.fillRect(pTop[0],pTop[1],pTop[2],pTop[3]);

        int[] pBot = this.getBottomPipeData();
        g.fillRect(pBot[0],pBot[1],pBot[2],pBot[3]);

    }

    private int[] getTopPipeData() {
        return new int[]{this.x, 0, this.width, this.topPipeBottomY};
    }

    private int[] getBottomPipeData() {
        return new int[]{this.x, this.topBottomPipe, this.width, this.totalHeight};
    }

}
