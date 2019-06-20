package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setTitle("Stick Hero");
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_R)
                    KeyEventPress.isRPress = true;
                if(e.getKeyCode() == KeyEvent.VK_SPACE)
                    KeyEventPress.isStickPress = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_R)
                    KeyEventPress.isRPress = false;
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isStickPress = false;
                    KeyEventPress.isSpaceJusRelease = true;
                }
            }
        });

        GamePanel panel = new GamePanel();
        window.add(panel);
        panel.setPreferredSize(new Dimension(Settings.GAME_WIDTH,Settings.GAME_HEIGHT));
        window.pack();

        window.setVisible(true);

        panel.gameLoop(); // start game
    }
}

// alt + enter >> fix code
// (fn + ) shift + f6 >> rename
// ctrl + alt + l >> format code
// try catch >> sua code