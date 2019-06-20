package game;

import java.awt.*;

public class Wall extends GameObject {
    public Wall() {
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(Settings.WALL_X, Settings.WALL_Y, 50, Settings.WALL_HEIGHT);
    }
}