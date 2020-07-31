package dec.app.buddy.icon;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import dec.app.buddy.DecBuddy;

public interface Icon {
    default Image getImage() {
        try {
            return ImageIO
                .read(DecBuddy.class.getResourceAsStream("/" + getImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    void act();
    String getImagePath();
}