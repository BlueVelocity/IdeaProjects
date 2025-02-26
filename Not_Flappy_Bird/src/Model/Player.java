package Model;

public class Player {
    private int x = 100;
    private int y = 250;
    private int size = 30;
    private int counter;

    public int[] playerData() {
        int[] data = {x, y, size};
        return data;
    }

    private void moveUp(int pixels) {
        this.y -= pixels;
    }

    private void moveDown(int pixels) {
        this.y += pixels;
    }

    public void jump() {
        this.counter = 50;
    }

    public void fall() {
        if (this.counter > 0) {
            this.moveUp(2);
            this.counter -= 2;
        } else {
            this.moveDown(2);
        }
    }

}
