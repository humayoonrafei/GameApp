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
import java.util.Random;

import static javafx.scene.paint.Color.*;


//Class names always start with an upper-case letter
//Variable names always start with a lower-case letter
//Non-Constant identifiers use camel case
//Constant identifiers use upper snake case
//All code is neat and properly indented
//You are restricted to an 80-character width
public class GameApp extends Application {

    private Game Ng;


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Group gRoot = new Group();
        //Pane root = new Pane();
        Ng = new Game();
        Scene root = new Scene(Ng, 400, 600);
        //root.setFill(BLACK);


        // key Listeners


        //root.getChildren().add(Ng);

        primaryStage.setScene(root);
        primaryStage.setTitle("GameAPP");
        primaryStage.show();

    }
}



class Game extends Pane {
    //all game logic and object construction belong here
    // All of the Game rules are implemented in Game Class
    //state of the game and determines win/lose
    public Game() {
        // setting Helipad on the screen
        Helipad helipad = new Helipad();
        //-- seting Cloud
        Cloud cloud = new Cloud();
        this.getChildren().add(helipad);
        helipad.setTranslateY(helipad.getAPP_HEIGHT()- helipad.Helipad_Height);
        helipad.setTranslateX(((helipad.getAPP_WIDTH()- helipad.Helipad_Width)/2));

        //-- Random Location for Cloud

        Random random = new Random();
        int ranX = random.nextInt((cloud.getAPP_HEIGHT()-1)); // random value from 0 to width
        int ranY = random.nextInt(cloud.getAPP_WIDTH()-1);
        cloud.setTranslateY(ranY);
        cloud.setTranslateX(ranX);

        // --setting Pond
        Pond pond = new Pond() ;
        pond.setTranslateX(ranX+4);
        pond.setTranslateX(ranY+2);


        this.getChildren().add(pond);


        // Adding cloud to the childern
        this.getChildren().add(cloud);
    }

}

class GameObject extends Group{
    //contains methods and fields that manage the
    // common aspects of all game objects .


    // The GameApp class sets up all keyboard event handlers
    // to invoke public methods in Game.
    private  int APP_WIDTH = 400;
    public int getAPP_WIDTH() {
        return APP_WIDTH;
    }


    private   int APP_HEIGHT = 600;
    public int getAPP_HEIGHT() {
        return APP_HEIGHT;
    }



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
class Cloud extends GameObject{
    // represents a cloud in the sky
    public Cloud() {
        Circle cloudCircle = new Circle(50, DIMGRAY);
        int cloudRadius =50;
        cloudCircle.setRadius(cloudRadius);// Todo Add it as childern to the root
        this.getChildren().add(cloudCircle);
    }
}

class Helipad extends GameObject {
    // Represents the starting and ending location


    double Helipad_Height = 30;
    double Helipad_Width = 40;

    public Helipad() {

        Rectangle Helipad = new Rectangle(Helipad_Width, Helipad_Height);
//        Helipad.setX(((getAPP_WIDTH() / 2) - Helipad_Width));
//        Helipad.setY(getAPP_HEIGHT() - Helipad_Height);
        Helipad.setStroke(WHITE);
        Helipad.setFill(ORANGE);

        Circle circle_Helipad = new Circle((Helipad_Width/2)-6);
        //circle_Helipad.setRadius();
        circle_Helipad.setFill(DARKGRAY);

        circle_Helipad.setTranslateX(Helipad_Width/2);
        circle_Helipad.setTranslateY(Helipad_Height/2);

        this.getChildren().add(Helipad);
        this.getChildren().add(circle_Helipad);

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

    class Pond extends GameObject {

        public Pond() {
            Circle pondCircle = new Circle(50,LIGHTBLUE);
            int pondRadius =50;
            pondCircle.setRadius(pondRadius);// Todo Add it as childern to the root
            this.getChildren().add(pondCircle);
        }


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

//    /
//
    // River Class
//


    // Fire class
//


    //Helicopter Class
//
//    class Helicopter {
//        private Point2D location;
//        private int size;
//        private int speed = 0;
//        private int heading = 0;
//        private final int MAX_SPEED = 10;
//        private final int MIN_SPEED = 0;
//        private int water = 0;
//        private int fuelConsummationRate;   // //equal to fuel
//        private int newX;
//        private int newY;
//        private int eX;
//        private int eY;
//        private double angle;
//
//        //initialize the helicopter according to helipad location
//        public Helicopter(Helipad helipad) {
//
//            size = 50;
//            location = new Point((int) (helipad.getArcLocation().getX() +
//                    helipad.getArcSize() / 2 - size / 2), (int) (helipad.getArcLocation().getY() +
//                    helipad.getArcSize() / 2 - size / 2));
//
//        }
//
//
//        //This method checks if the helicopter is on the helipad and
//        // returns a boolean.
//        //
//        boolean helicopterIsOnHelipad(Helipad helipad) {
//
//            boolean helicopterOnHelipad = false;
//
//            if (location.getX() > helipad.getArcLocation().getX() &&
//                    location.getX() < helipad.getArcLocation().getX() +
//                            helipad.getArcSize() && location.getY() >
//                    helipad.getArcLocation().getY() && location.getY() <
//                    helipad.getArcLocation().getY() + helipad.getArcSize()) {
//
//                helicopterOnHelipad = true;
//            }
//            return helicopterOnHelipad;
//        }
//
//        int getSpeed() {
//            return speed;
//        }
//
//        int getFuelConsummationRate() {
//            return fuelConsummationRate;
//        }
//
//        //change the helicopter speed, the MAX SPEED is 10 and MIN SPEED is 0.
//        //
//        void speedUp() {
//            if (speed < MAX_SPEED)
//                speed++;
//        }
//
//        void speedDown() {
//            if (speed > MIN_SPEED)
//                speed--;
//        }
//
//        //move the helicopter object and calculate the fuel consumption
//        //
//        void move() {
//            double deltaX = Math.cos(
//                    Math.toRadians(heading - 90)) * speed * 3;
//
//            double deltaY = Math.sin(
//                    Math.toRadians(heading - 90)) * speed * 3;
//
//            newX = (int) (location.getX() + deltaX);
//            newY = (int) (location.getY() + deltaY);
//            location.setX(newX);
//            location.setY(newY);
//            fuelConsummationRate -= (speed * speed + 5);
//
//            //THis is the code to for the Helicopter line after
//            // hours of debugging at last it's complete.
//            //
//            angle = Math.toRadians(heading - 90);
//            eX = (int) ((100) * Math.cos(angle));
//            eY = (int) ((100) * Math.sin(angle));
//
//        }
//
//        //change the heading 15 degree to the Right
//        //
//        void turnRight() {
//
//            if (heading < 345)
//                heading += 15;
//
//            else if (heading == 345)
//                heading = 0;
//
//            else {
//
//                heading = heading - 360;
//                heading = heading + 15;
//            }
//        }
//
//        //change the heading 15 degree to the left
//        //
//        void turnLeft() {
//            if (heading >= 15)
//                heading -= 15;
//
//            else {
//                heading = heading - 15;
//                heading = heading + 360;
//            }
//
//
//
//
//
//        }
//    }

//

        //

