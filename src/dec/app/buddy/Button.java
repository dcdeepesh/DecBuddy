package dec.app.buddy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;

import dec.app.buddy.icon.Icon;

public class Button extends JPanel {  
    private class ButtonComponent extends JComponent {
        private static final long serialVersionUID = 1L;
        private final Icon icon;
        private boolean mouseIn = false;
        private boolean mousePressed = false;

        public ButtonComponent(Icon icon) {
            this.icon = icon;
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent event) { 
                    mouseIn = true;
                    mousePressed = false;
                    Button.this.setBackground(R.HOVER_COLOR);
                    repaint();
                }
    
                @Override
                public void mouseExited(MouseEvent event) {
                    mouseIn = false;
                    mousePressed = false;
                    Button.this.setBackground(R.AMBIENT_COLOR);
                    repaint();
                }

                @Override
                public void mousePressed(MouseEvent event) {
                    mousePressed = true;
                    Button.this.setBackground(R.PRESSED_COLOR);
                    repaint();
                }
    
                @Override
                public void mouseReleased(MouseEvent event) {
                    mousePressed = false;
                    Button.this.setBackground(R.AMBIENT_COLOR);
                    repaint();
                }

                @Override
                public void mouseClicked(MouseEvent event) {
                    icon.act();
                }
            });
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            Image image = icon.getImage();
            Color bg;
            if (mousePressed) bg = R.PRESSED_COLOR;
            else if (mouseIn) bg = R.HOVER_COLOR;
            else bg = R.AMBIENT_COLOR;

            if (image != null)
                g2d.drawImage(image, 0, 0, R.BOX_SIDE, R.BOX_SIDE, bg, null);
            else
                g2d.drawString("no img", R.MARGIN, R.MARGIN);

            g2d.dispose();
        }
    }  

    private static final long serialVersionUID = -6981530811606541103L;

    public Button(Icon icon) {
        setBackground(R.AMBIENT_COLOR);
        setLayout(new GridLayout(1, 1, 0, 0));
        if (icon != null)
            add(this.new ButtonComponent(icon));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(R.BOX_SIDE, R.BOX_SIDE);
    }
}
