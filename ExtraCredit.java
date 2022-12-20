/*Algorithm
 * 1.Create an array containing circles.
 * 2.Create a scene to display the circles.
 * 3.Create 15 new circles.
 * 4.If a circle is overlapping another, make both pruple
 * 5.Circles not overlapping are set to black
 * 6.Display all circles
 */
//-----------------------------------------------------------------
// Author(s): Daniel Lubin
// Date of Last Modification: 12/13/2022
// Course: CS111B 
// Instructor: C. Conner 
// Assignment # Extra Credit
// File Name: ExtraCredit.java
// A program that dispalys 15 random circles dispalyed in black if not overlapping and purple if overlapping.
//-----------------------------------------------------------------
import java.util.Random;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ExtraCredit extends Application {
    public static void main(String[] args) {

    launch(args);
    }

    private Pane root;
    private Circle circ;
    private boolean overlapping = false;
    private ArrayList<Circle> circles;

    @Override
    public void start(Stage primaryStage) {

        /*Create a new arraylist containting Circles */
        circles = new ArrayList<Circle>();
        Random randomNum = new Random();

        /*Creates new Pane and sets window size. */
        int windowWidth = 500;
        int windowHeight = 500;
        root = new Pane();
        Scene scene = new Scene(root, windowWidth, windowHeight);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle Overlap");
        primaryStage.show();

        /*Creates 15 new circles. */
        for (int i = 0; i < 15; i++) {

            /*Creates a new circle with given random dimensions */
            circ = new Circle();
            int radius = randomNum.nextInt(56);
            int centerX = randomNum.nextInt(windowWidth - 2 * radius) + radius;
            int centerY = randomNum.nextInt(windowHeight - 2 * radius) + radius;
            circ.setCenterX(centerX);
            circ.setCenterY(centerY);
            circ.setRadius(radius);
            circles.add(circ);
            overlapping = false;

            /*for each of the new circles, checks if they are overlapping. */
            for (int j = 0; j < i; j++) {

            double x2 = circles.get(j).getCenterX();
            double dx = x2 - centerX;
            double y2 = circles.get(j).getCenterY();
            double dy = y2 - centerY;
            double r2 = circles.get(j).getRadius();

            /*Distance between circles */
            double distance = Math.sqrt((dx * dx) + (dy * dy));

            /*Checks to see if circle is overlapping*/
            if (distance <= (radius + r2)) {

                 /*If overlapping, sets color to transparent purple.*/
                 Paint c = new Color(0, 0, 1.0, 0.3);
                overlapping = true;
                circles.get(i).setFill(c);
                /*Changes color of the circle that it is overlapping with.*/
                circles.get(j).setFill(c);
            }
        }   
            if (!overlapping) {

                /*Sets the color of the circle to black if it is not overlapping. */
                circles.get(i).setFill(Color.BLACK);
            }
    }
        /*Display all of the cirles in the arraylist.*/
        root.getChildren().addAll(circles);
    }
}

