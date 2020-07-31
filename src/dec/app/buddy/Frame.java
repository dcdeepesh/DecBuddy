package dec.app.buddy;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
    private static final long serialVersionUID = -7579705443967106928L;

    public Frame() {
        setUndecorated(true);
        setOpacity(R.OPACITY);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // add the root JPanel
        JPanel rootPanel = new JPanel();
        rootPanel.setBackground(R.AMBIENT_COLOR);
        rootPanel.setLayout(new GridLayout(R.HEIGHT, R.WIDTH, R.MARGIN, R.MARGIN));
        rootPanel.setBorder(
            BorderFactory.createEmptyBorder(R.MARGIN, R.MARGIN, R.MARGIN, R.MARGIN)
        );

        int noOfIcons = R.HEIGHT * R.WIDTH;
        for (int i = 0; i < noOfIcons; i++)
            rootPanel.add(new Button(i < R.ICONS.length ? R.ICONS[i] : null));

        add(rootPanel);
        pack();

        // position it at bottom right
        GraphicsConfiguration gc = GraphicsEnvironment
            .getLocalGraphicsEnvironment()
            .getDefaultScreenDevice()
            .getDefaultConfiguration();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenDimen = toolkit.getScreenSize();
        Insets screenInsets = toolkit.getScreenInsets(gc);

        int x2 = screenDimen.width - screenInsets.right;
        int y2 = screenDimen.height - screenInsets.bottom;
        int x1 = x2 - getWidth();
        int y1 = y2 - getHeight();
        setLocation(new Point(x1, y1));
    }
}