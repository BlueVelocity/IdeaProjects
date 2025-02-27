package Model;

public class Player {
    private int x = 100;
    private int y = 250;
    private int size = 30;
    private int velocity = 4;
    private int counter;

    public int[] playerData() {
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
        this.counter = 75;
    }

    public void fall() {
        if (this.counter > 0) {
            this.moveUp(velocity);
            this.counter -= this.velocity;
        } else {
            this.moveDown(this.velocity);
        }
    }

}
