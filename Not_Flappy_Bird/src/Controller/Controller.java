package Controller;

import View.View;
import Model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    Model model = new Model();
    View view = new View("Not Flappy Bird");

    public Controller() {
        model.createPlayer();
        view.updatePlayer(model.getPlayerData());

        this.view.addKeyListener(this);
    }

   private void playerJump() {
        model.playerJump();
        view.updatePlayer(model.getPlayerData());
   }

   private void playerFall() {
        model.playerFall();
        view.updatePlayer((model.getPlayerData()));
   }

    public void execFrame() {
        this.playerFall();
        view.render();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
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
