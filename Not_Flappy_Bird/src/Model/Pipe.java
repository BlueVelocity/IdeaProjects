package Model;

public class Pipe {
    private int x;
    private int y = 0;
    private int pipeWidth;
    private int pipeHeight;
    private int pipeSpeed;

    public Pipe(int pipeWidth, int screenWidth, int pipeSpeed) {
        this.pipeHeight = screenWidth;
        this.x = screenWidth;
        this.pipeSpeed = pipeSpeed;
        this.pipeWidth = pipeWidth;
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
