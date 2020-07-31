package dec.app.buddy.icon;

public class DecbotIcon implements Icon {
    
    @Override
    public void act() {
        System.out.println("DECBOT PRESSED");
    }

    @Override
    public String getImagePath() {
        return "res/decbot-icon.png";
    }
}