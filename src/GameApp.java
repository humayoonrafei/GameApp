import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;


import java.awt.*;
import java.awt.geom.Point2D;

import static javafx.scene.paint.Color.*;


//Class names always start with an upper-case letter
//Variable names always start with a lower-case letter
//Non-Constant identifiers use camel case
//Constant identifiers use upper snake case
//All code is neat and properly indented
//You are restricted to an 80-character width
public class GameApp extends Application {
    // The GameApp class sets up all keyboard event handlers
    // to invoke public methods in Game.
    private static final int APP_WIDTH = 400;
    private static final int APP_HEIGHT = 600;


    private Game Ng;


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Group gRoot = new Group();
        Pane root = new Pane();
        Scene scene = new Scene(root, APP_WIDTH, APP_HEIGHT);

        Helipad helipad = new Helipad();

        // key Listeners
        Ng = new Game();



        primaryStage.setScene(scene);
        primaryStage.setTitle("GameAPP");
        scene.setFill(BLACK);

        // THe Helipad is below

        root.getChildren().add(helipad);

        primaryStage.show();

    }
}



class Game extends Pane {
    //all game logic and object construction belong here
    // All of the Game rules are implemented in Game Class
    //state of the game and determines win/lose


}

class GameObject extends Group{
    //contains methods and fields that manage the
    // common aspects of all game objects .

}

//class Body extends GameObject{
//    public Body(){
//        super();
//        Ellipse body = new Ellipse();
//        body.setRadiusx(10);
//        body.setRadiusY(10);
//        body.setFill(MAGENTA);
//        add(Body);
//    }
//}
//class FireOval extends GameObject {
//    public FireOval (){
//        Body myBody =//
//
//        add(m)
//    }
//}
class cloud extends GameApp{
    // represents a cloud in the sky

    Circle cloudCircle = new Circle(6, DARKGRAY);// Todo Add it as childern to the root
    //groot.addchildern(cloudcircle)

}

class Helipad extends Node {
    // Represents the starting and ending location
    final private Point2D rec_location;

    final private int rectSize;
    final private int arcSize;

    double Helipad_Height = 30;
    double Helipad_Width = 40;

    public Helipad() {
        rectSize = 45;
        arcSize = 250;
        Rectangle Helipad = new Rectangle(Helipad_Width, Helipad_Height);
        Helipad.setX(((APP_WIDTH - Helipad_Height) / 2));
        Helipad.setY(APP_HEIGHT - Helipad_Height);
        rec_location = null;
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
        public Point getArcLocation () {
            return arc_location;
        }

        public int getArcSize () {
            return arcSize;
        }
    }


    class Helicopter extends GameApp {
        // most complex game object
        // a yellow circle with a line to the direction of helicopter
        // display the current fuel
        // THe Helipad is below


    }

    class PondAndCloud {

    }

    class pond extends GameApp {
        Circle pond = new Circle(4, BLUE);


    }

//class Helicopter {
//    private Point Location;
//    private int size ;
//    private int speed = 0;
//    private int heading = 0 ;
//    private final int MAX_SPEED = 10;
//    private final int MIN_SPEED = 0;
//    private int water =0;
//    private int fuelConsummationRate ; // equal it to the fuel;
//    private int newX;
//    private int newY;
//    private int eX;
//    private int eY;
//    private double angle;
//    private Point2D location;
//
//    public Helicopter(Helipad helipad) {
//
//        size = 50;
//        location = new Point(helipad.getArcLocation().getX() +
//                helipad.getArcSize() / 2 - size / 2 ,
//                helipad.getArcLocation().getY() +
//                        helipad.getArcSize() / 2 - size / 2 );
//
//    }
//
//
//
//
//
//
//
//
//
//}

    class Helipad {
        final private Point rec_location;
        final private Point arc_location;
        final private int rectSize;
        final private int arcSize;

        public Helipad() {
            rectSize = 300;
            arcSize = 250;
            rec_location = new Point(GameApp.APP_WIDTH/ 2 - rectSize / 2,
                    GameAPP.APP_HEIGHT - rectSize - rectSize / 2);

            arc_location = new Point( GameApp.APP_WIDTH- arcSize / 2,
                    Game.GameAPP.APP_HEIGHT - 425);
        }

        void draw(Graphics g) {
            g.setColor(GRAY);
            g.drawRect(rec_location.getX(),
                    rec_location.getY(),
                    rectSize,
                    rectSize,
                    5);

            g.drawArc((int) arc_location.getX(), (int) arc_location.getY(), arcSize, arcSize,
                    0, 360);
        }

        public Point getArcLocation() {
            return arc_location;
        }

        public int getArcSize() {
            return arcSize;
        }
    }

    // River Class
//


    // Fire class
//


    //Helicopter Class
//
    class Helicopter {
        private Point2D location;
        private int size;
        private int speed = 0;
        private int heading = 0;
        private final int MAX_SPEED = 10;
        private final int MIN_SPEED = 0;
        private int water = 0;
        private int fuelConsummationRate;   // //equal to fuel
        private int newX;
        private int newY;
        private int eX;
        private int eY;
        private double angle;

        //initialize the helicopter according to helipad location
        public Helicopter(Helipad helipad) {

            size = 50;
            location = new Point((int) (helipad.getArcLocation().getX() +
                    helipad.getArcSize() / 2 - size / 2), (int) (helipad.getArcLocation().getY() +
                    helipad.getArcSize() / 2 - size / 2));

        }


        //This method checks if the helicopter is on the helipad and
        // returns a boolean.
        //
        boolean helicopterIsOnHelipad(Helipad helipad) {

            boolean helicopterOnHelipad = false;

            if (location.getX() > helipad.getArcLocation().getX() &&
                    location.getX() < helipad.getArcLocation().getX() +
                            helipad.getArcSize() && location.getY() >
                    helipad.getArcLocation().getY() && location.getY() <
                    helipad.getArcLocation().getY() + helipad.getArcSize()) {

                helicopterOnHelipad = true;
            }
            return helicopterOnHelipad;
        }

        int getSpeed() {
            return speed;
        }

        int getFuelConsummationRate() {
            return fuelConsummationRate;
        }

        //change the helicopter speed, the MAX SPEED is 10 and MIN SPEED is 0.
        //
        void speedUp() {
            if (speed < MAX_SPEED)
                speed++;
        }

        void speedDown() {
            if (speed > MIN_SPEED)
                speed--;
        }

        //move the helicopter object and calculate the fuel consumption
        //
        void move() {
            double deltaX = Math.cos(
                    Math.toRadians(heading - 90)) * speed * 3;

            double deltaY = Math.sin(
                    Math.toRadians(heading - 90)) * speed * 3;

            newX = (int) (location.getX() + deltaX);
            newY = (int) (location.getY() + deltaY);
            location.setX(newX);
            location.setY(newY);
            fuelConsummationRate -= (speed * speed + 5);

            //THis is the code to for the Helicopter line after
            // hours of debugging at last it's complete.
            //
            angle = Math.toRadians(heading - 90);
            eX = (int) ((100) * Math.cos(angle));
            eY = (int) ((100) * Math.sin(angle));

        }

        //change the heading 15 degree to the Right
        //
        void turnRight() {

            if (heading < 345)
                heading += 15;

            else if (heading == 345)
                heading = 0;

            else {

                heading = heading - 360;
                heading = heading + 15;
            }
        }

        //change the heading 15 degree to the left
        //
        void turnLeft() {
            if (heading >= 15)
                heading -= 15;

            else {
                heading = heading - 15;
                heading = heading + 360;
            }





        }
    }
}


        //

