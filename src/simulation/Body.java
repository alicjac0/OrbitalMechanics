package simulation;

import physics.Vector2D;

public class Body {
    public double mass;
    public Vector2D position;
    public Vector2D velocity;

    public Body(double mass, Vector2D position, Vector2D velocity){
        this.mass=mass;
        this.position=position;
        this.velocity= velocity;
    }
}
