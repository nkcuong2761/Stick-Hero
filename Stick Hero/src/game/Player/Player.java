package game.Player;

import game.GameObject;
import game.KeyEventPress;
import game.Renderer.Renderer;
import game.Settings;
import game.physics.BoxCollider;

public class Player extends GameObject {
    public Player() {
        renderer = new Renderer("assets/images/players");
        position.set(Settings.PLAYER_X, Settings.PLAYER_Y);
        hitBox = new BoxCollider(this, Settings.PLAYER_WIDTH, Settings.PLAYER_HEIGHT);
    }

//    @Override
//    public void run() {
//        super.run();
//    }
}