package Model;

public class Pipe {
    private int x = 400;
    private int y = 0;
    private int pipeWidth = 75;
    private int pipeHeight = 600;
    private int pipeSpeed;

    public Pipe(int screenHeight, int pipeSpeed) {
        this.pipeHeight = screenHeight;
        this.pipeSpeed = pipeSpeed;
//        this.botOfTopPipe = (int) (Math.random() * (screenHeight - openingSize - 50)) + 50;
    }

    public int[] pipeData() {
        int[] data = {x, y, this.pipeWidth, this.pipeHeight};
        return data;
    }

    public void slideLeft() {
        this.x -= this.pipeSpeed;
    }

}
