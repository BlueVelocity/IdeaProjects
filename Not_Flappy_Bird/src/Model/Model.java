package Model;

import Controller.GameSettings;

import java.util.ArrayList;

public class Model {
    private GameSettings settings;
    private Player player = new Player();
    private ArrayList<Pipe> pipes = new ArrayList<Pipe>();
    private int newPipeDist;
    private int destroyPipeDist;

    public Model(GameSettings settings) {
        this.settings = settings;
        this.newPipeDist = settings.getPipeRate();
        this.destroyPipeDist = settings.getScreenWidth() + settings.getPipeWidth();
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
        int[][] pipeData = new int[pipes.size()][5];

        for (int i = 0; i < pipes.size(); i++) {
            pipeData[i] = pipes.get(i).pipeData();
        }

        return pipeData;
    }

    public void createPipe() {
        this.pipes.add(new Pipe(this.settings.getPipeWidth(), this.settings.getScreenWidth(), this.settings.getPipeSpeed(), this.settings.getPipeGap()));
    }

    private void destroyPipe() {
        this.pipes.remove(0);
    }

    public void slidePipes() {
        this.newPipeDist -= this.settings.getPipeSpeed();
        this.destroyPipeDist -= this.settings.getPipeSpeed();

        if (this.destroyPipeDist <= 0) {
            this.destroyPipeDist = this.settings.getPipeRate();
            this.destroyPipe();
        }

        if (this.newPipeDist <= 0) {
            this.newPipeDist = this.settings.getPipeRate();
            this.createPipe();
        }

        for (Pipe pipe : this.pipes) {
            pipe.slideLeft();
        }
    }
}
