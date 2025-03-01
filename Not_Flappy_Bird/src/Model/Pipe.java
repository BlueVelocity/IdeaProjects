package Model;

public class Pipe {
    private int x;
    private int bottomTopPipe;
    private int topBottomPipe;
    private int pipeWidth;
    private int pipeHeight;
    private int pipeSpeed;

    public Pipe(int pipeWidth, int screenWidth, int pipeSpeed, int pipeGap) {
        this.bottomTopPipe = (int) (Math.random() * (screenWidth - pipeGap - 50));
        this.topBottomPipe = this.bottomTopPipe + pipeGap;

        this.pipeHeight = screenWidth;
        this.x = screenWidth;
        this.pipeSpeed = pipeSpeed;
        this.pipeWidth = pipeWidth;
//        this.botOfTopPipe = (int) (Math.random() * (screenHeight - openingSize - 50)) + 50;
    }

    public int[] pipeData() {
        return new int[]{this.x, this.bottomTopPipe, this.topBottomPipe, this.pipeWidth, this.pipeHeight};
    }

    public int[] getCornerCoordinates() {
        return new int[]{this.x, this.x + this.pipeWidth, this.bottomTopPipe, this.topBottomPipe};
    }

    public void slideLeft() {
        this.x -= this.pipeSpeed;
    }

}
