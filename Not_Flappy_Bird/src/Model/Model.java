package Model;

public class Model {
    private Player player;

    public void createPlayer() {
        if (player == null) {
            player = new Player();
        }
    }

    public int[] getPlayerData() {
        return player.playerData();
    }

    public void playerJump() {
        player.jump();
    }
    public void playerFall() {
        player.fall();
    }
}
