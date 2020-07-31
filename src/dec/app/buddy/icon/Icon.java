package dec.app.buddy.icon;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public interface Icon {
    default Image getImage() {
        try {
            return ImageIO.read(new File(getImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    void act();
    String getImagePath();
}