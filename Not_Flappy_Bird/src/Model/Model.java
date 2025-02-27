package Model;

import Controller.GameSettings;

import java.util.ArrayList;

public class Model {
    private GameSettings gameSettings;
    private Player player = new Player();
    private ArrayList<Pipe> pipes = new ArrayList<Pipe>();

    public Model(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    public int[] getPlayerData() {
        return this.player.playerData();
    }

    public void playerJump() {
        this.player.jump();
    }

    public void playerFall() {
        this.player.fall();
    }

    public int[][] getPipeData() {
        int[][] pipeData = new int[pipes.size()][4];

        for (int i = 0; i < pipes.size(); i++) {
            pipeData[i] = pipes.get(i).pipeData();
        }

        return pipeData;
    }

    public void createPipe() {
        this.pipes.add(new Pipe(gameSettings.getScreenSize()));
    }

    public void slidePipes() {
        for (Pipe pipe : this.pipes) {
            pipe.slideLeft();
        }
    }
}
