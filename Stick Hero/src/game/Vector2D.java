package game;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D() {
        this(0,0);
    }

    public Vector2D(double x, double y) {
        this.x=x;
        this.y=y;
    }

    public void add(double x, double y) {
        this.x+=x;
        this.y+=y;
    }

    public void add(Vector2D other) {
        this.add(other.x,other.y);
    }

    public void substract(double x, double y) {
        this.x-=x;
        this.y-=y;
    }

    public void scale (double rate) {
        this.x*=rate;
        this.y*=rate;
    }

    public Vector2D clone() {
        return new Vector2D(x, y);
    }

    public void set(double x,double y) {
        this.x=x;
        this.y=y;
    }

    public double getLength() {
        return Math.sqrt(x*x+y*y);
    }

    public void setLength(double length) {
        double l=this.getLength();
        if(l!=0) {
            x = x / (l / length);
            y = y / (l / length);
        }
    }

    public double getAngle() {
        double a=Math.atan(y/x);
        return a;
    }

    public void setAngle(double angle) {
        double l= Math.sqrt(x*x+y*y);
        x=l*Math.cos(angle);
        y=l*Math.sin(angle);
    }

    @Override
    public String toString() {
        return "(x: " + x + ", y: " + y + ")";
    }

//    public static void main(String[] args) {
//        game.Vector2D v1 = new game.Vector2D(3,3);
//        System.out.println(v1.getLength());
//        System.out.println(v1.getAngle());
//        v1.setLength(10);
//        System.out.println(v1.getLength());
//        v1.setAngle(Math.PI / 6);
//        System.out.println(v1.getAngle());
//    }
}