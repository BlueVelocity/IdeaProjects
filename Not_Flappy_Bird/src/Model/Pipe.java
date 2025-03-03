package Model;

public class Pipe {
    private int x;
    private int bottomTopPipe;
    private int topBottomPipe;
    private int pipeWidth;
    private int pipeHeight;
    private int pipeSpeed;

    public Pipe(int pipeWidth, int screenHeight, int pipeSpeed, int pipeGap) {
        int pipeMargin = (int) (screenHeight * (0.1));
        this.bottomTopPipe = (int) (pipeMargin + (Math.random() * (screenHeight - pipeGap - pipeMargin * 2)));
        this.topBottomPipe = this.bottomTopPipe + pipeGap;

        this.pipeHeight = screenHeight;
        this.x = screenHeight;
        this.pipeSpeed = pipeSpeed;
        this.pipeWidth = pipeWidth;
    }

    public int[] getPipeData() {
        return new int[]{this.x, this.bottomTopPipe, this.topBottomPipe, this.pipeWidth, this.pipeHeight};
    }

    public int[] getCornerCoordinates() {
        return new int[]{this.x, this.x + this.pipeWidth, this.bottomTopPipe, this.topBottomPipe};
    }

    public void slideLeft() {
        this.x -= this.pipeSpeed;
    }

}
