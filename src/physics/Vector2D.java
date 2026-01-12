package physics;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y){
        this.x=x;
        this.y=y;
    }

    public Vector2D add(Vector2D v){
        return new Vector2D(this.x+ v.x, this.y+v.y);
    }

    public Vector2D subtract(Vector2D v){
        return new Vector2D(this.x- v.x, this.y-v.y);
    }

    public Vector2D multiply(double scalar){
        return new Vector2D(this.x*scalar, this.y*scalar);
    }

    public double length(){
        return Math.sqrt(x*x + y*y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
