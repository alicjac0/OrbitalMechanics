package ui;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import physics.Vector2D;
import simulation.Body;

import java.util.ArrayList;


public class SimulationUI extends Application {

    @Override
    public void start(Stage primaryStage){
        Canvas canvas = new Canvas(800,600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Group root = new Group(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Orbital Simulation by JavaFX");
        primaryStage.show();

        ArrayList<Body> bodies = new ArrayList<>();
        bodies.add(new Body(204, new Vector2D(451,300), new Vector2D(0,2), new Vector2D(0,0), Color.WHITE));
        bodies.add(new Body(203, new Vector2D(150,300), new Vector2D(0,-2.001), new Vector2D(0,0), Color.BLUE));
        bodies.add(new Body(1000, new Vector2D(300,300), new Vector2D(0,0.01), new Vector2D(0,0), Color.YELLOW));

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {

                gc.setFill(Color.BLACK);
                gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());

                for(Body b : bodies){
                    b.acceleration = new Vector2D(0,0);

                    for (Body other : bodies) {
                        if (b != other) {
                            b.applyGravity(other);
                        }
                    }

                }

                for (Body b : bodies) {
                    b.update();
                }

                for (Body b : bodies) {
                    gc.setFill(b.color);

                    int size = b.getDrawSize();

                    gc.fillOval(
                            (int) b.position.x - size / 2,
                            (int) b.position.y - size / 2,
                            size,
                            size
                    );
                }

            }
        };

        timer.start();
    }

}
