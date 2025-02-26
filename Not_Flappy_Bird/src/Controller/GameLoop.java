package Controller;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameLoop {
    Toolkit toolKit = Toolkit.getDefaultToolkit();
    Timer t = new Timer();

    public void start(Controller controller) {
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
}
