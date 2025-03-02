package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JFrame {
    Color backgroundColor = new Color(100, 180, 250);
    PlayerSprite playerSprite;
    ArrayList<PipeSprite> pipeSprites;
    ScoreBoard scoreBoard;
    Instructions instructions;
    GameOverScreen gameOverScreen;
    boolean gameOver = false;
    private final JPanel gamePanel;

    public View(String title, int screenSize, String[] instructionList) {
        super(title);

        gamePanel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(backgroundColor);
                g.fillRect(0, 0, getWidth(), getHeight());
                
                if (pipeSprites != null) {
                    for (PipeSprite pipe : pipeSprites) {
                        pipe.paint(g);
                    }
                }

                if (playerSprite != null) {
                    playerSprite.paint(g);
                }

                scoreBoard.paint(g);
                instructions.paint(g);

                if (gameOver) {
                    gameOverScreen.paint(g);
                }

            }
        };

        gamePanel.setBackground(backgroundColor);

        this.scoreBoard = new ScoreBoard(screenSize);
        instructions = new Instructions(screenSize, instructionList);
        this.gameOverScreen = new GameOverScreen(screenSize);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(screenSize, screenSize);
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
            this.playerSprite = new PlayerSprite(playerData[0], playerData[1], playerData[2]);
        } else {
            this.playerSprite.updateYCoord(playerData[1]);
        }
    }

    public void loadPipes(int[][] pipeData) {
        this.pipeSprites = new ArrayList<PipeSprite>();

        for (int[] pipe : pipeData) {
            PipeSprite pipeSprite = new PipeSprite(pipe[0], pipe[1], pipe[2], pipe[3], pipe[4]);
            this.pipeSprites.add(pipeSprite);
        }
    }

    public void setScore(int score) {
        this.scoreBoard.setScore(score);
    }

    public void gameOver() {
        this.gameOver = true;
    }

    public void restart() {
        this.gameOver = false;
    }

}
