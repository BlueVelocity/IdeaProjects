package Model;

public class Player {
    private int x = 100;
    private int y = 250;
    private int size = 30;
    private int peak;

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
        this.moveUp(50);
    }

    public void fall() {
        this.moveDown(2);
    }

    private void setPeak() {
        this.peak = this.y + 50;
    }

}
