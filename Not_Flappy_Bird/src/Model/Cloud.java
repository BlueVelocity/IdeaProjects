package Model;

public class Cloud {
    private int x;
    private int cloudSpeed;
    private int size;

    public Cloud(int size, int speed, int startingX) {
        this.x = startingX;
        this.cloudSpeed = speed;
        this.size = size;
    }

    public int[] getCloudData() {
        return new int[]{this.x, this.size};
    }

    public void slideLeft() {
        this.x -= this.cloudSpeed;
    }

}
