import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


import java.awt.*;

import static javafx.scene.paint.Color.MAGENTA;
import static javafx.scene.paint.Color.WHITE;


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


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Group gRoot = new Group();
        Pane root = new Pane();
        Scene scene = new Scene(root,APP_WIDTH,APP_HEIGHT);




        primaryStage.setScene(scene);
        primaryStage.setTitle("GameAPP");
        scene.setFill(Color.BLACK);

        // THe Helipad is below
        double Helipad_Height = 30;
        double Helipad_Width = 40 ;
        Rectangle Helipad = new Rectangle(Helipad_Width,Helipad_Height);
        Helipad.setStroke(Color.GRAY);
        Helipad.setX(((APP_WIDTH-Helipad_Height)/2));
        Helipad.setY(APP_HEIGHT-Helipad_Height);
        root.getChildren().add(Helipad);

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

    Circle cloudCircle = new Circle(6, Color.DARKGRAY);// Todo Add it as childern to the root
    //groot.addchildern(cloudcircle)

}

class Helipad {
    // Represents the starting and ending location for Helicopter


    Rectangle rectangle = new Rectangle(23, 34);

}


class Helicopter {
    // most complex game object
    // a yellow circle with a line to the direction of helicopter
    // display the current fuel
}

class PondAndCloud {

}