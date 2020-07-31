package dec.app.buddy;

import java.awt.Color;

import dec.app.buddy.icon.CloseIcon;
import dec.app.buddy.icon.DecbotIcon;
import dec.app.buddy.icon.Icon;
import dec.app.buddy.icon.NotifireIcon;
import dec.app.buddy.icon.ShutdownIcon;

public class R {
    public static final int BOX_SIDE = 80;
    public static final int MARGIN = 8;

    public static final int WIDTH = 2;
    public static final int HEIGHT = 2;

    public static final Color AMBIENT_COLOR = new Color(18, 18, 18);
    public static final Color PRESSED_COLOR = AMBIENT_COLOR.brighter();
    public static final Color HOVER_COLOR = PRESSED_COLOR.brighter();

    public static final float OPACITY = 0.95f;
    
    public static final Icon[] ICONS = {
        new DecbotIcon(),
        new NotifireIcon(),
        new CloseIcon(),
        new ShutdownIcon()
    };
}