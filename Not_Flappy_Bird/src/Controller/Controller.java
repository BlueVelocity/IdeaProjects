package Controller;

import View.View;
import Model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    GameSettings gameSettings = new GameSettings();
    Model model = new Model(gameSettings);
    View view = new View("Not Flappy Bird", gameSettings.getScreenWidth());
    GameLoop gameLoop = new GameLoop();

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

    private void slidePipes() {
        model.slidePipes();
        view.loadPipes(model.getPipeData());
    }

    public void execFrame() {
        this.playerFall();
        this.slidePipes();
        view.render();
    }

    public void start() {
        this.gameLoop.start(this);
    }

    private void pause() {
        this.gameLoop.stop();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == 'p') {
            if (this.gameLoop.checkIfPaused()) {
                this.start();
            } else {
                this.pause();
            }
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
