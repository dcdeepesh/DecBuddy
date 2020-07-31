package dec.app.buddy.icon;

public class ShutdownIcon implements Icon {

    @Override
    public void act() {
        System.out.println("SHUTDOWN SIGNAL");
    }

    @Override
    public String getImagePath() {
        return "res/shutdown-icon.png";
    }
}