package game;

import game.Player.Player;
import game.Player.Stick;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Player player;
    Background background;
    Wall wall;
    Stick stick;
    double fps;

    public GamePanel() {
        background = new Background();
        wall = new Wall();
        player = new Player();
        stick = new Stick();
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(0,0,Settings.GAME_WIDTH,Settings.GAME_HEIGHT);
        GameObject.renderAll(g);
    }

    public void runAll() {
        GameObject.runAll();
    }

    public void gameLoop() {
        long lastTime = 0;
        long delay = 1000/80;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime > delay) {
                fps=1000/(currentTime - lastTime);
                repaint(); // >>call paint()
                runAll();
                lastTime = currentTime;
            }
        }
    }
}