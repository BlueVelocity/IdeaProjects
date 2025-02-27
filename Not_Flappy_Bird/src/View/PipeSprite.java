package View;

import java.awt.*;

public class PipeSprite {
    private int x;
    private int y;
    private int width;
    private int height;

    public PipeSprite(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

}
