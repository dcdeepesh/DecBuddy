package dec.app.buddy.icon;

import dec.app.buddy.DecBuddy;

public class ShutdownIcon implements Icon {

    @Override
    public void act() {
        DecBuddy.shutdown();
    }

    @Override
    public String getImagePath() {
        return "res/shutdown-icon.png";
    }
}