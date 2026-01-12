package ui;
import javafx.application.Application;
import physics.Vector2D;
import simulation.Body;

public class Main {
    public static void main(String[] args) {

//        Vector2D p1 = new Vector2D(0,0);
//        Vector2D v1 = new Vector2D(2,2);
//        Vector2D a1 = new Vector2D(0,0);
//        Body test1 = new Body(10,p1,v1,a1);
//
//        Vector2D p2 = new Vector2D(100,0);
//        Vector2D v2 = new Vector2D(0,0);
//        Vector2D a2 = new Vector2D(0,0);
//        Body test2 = new Body(100,p2,v2,a2);
//
//        for (int i = 0; i<10;i++){
//            test1.applyGravity(test2);
//            test1.update();
//            System.out.println("krok "+(i+1)+": "+test1.position);
//        }

        Application.launch(SimulationUI.class);
    }
}