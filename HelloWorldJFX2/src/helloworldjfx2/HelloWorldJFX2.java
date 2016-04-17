/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helloworldjfx2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Karim
 */
public class HelloWorldJFX2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Text hellostr = new Text("Hello World");
        hellostr.setId("text");
        StackPane root = new StackPane();
        root.getChildren().addAll(hellostr);
        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add(getClass().getResource("style.css").toString());
        primaryStage.setScene(scene);
        primaryStage.show();
        Reflection reflection = new Reflection();
        reflection.setFraction(50);
        hellostr.setEffect(reflection);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
