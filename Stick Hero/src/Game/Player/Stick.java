package Game.Player;

import Game.GameObject;
import Game.KeyEventPress;
import Game.Renderer.Renderer;
import Game.Settings;
import Game.physics.BoxCollider;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Stick extends GameObject {
    public int stickHeight;
    public int stickY;
    public boolean checkRelease;
    Rectangle rec;

    public Stick() {
//        renderer = new Renderer("assets/images/Sprite-0001.png");
        position.set(Settings.WALL_X, Settings.WALL_Y);
        hitBox = new BoxCollider(this, Settings.STICK_WIDTH, stickHeight);
        stickHeight=0;
        stickY=(int)hitBox.top();
        checkRelease=false;
        rec = new Rectangle((int)hitBox.left(), stickY, hitBox.width, stickHeight);
    }

    @Override
    public void run() {
        super.run();
        if(KeyEventPress.isSpaceJusRelease) {
            System.out.println(rec.getLocation());
            System.out.println(this.position);
            KeyEventPress.isSpaceJusRelease = false;
        }
    }

    @Override
    public void render(Graphics g){
        if(KeyEventPress.isStickPress) {
            stickHeight +=2;
            stickY-=2;
            g.setColor(Color.BLACK);
            g.fillRect((int)hitBox.left(), stickY, hitBox.width, stickHeight);
        }
        rec.setRect((int)hitBox.left(), stickY, hitBox.width, stickHeight);
        g.fillRect((int)hitBox.left(), stickY, hitBox.width, stickHeight);
    }
}