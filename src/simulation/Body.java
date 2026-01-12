package simulation;

import physics.Vector2D;

public class Body {
    public double mass;
    public Vector2D position;
    public Vector2D velocity;
    public Vector2D acceleration;

    public Body(double mass, Vector2D position, Vector2D velocity, Vector2D acceleration){
        this.mass=mass;
        this.position=position;
        this.velocity= velocity;
        this.acceleration = new Vector2D(0,0);
    }

    public void update(){
        velocity = velocity.add(acceleration);
        position = position.add(velocity);
    }

    public void applyGravity(Body other){
        Vector2D distanceVector;
        double distance;
        distanceVector = other.position.subtract(this.position);
        distance = distanceVector.length();

        if(distance == 0){
            return;
        }

        Vector2D direction;
        direction = distanceVector.multiply(1/distance);  // v / d = v * (1 / d)

        double strength = other.mass / (distance * distance);

        acceleration = direction.multiply(strength);



    }
}
