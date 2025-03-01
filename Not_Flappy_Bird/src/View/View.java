package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JFrame {
    Color backgroundColor = new Color(100, 180, 250);
    PlayerSprite playerSprite;
    ArrayList<PipeSprite> pipeSprites;
    private final JPanel gamePanel;

    public View(String title, int gameSize) {
        super(title);

        gamePanel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw background
                g.setColor(backgroundColor);
                g.fillRect(0, 0, getWidth(), getHeight());
                
                // Draw pipes
                if (pipeSprites != null) {
                    for (PipeSprite pipe : pipeSprites) {
                        pipe.paint(g);
                    }
                }
                
                // Draw player
                if (playerSprite != null) {
                    playerSprite.paint(g);
                }
            }
        };

        gamePanel.setBackground(backgroundColor);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(gameSize, gameSize);
        this.add(gamePanel);

        this.setFocusable(true);
        this.setVisible(true);
        this.setResizable(false);

    }

    public void render() {
        this.gamePanel.repaint();
    }

    public void updatePlayer(int[] playerData) {
        if (playerSprite == null) {
            playerSprite = new PlayerSprite(playerData[0], playerData[1], playerData[2]);
        } else {
            playerSprite.updateYCoord(playerData[1]);
        }
    }

    public void loadPipes(int[][] pipeData) {
        this.pipeSprites = new ArrayList<PipeSprite>();

        for (int[] pipe : pipeData) {
            PipeSprite pipeSprite = new PipeSprite(pipe[0], pipe[1], pipe[2], pipe[3], pipe[4]);
            this.pipeSprites.add(pipeSprite);
        }
    }

}
