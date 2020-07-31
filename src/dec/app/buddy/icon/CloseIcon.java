package dec.app.buddy.icon;

import dec.app.buddy.DecBuddy;

public class CloseIcon implements Icon {

    @Override
    public String getImagePath() {
        return "res/close-icon.png";
    }

    @Override
    public void act() {
        DecBuddy.close();
    }
}