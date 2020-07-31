package dec.app.buddy;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.imageio.ImageIO;

import dec.app.buddy.gui.MainPanel;

public class DecBuddy {
    private static MainPanel mainPanel;
    private static TrayIcon trayIcon;

    public static void main(String[] args) throws Exception {
        if (!SystemTray.isSupported()) {
            System.err.println("System tray not supported");
            System.exit(1);
        }

        trayIcon = new TrayIcon(
            ImageIO
                .read(DecBuddy.class.getResourceAsStream("/res/decbot-icon.png"))
                .getScaledInstance(16, 16, Image.SCALE_SMOOTH)
        );
        trayIcon.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event) {
                mainPanel.setVisible(!mainPanel.isVisible());
            }
        });
        trayIcon.setToolTip("DecBuddy");

        SystemTray.getSystemTray().add(trayIcon);

        mainPanel = new MainPanel();
        mainPanel.setVisible(true);
    }

    public static void shutdown() {
        mainPanel.dispose();
        SystemTray.getSystemTray().remove(trayIcon);
    }

    public static void close() {
        mainPanel.setVisible(false);
    }
}
