package Model;

import Controller.GameSettings;

import java.util.ArrayList;

public class Model {
    private GameSettings gameSettings;
    private Player player = new Player();
    private ArrayList<Pipe> pipes = new ArrayList<Pipe>();
    private int newPipeDist;
    private int destroyPipeDist;

    public Model(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
        this.newPipeDist = gameSettings.getPipeRate();
        this.destroyPipeDist = gameSettings.getScreenWidth() + gameSettings.getPipeWidth();
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
        this.pipes.add(new Pipe(this.gameSettings.getPipeWidth(), this.gameSettings.getScreenWidth(), this.gameSettings.getPipeSpeed()));
    }

    private void destroyPipe() {
        this.pipes.remove(0);
        System.out.println(this.pipes.size());
    }

    public void slidePipes() {
        this.newPipeDist -= this.gameSettings.getPipeSpeed();
        this.destroyPipeDist -= this.gameSettings.getPipeSpeed();

        if (this.destroyPipeDist <= 0) {
            this.destroyPipeDist = this.gameSettings.getPipeRate();
            this.destroyPipe();
        }

        if (this.newPipeDist <= 0) {
            this.newPipeDist = this.gameSettings.getPipeRate();
            this.createPipe();
        }

        for (Pipe pipe : this.pipes) {
            pipe.slideLeft();
        }
    }
}
