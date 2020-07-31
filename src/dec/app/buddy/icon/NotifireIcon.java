package dec.app.buddy.icon;

public class NotifireIcon implements Icon {

    @Override
    public void act() {
        System.out.println("NOTIFIRE PRESSED");
    }

    @Override
    public String getImagePath() {
        return "res/notifire-icon.png";
    }
}