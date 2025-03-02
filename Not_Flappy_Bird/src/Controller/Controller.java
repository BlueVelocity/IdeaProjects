package Controller;

import View.View;
import Model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    GameSettings gameSettings = new GameSettings();
    Model model = new Model(gameSettings);
    View view = new View("Not Flappy Bird", gameSettings.getScreenSize(), gameSettings.getInstructions());
    GameLoop gameLoop = new GameLoop();
    private boolean isRunning = false;

    public Controller() {
        this.view.updatePlayer(model.getPlayerData());
        this.createPipe();

        this.view.addKeyListener(this);
    }

    private void playerJump() {
        this.model.playerJump();
        this.view.updatePlayer(model.getPlayerData());
    }

    private void playerFall() {
        this.model.playerFall();
        this.view.updatePlayer(model.getPlayerData());
    }

    private void checkPlayerScore() {
        this.model.checkIfScored();
        this.view.setScore(this.model.getScore());
    }

    private void createPipe() {
        this.model.createPipe();
        this.view.loadPipes(model.getPipeData());
    }

    private boolean checkCollision() {
        return model.checkCollision();
    }

    private void slidePipes() {
        this.model.slidePipes();
        this.view.loadPipes(model.getPipeData());
    }

    public void execFrame() {
        if (this.checkCollision()) {
            this.gameOver();
        } else {
            this.playerFall();
            this.checkPlayerScore();
            this.slidePipes();
            this.view.render();
        }
    }

    public void start() {
        this.gameLoop.start(this);
    }

    private void stop() {
        this.gameLoop.stop();
    }

    private void gameOver() {
        this.view.gameOver();
        this.view.render();
        this.stop();
    }

    private void resetGame() {
        this.stop();
        this.model = new Model(this.gameSettings);
        this.view.updatePlayer(model.getPlayerData());
        this.createPipe();
        this.view.displayPressToStart(true);
        this.view.restart();
        this.view.render();
        this.isRunning = false;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == 'p') {
            if (this.gameLoop.checkIfStopped()) {
                this.start();
            } else {
                this.stop();
            }
        } else if (keyEvent.getKeyChar() == 'r') {
            this.resetGame();
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
            if (this.isRunning == false) {
                this.view.displayPressToStart(false);
                this.playerJump();
                this.start();
                this.isRunning = true;
            } else {
                this.playerJump();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}