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
        bodies.add(new Body(10, new Vector2D(400,300), new Vector2D(0,2.3), new Vector2D(0,0)));
        bodies.add(new Body(10, new Vector2D(200,300), new Vector2D(0,-2.6), new Vector2D(0,0)));
        bodies.add(new Body(1000, new Vector2D(300,300), new Vector2D(0,0), new Vector2D(0,0)));

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

                for (int i = 0; i < bodies.size(); i++) {
                    Body b = bodies.get(i);

                    switch (i) {
                        case 0 -> gc.setFill(Color.YELLOW);
                        case 1 -> gc.setFill(Color.YELLOW);
                        case 2 -> gc.setFill(Color.WHITE);
                    }

                    gc.fillOval((int)b.position.x, (int)b.position.y, 15, 15);


                }

            }
        };

        timer.start();
    }

}
