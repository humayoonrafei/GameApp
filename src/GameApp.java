import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
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
        //Game class methods get called on key press for instance left arrow key calls Ng.heliMoveLeft()


        //root.getChildren().add(Ng);

        primaryStage.setScene(root);
        primaryStage.setTitle("GameAPP");
        primaryStage.show();

       root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()){
                    case LEFT:
                        Ng.HelicopterLeftTurn();
                        break;
                    case DOWN:
                        Ng.HelicopterMoveDown();
                        break;
                    case UP:
                        Ng.HelicopterMoveUp();
                        break;
                    case RIGHT:
                        Ng.HelicopterRightTurn();
                        break;
                }
            }
        });

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
    final static double APP_WIDTH = 400;

    final static double APP_HEIGHT = 600;

     int HELICOPTER_FUEL = 25000;
    Helicopter helicopter;

    public Game() {
        setScaleY(-1);
        // setting Helipad on the screen
        Helipad helipad = new Helipad();

        //-- seting Cloud
        Cloud cloud = new Cloud();
        this.getChildren().add(helipad);
        //-- Random Location for Cloud
        Random random = new Random();
//        /int ranX = (GameObject.APP_HEIGHT-1); // random value from 0 to width
//        int ranY = (cloud.getAPP_WIDTH()-1);
//        cloud.setTranslateY(ranY);
//        cloud.setTranslateX(ranX);
//
//        // --setting Pond
        Pond pond = new Pond();
//        pond.setTranslateX(ranX+4);
//        pond.setTranslateX(ranY+2);
        this.getChildren().add(pond);
        this.getChildren().add(cloud);

        helicopter = new Helicopter(helipad.myTranslation.getX(), helipad.myTranslation.getY());
        this.getChildren().add(helicopter);



        // Function for turning the Helicopter to the left


    }
    int speed = 4;
    int degreeLeft= 15;
    public void HelicopterLeftTurn() {

    //    double dy = speed*Math.sin(Math.toRadians(degreeLeft));
      //  double dx = speed*Math.cos(Math.toRadians(degreeLeft));
        helicopter.rotate(helicopter.getMyRotation()+degreeLeft);
     //   helicopter.setTranslateX(helicopter.getTranslateX()-dx);
     //   helicopter.setTranslateY(helicopter.getTranslateY()+dy);


     // helicopter.translate(helicopter.myTranslation.getX()-offset, helicopter.myTranslation.getY() );
   //     helicopter.translate(Math.cos(Math.toRadians(helicopter.myTranslation.getX())), Math.cos(Math.toRadians(helicopter.myTranslation.getY())) );
     //   ++degreeLeft;
    }
    int degreesRight = -15;
    public void HelicopterRightTurn() {

     //   double dy = speed*Math.sin(Math.toRadians(degreesRight));
     //  double dx = speed*Math.cos(Math.toRadians(degreesRight));
        helicopter.rotate(helicopter.getMyRotation()+degreesRight);
      //  helicopter.setTranslateX(helicopter.getTranslateX()+dx);
     // helicopter.setTranslateY(helicopter.getTranslateY()-dy);

//        --degrees;

//        helicopter.rotate(degrees);
//        helicopter.translate(helicopter.myTranslation.getX()+speed, helicopter.myTranslation.getY());
//        System.out.println("degrees "+degrees);
//        --degrees;
//        System.out.println("degrees"+degrees);
    }


    public void HelicopterMoveUp() {
    //    helicopter.translate(helicopter.myTranslation.getX(), helicopter.myTranslation.getY() + speed);
        double angle = helicopter.getMyRotation();
       double dy = speed*Math.sin(Math.toRadians(angle));
     double dx = speed*Math.cos(Math.toRadians(angle));

     helicopter.setTranslateX(helicopter.getTranslateX()-dx);
     helicopter.setTranslateY(helicopter.getTranslateY()+dy);
      //  helicopter.translate(helicopter.myTranslation.getX()+dx, helicopter.myTranslation.getY() + speed);

    }
    public void HelicopterMoveDown(){
        helicopter.translate(helicopter.myTranslation.getX(),helicopter.myTranslation.getY()-speed);
    }

///


    interface Updatable {
        void update();
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

    class GameObject extends Group implements Updatable {
        //contains methods and fields that manage the
        // common aspects of all game objects .


        // The GameApp class sets up all keyboard event handlers
        // to invoke public methods in Game.


        protected Translate myTranslation;
        protected Rotate myRotation;
        protected Scale myScale;

        public GameObject() {
            myTranslation = new Translate();
            myRotation = new Rotate();
            myScale = new Scale();
            this.getTransforms().addAll(myTranslation, myRotation, myScale);
        }

        public void rotate(double degrees) {
            myRotation.setAngle(degrees);
            myRotation.setPivotX(0);
            myRotation.setPivotY(0);
        }

        public void scale(double sx, double sy) {
            myScale.setX(sx);
            myScale.setY(sy);
        }

        public void translate(double tx, double ty) {
            myTranslation.setX(tx);
            myTranslation.setY(ty);
        }

        public double getMyRotation() {
            return myRotation.getAngle();
        }

        public void update() {
            for (Node n : getChildren()) {
                if (n instanceof Updatable)
                    ((Updatable) n).update();
            }
        }

        void add(Node node) {
            this.getChildren().add(node);
        }
    }


//Class Pond

//This class represents a pond or lake in the Central Valley.
// For this first version of the project,
// we will abstract the pond as a simple blue circle placed at random such that it does not intersect any other ground based object.

    class Pond extends GameObject {

        public Pond() {
            Circle pondCircle = new Circle(10);
            int pondRadius = 10;
            pondCircle.setRadius(pondRadius);// Todo Add it as childern to the root
            pondCircle.setFill(BLUE);
            this.getChildren().add(pondCircle);
        }


    }



    class Cloud extends GameObject {
        // represents a cloud in the sky
        public Cloud() {
            Circle cloudCircle = new Circle(50);
            int cloudRadius = 50;
            cloudCircle.setRadius(cloudRadius);// Todo Add it as childern to the root
            this.getChildren().add(cloudCircle);
        }
    }

    class Helipad extends GameObject {
        // Represents the starting and ending location


        double Helipad_Height = 80;
        double Helipad_Width = 80;

        double Helipad_Position = 100;

        public Helipad() {


            Rectangle Helipad = new Rectangle(Helipad_Width, Helipad_Height);

            Helipad.setStroke(GRAY);


            double Circle_Radius = 30;
            Circle circle_Helipad = new Circle((Circle_Radius));

            //circle_Helipad.setTranslateY(Helipad_Height/2);
            Helipad.setX((circle_Helipad.getCenterX() - Helipad.getWidth()) / 2);
            Helipad.setY((circle_Helipad.getCenterY() - Helipad.getHeight()) / 2);
            //circle_Helipad.setTranslateX((Helipad_Width)/2);
            //circle_Helipad.setRadius();
            circle_Helipad.setStroke(GRAY);
            translate(Game.APP_WIDTH / 2, Helipad_Height);


            //circle_Helipad.setTranslateX(Helipad.getTranslateX()+circle_Helipad.getRadius()+2);
            //circle_Helipad.setTranslateY(Helipad.getTranslateY()+circle_Helipad.getRadius());

            this.getChildren().add(Helipad);
            this.getChildren().add(circle_Helipad);

        }
    }

    class Helicopter extends GameObject {

        // most complex game object
        // a yellow circle with a line to the direction of helicopter
        // display the current fuel
        // public void rotateLeft() is when you do LEFT Arrow key
        //{ rotate(-15); }


        double Helicopeter_Radius = 10;

        public Helicopter(double x, double y) {


            Circle Helicoptercircle = new Circle(Helicopeter_Radius);
            Helicoptercircle.setFill(YELLOW);
            //Image helicopterImage = new Image("/Users/hqrafei/Documents/projects/GameApp/Pictures/Helicopter.png");

            //ImageView iv1 = new ImageView();
            //iv1.setImage(helicopterImage);


            this.getChildren().add(Helicoptercircle);

            // Helicoptercircle.setTranslateX(Game.APP_WIDTH/2);
            //Helicoptercircle.setTranslateY((Game.APP_HEIGHT-Helicopeter_Radius)/4.59);

            Line line = new Line();
            line.setStartX(Helicoptercircle.getTranslateX());
            line.setStartY(Helicoptercircle.getTranslateY());
            line.setEndX(Helicoptercircle.getTranslateX());
            line.setEndY((Helicoptercircle.getTranslateY() + 16));
            line.setStroke(YELLOW);
            line.setStrokeWidth(3);

            this.getChildren().add(line);


            translate(x, y); // moves Helicopter object by x and y
            System.out.println(x + " " + y);


            Text text = new Text(" ABC DE ");
            text.setStroke(YELLOW);
          //

            this.getChildren().add(text);



        }

        public void rotateLeft() {
            rotate(15);
        }

    }

    class PondAndCloud {

    }
}


