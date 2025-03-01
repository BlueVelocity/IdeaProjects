package Controller;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameLoop {
    private Toolkit toolKit = Toolkit.getDefaultToolkit();
    private Timer t;
    private boolean isStopped = true;

    public void start(Controller controller) {
        this.isStopped = false;

        t = new Timer();
        t.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {
                        controller.execFrame();
                        toolKit.sync();
                    }
                },
                100,
                (int)(1000/60)
        );
    };

    public void stop() {
        t.cancel();

        this.isStopped = true;
    }

    public boolean checkIfStopped() {
        return this.isStopped;
    }
}
