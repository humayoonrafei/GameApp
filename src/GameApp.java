import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;


import java.util.Random;

import static javafx.scene.paint.Color.*;
/**** To do for next time (Reminder on what to work )
 * 1 - working on helicopters
 * 2- adding text percentage  inside the cloud and pond
 */

//Class names always start with an upper-case letter
//Variable names always start with a lower-case letter
//Non-Constant identifiers use camel case
//Constant identifiers use upper snake case
//All code is neat and properly indented
//You are restricted to an 80-character width
///


/******
//Class GameApp*/
// At the highest level we have the class GameApp.
// This class extends the JavaFX Application class.
// The purpose of this class is to manage the high-level aspects of our application and setup and show the initial Scene for your application.
// The GameApp class sets up all keyboard event handlers to invoke public methods in Game.
/*******/
public class GameApp extends Application {

    private Game Ng;


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Group gRoot = new Group();
        //Pane root = new Pane();
        Ng = new Game();
        Scene root = new Scene(Ng, 400, 600);
        root.setFill(BLACK);


        // key Listeners


        //root.getChildren().add(Ng);

        primaryStage.setScene(root);
        primaryStage.setTitle("GameAPP");
        primaryStage.show();

    }
}
//Class Game
//
//For this first version all game logic and object construction belong in the Game class.
// All of the rules in our game are implemented in the Game.
// This class holds the state of the game and determines win/lose conditions and instantiates and links the other Game Objects.
// The Game does not know anything about where user input comes from or how it is generated.
// The Game class extends the JavaFX class Pane. This allows the Game class to be the container for all game objects.
// For this version of the game we will not have a separate game object collection. This may change in a future revision.
//At this stage we are not overly concerned that we are purely and
// properly implementing any particular application pattern, e.g., MVC. We do, however, want to start thinking about separation of concerns.
//The interaction of these classes is discussed further later in the document.
//


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

        Helicopter helicopter = new Helicopter();
        this.getChildren().add(helicopter);
    }

}



//Game Object Classes
//In addition to the classes described above you will have some additional classes that represent game objects.
// In this version of this project, you will build a simple hierarchy of game objects.
// Because we want to inherit the properties of JavaFX Node objects, our game object class will extend the JavaFX Group class.
// This alleviates us from having to setup a number of different properties that each object needs, for example, the object’s location in the world.
//Later in this document I will discuss the basics of object behaviors and private data, but for now,
// let’s jump into the various classes that will represent the game objects.

//Class GameObject

//The abstract GameObject class is the base of our object hierarchy.
// It contains methods and fields that manage the common aspects of all game objects in our program.
// Any state or behavior in this class should apply to all game object this. For example, the helicopter can move, while a pond cannot.
// Consequently, you would not include anything regarding movement in this class.

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


//Class Pond

//This class represents a pond or lake in the Central Valley.
// For this first version of the project,
// we will abstract the pond as a simple blue circle placed at random such that it does not intersect any other ground based object.

class Pond extends GameObject {

    public Pond() {
        Circle pondCircle = new Circle(10);
        int pondRadius =10;
        pondCircle.setRadius(pondRadius);// Todo Add it as childern to the root
        pondCircle.setFill(BLUE);
        this.getChildren().add(pondCircle);
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
        Circle cloudCircle = new Circle(50);
        int cloudRadius =50;
        cloudCircle.setRadius(cloudRadius);// Todo Add it as childern to the root
        this.getChildren().add(cloudCircle);
    }
}

class Helipad extends GameObject {
    // Represents the starting and ending location


    double Helipad_Height = 80;
    double Helipad_Width = 80;

    public Helipad() {

        Rectangle Helipad = new Rectangle(Helipad_Width, Helipad_Height);
//        Helipad.setX(((getAPP_WIDTH() / 2) - Helipad_Width));
//        Helipad.setY(getAPP_HEIGHT() - Helipad_Height);
        Helipad.setStroke(GRAY);

        Circle circle_Helipad = new Circle((Helipad_Width/2)-6);
        //circle_Helipad.setRadius();
        circle_Helipad.setStroke(GRAY);

        circle_Helipad.setTranslateX(Helipad_Width/2);
        circle_Helipad.setTranslateY(Helipad_Height/2);

        this.getChildren().add(Helipad);
        this.getChildren().add(circle_Helipad);

    }
}

    class Helicopter extends GameObject {
        // most complex game object
        // a yellow circle with a line to the direction of helicopter
        // display the current fuel
        // THe Helipad is below
        double Helicopeter_Radius = 10;

        public Helicopter(){
            Circle Helicoptercircle = new Circle(Helicopeter_Radius);
            Helicoptercircle.setFill(YELLOW);

            Arc Helicopternose = new Arc(34,3,2,3,4,5);
            Helicopternose.setFill(YELLOW);


            this.getChildren().add(Helicopternose);
            this.getChildren().add(Helicoptercircle);

            Helicoptercircle.setTranslateX(getAPP_WIDTH()/2);
            Helicoptercircle.setTranslateY(getAPP_HEIGHT()-Helicopeter_Radius);

        }


    }

    class PondAndCloud {

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

