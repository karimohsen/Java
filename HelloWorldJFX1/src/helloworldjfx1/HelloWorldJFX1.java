/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldjfx1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Karim
 */
public class HelloWorldJFX1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text hellostr = new Text("Hello World");
        StackPane root = new StackPane();
        root.getChildren().addAll(hellostr);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        Reflection reflection = new Reflection();
        reflection.setFraction(50);
        hellostr.setEffect(reflection);
        Stop[] stops = new Stop[]{new Stop(0, Color.GREY), new Stop(1, Color.WHITE)};
        LinearGradient lg1 = new LinearGradient(0, 0, 0, 0.5, true, CycleMethod.REFLECT, stops);
        scene.setFill(lg1);
        hellostr.setFont(new Font(35));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
