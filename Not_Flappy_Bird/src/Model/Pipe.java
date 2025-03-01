package Model;

public class Pipe {
    private int x;
    private int topPipeBottomY;
    private int topBottomPipe;
    private int pipeWidth;
    private int pipeHeight;
    private int pipeSpeed;

    public Pipe(int pipeWidth, int screenWidth, int pipeSpeed, int pipeGap) {
        this.topPipeBottomY = (int) (Math.random() * (screenWidth - pipeGap - 50) + 50);
        this.topBottomPipe = this.topPipeBottomY + pipeGap;

        this.pipeHeight = screenWidth;
        this.x = screenWidth;
        this.pipeSpeed = pipeSpeed;
        this.pipeWidth = pipeWidth;
//        this.botOfTopPipe = (int) (Math.random() * (screenHeight - openingSize - 50)) + 50;
    }

    public int[] pipeData() {
        int[] data = {this.x, this.topPipeBottomY, this.topBottomPipe, this.pipeWidth, this.pipeHeight};
        return data;
    }

    public void slideLeft() {
        this.x -= this.pipeSpeed;
    }

}
