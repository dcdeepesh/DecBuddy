package dec.app.buddy.icon;

public class CloseIcon implements Icon {

    @Override
    public String getImagePath() {
        return "res/close-icon.png";
    }

    @Override
    public void act() {
        System.exit(0);
    }
}