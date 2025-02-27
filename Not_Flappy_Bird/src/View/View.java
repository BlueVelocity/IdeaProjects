package View;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    Color backgroundColor = new Color(100, 180, 250);
    PlayerSprite playerSprite;

    public View(String title, int gameSize) {
        super(title);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(gameSize, gameSize);
        this.getContentPane().setBackground(backgroundColor);

        this.setFocusable(true);
        this.setVisible(true);
    }

    public void render() {
        this.updatePlayer();
        this.paintComponents(this.getGraphics());
    }

    public void updatePlayer(int[] playerData) {
        if (playerSprite == null) {
            playerSprite = new PlayerSprite(playerData[0], playerData[1], playerData[2]);
        } else {
            playerSprite.updateYCoord(playerData[1]);
        }
    }

    private void updatePlayer() {
        if (playerSprite != null) {
            this.getContentPane().add(playerSprite);
        }
    }
}
