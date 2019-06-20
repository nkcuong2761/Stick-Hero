package Game.Player;

import Game.GameObject;
import Game.KeyEventPress;
import Game.Renderer.Renderer;
import Game.Settings;
import Game.physics.BoxCollider;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Stick extends GameObject {
    public int stickHeight;
    public int stickY;
    public int stickX;
    public boolean checkRelease;
//    Rectangle2D rec;
    Graphics2D g2d;

    public Stick() {
//        renderer = new Renderer("assets/images/Sprite-0001.png");
        position.set(Settings.WALL_X+47, Settings.WALL_Y);
        hitBox = new BoxCollider(this, Settings.STICK_WIDTH, stickHeight);
        stickHeight=0;
        stickX=(int)hitBox.left();
        stickY=(int)hitBox.top();
        checkRelease=false;
    }

    @Override
    public void run() {
        super.run();
        if(KeyEventPress.isSpaceJusRelease) {
            Rectangle rectangle = new Rectangle(stickX, Settings.WALL_Y , stickHeight, hitBox.width);
//            AffineTransform old = g2d.getTransform();
            g2d.rotate(Math.PI/2);
            g2d.draw(rectangle);
//            g2d.setTransform(old);
            System.out.println(KeyEventPress.isSpaceJusRelease);
            KeyEventPress.isSpaceJusRelease = false;
        }

    }

    @Override
    public void render(Graphics g) {
        if(KeyEventPress.isStickPress) {
            stickHeight+=2;
            stickY-=2;
            g.setColor(Color.BLACK);
            g.fillRect(stickX, stickY, hitBox.width, stickHeight);
        }
//        rec.setRect((int)hitBox.left(), stickY, hitBox.width, stickHeight);
        Rectangle rectangle = new Rectangle(stickX, stickY, hitBox.width, stickHeight);
        g2d = (Graphics2D) g;
        g2d.draw(rectangle);
    }
}