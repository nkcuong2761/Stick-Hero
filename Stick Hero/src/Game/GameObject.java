package Game;

import Game.Renderer.Renderer;
import Game.physics.BoxCollider;
import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    //Quan li doi tuong
    public static ArrayList<GameObject> objects = new ArrayList<>();

    public static <E extends GameObject> E recycle(Class<E> cls) {
        // 1. findInactive >> if found >> reset >> return
        // 2. if not found >> create new >> return
        E object = findInactive(cls);
        if (object != null) {
            object.reset();
            return object;
        }
        // cls = Player.class
        // cls.getConstructor().newInstance() ~ new Player()
        try {
            object = cls.getConstructor().newInstance();
            return object;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static <E extends GameObject> E findInactive(Class<E> cls) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (cls.isAssignableFrom(object.getClass()) && !object.active)
                return (E) object;
        }
        return null;
    }

    public static <E extends GameObject> E findIntersects(Class<E> cls, BoxCollider hitBox) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active
                    && object.hitBox!=null
                    && object.hitBox.intersects(hitBox)
                    && cls.isAssignableFrom(object.getClass()))  // kiem tra object co la 1 doi tuong thuoc class cls
                return (E) object;
        }
        return null;
    }

    public static void renderAll(Graphics g) {
//        System.out.println(objects.size());
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object.active)
                object.render(g);
        }
    }

    public static void runAll() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object=objects.get(i);
            if(object.active)
                object.run();
        }
    }

    public static void clearAll() {
        objects.clear();
    }

    //Dinh nghia doi tuong

    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;
    public BoxCollider hitBox; // = null
    public boolean active;
    public Vector2D anchor;

    public GameObject() {
        objects.add(this);
        position = new Vector2D();
        velocity = new Vector2D();
        active=true;
        anchor = new Vector2D(0.5,0.5);
    }

    public void render(Graphics g) {
        if (renderer!=null) {
            renderer.render(g, this);
        }
    }

    public void run() {
        position.add(velocity);
    }

    public void deactive() {
        active=false;
    }

    public void reset() {
        active =true;
    }
}