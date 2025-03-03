package Model;

public class Player {
    private final int x = 100;
    private int y = 250;
    private final int size = 30;
    int velocity = 0;

    public int[] getPlayerData() {
        int[] data = {x, y, size};
        return data;
    }

    private void move(int pixels) {
        this.y += pixels;
    }

    public void jump() {
        this.velocity = -16;
    }

    public void fall() {

    if (this.y < 1) {
        this.velocity = 1;
    } else if (this.velocity < 8) {
        this.velocity += 1;
    }

    this.move(this.velocity);
    }

    public int[] getCornerCoordinates() {
        return new int[]{this.x, this.x + this.size, this.y, this.y + this.size};
    }
}