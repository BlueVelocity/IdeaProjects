package Controller;

import View.View;
import Model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    GameSettings gameSettings = new GameSettings();
    Model model = new Model(gameSettings);
    View view = new View("Not Flappy Bird", gameSettings.getScreenSize());
    GameLoop gameLoop = new GameLoop();
    boolean lost = false;

    public Controller() {
        view.updatePlayer(model.getPlayerData());
        this.createPipe();

        this.view.addKeyListener(this);
    }

    private void playerJump() {
        model.playerJump();
        view.updatePlayer(model.getPlayerData());
    }

    private void playerFall() {
        model.playerFall();
        view.updatePlayer(model.getPlayerData());
    }

    private void createPipe() {
        model.createPipe();
        view.loadPipes(model.getPipeData());
    }

    private boolean checkCollision() {
        return model.checkCollision();
    }

    private void slidePipes() {
        model.slidePipes();
        view.loadPipes(model.getPipeData());
    }

    public void execFrame() {
        if (this.checkCollision()) {
            this.gameOver();
        } else {
            this.playerFall();
            this.slidePipes();
            view.render();
        }
    }

    public void start() {
        this.gameLoop.start(this);
    }

    private void pause() {
        this.gameLoop.stop();
    }

    private void gameOver() {
        this.lost = true;
        this.gameLoop.stop();
    }

    private void resetGame() {
        this.model = new Model(this.gameSettings);
        this.createPipe();
        this.start();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == 'p') {
            if (this.gameLoop.checkIfPaused()) {
                this.start();
            } else {
                this.pause();
            }
        } else if (keyEvent.getKeyChar() == 'r') {
            this.resetGame();
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
            this.playerJump();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
