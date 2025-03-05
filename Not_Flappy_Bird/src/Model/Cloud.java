package Model;

public class Cloud {
    private int x;
    private int y;
    private int cloudSpeed;
    private int size;

    public Cloud(int size, int speed, int screenWidth, int screenHeight) {
        this.x = screenWidth + 100;
        this.y = (int) (this.size + 50 + (Math.random() * (screenHeight * 0.2)));
        this.cloudSpeed = speed;
        this.size = size;
    }

    public int[] getCloudData() {
        return new int[]{this.x, this.y, this.size};
    }

    public void slideLeft() {
        this.x -= this.cloudSpeed;
    }

}
