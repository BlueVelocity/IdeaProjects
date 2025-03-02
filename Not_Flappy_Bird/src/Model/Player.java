package Model;

public class Player {
    private final int x = 100;
    private int y = 250;
    private final int size = 30;
    private int counter;

    public int[] getPlayerData() {
        int[] data = {x, y, size};
        return data;
    }

    private void moveUp(int pixels) {
        if (this.y > 0) {
            this.y -= pixels;
        } else {
            this.counter = 0;
        }
    }

    private void moveDown(int pixels) {
        this.y += pixels;
    }

    public void jump() {
        this.counter = this.size * 3;
    }

    public void fall() {
        int velocity = 4;
        if (this.counter > 0) {
            this.moveUp(velocity);
            this.counter -= velocity;
        } else if (this.y < 600 - 60) {
            this.moveDown(velocity);
        }
    }

    public int[] getCornerCoordinates() {
        return new int[]{this.x, this.x + this.size, this.y, this.y + this.size};
    }
}