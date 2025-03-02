package Model;

import Controller.GameSettings;

import java.util.ArrayList;

public class Model {
    private final GameSettings settings;
    private final Player player = new Player();
    private final ArrayList<Pipe> pipes = new ArrayList<Pipe>();
    private int newPipeDist;
    private int destroyPipeDist;
    private int score = 0;

    public Model(GameSettings settings) {
        this.settings = settings;
        this.newPipeDist = settings.getPipeRate();
        this.destroyPipeDist = settings.getScreenSize() + settings.getPipeWidth();
    }

    public int getScore() {
        return this.score;
    }

    public int[] getPlayerData() {
        return this.player.getPlayerData();
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
            pipeData[i] = pipes.get(i).getPipeData();
        }

        return pipeData;
    }

    public void createPipe() {
        this.pipes.add(new Pipe(this.settings.getPipeWidth(), this.settings.getScreenSize(), this.settings.getPipeSpeed(), this.settings.getPipeGap()));
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

    public boolean checkCollision() {
        int[] playerCorners = this.player.getCornerCoordinates();

        if (playerCorners[2] >= settings.getScreenSize() - 60) return true;

        for (Pipe pipe : this.pipes) {
            int[] pipeCorners = pipe.getCornerCoordinates();

            if ((playerCorners[1] > pipeCorners[0] && playerCorners[0] < pipeCorners[1])
            && (playerCorners[2] < pipeCorners[2] || playerCorners[3] > pipeCorners[3])) {
                return true;
            }
        }

        return false;
    }

    private int roundToNextEven(int num) {
        return num%2 == 0 ? num : num - 1;
    }

    //Checking against a round even number means that pipes velocity must be an even number (see GameSettings)
    public boolean checkIfScored() {
        for (Pipe pipe : this.pipes) {
            int[] pipeData = pipe.getPipeData();
            if (this.player.getPlayerData()[0] == this.roundToNextEven(pipeData[0] + pipeData[3])) {
                this.score++;
                return true;
            }
        }
        return false;
    }

}
