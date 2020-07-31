package dec.app.buddy;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JDialog;

import dec.app.buddy.gui.Frame;

public class DecBuddy {
    private static JDialog frame;
    private static TrayIcon trayIcon;

    public static void main(String[] args) throws Exception {
        if (!SystemTray.isSupported()) {
            System.err.println("System tray not supported");
            System.exit(1);
        }

        trayIcon = new TrayIcon(
            ImageIO
                .read(new File("res/decbot-icon.png"))
                .getScaledInstance(16, 16, Image.SCALE_SMOOTH)
        );
        trayIcon.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event) {
                frame.setVisible(!frame.isVisible());
            }
        });
        trayIcon.setToolTip("DecBuddy");

        SystemTray.getSystemTray().add(trayIcon);

        frame = new Frame();
        frame.setVisible(true);
    }

    public static void shutdown() {
        frame.dispose();
        SystemTray.getSystemTray().remove(trayIcon);
    }

    public static void close() {
        frame.setVisible(false);
    }
}
