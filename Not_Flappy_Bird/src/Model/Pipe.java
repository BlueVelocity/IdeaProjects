package Model;

public class Pipe {
    private int x = 400;
    private int y = 0;
    int openingSize = 200;
    private int pipeWidth = 75;
    private int botOfTopPipe;

    public Pipe(int screenHeight) {
        this.botOfTopPipe = (int) (Math.random() * (screenHeight - openingSize - 50)) + 50;
    }

    public int[] pipeData() {
        int[] data = {x, y, this.pipeWidth, botOfTopPipe};
        return data;
    }

}
