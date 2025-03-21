package Controller;

public class GameSettings {

    public int getScreenSize() {
        return 600;
    }

    public int getPipeRate() {
        return 300;
    }

    public int getPipeSpeed() {
        return 2;
    }

    public int getPipeWidth() {
        return 75;
    }

    public int getPipeGap() {
        return 200;
    }

    public int getCloudSpeed() {
        return 1;
    }

    public String[] getInstructions() {
        return new String[]{
                "Press SPACE to start!",
                "R: Restart",
                "P: Pause",
                "SPACE: Jump",
            };
    }

}
