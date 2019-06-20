package Game;

public class Settings {
    //game
    public static final int GAME_WIDTH=360;
    public static final int GAME_HEIGHT=640;
    //player
    public static final int PLAYER_WIDTH=32;
    public static final int PLAYER_HEIGHT=48;
    public static final int PLAYER_X=40;
    public static final int PLAYER_Y=400;
    //wall
    public static final int WALL_X=15;
    public static final int WALL_Y=PLAYER_Y+PLAYER_HEIGHT/2-4;
    public static final int WALL_HEIGHT=GAME_HEIGHT-WALL_Y;
    //stick
    public  static final int STICK_WIDTH=4;
    
     public static final int COLUMN_HEIGHT = 150;
    public static final int COLUMN_TO_EDGE = 140;
}
