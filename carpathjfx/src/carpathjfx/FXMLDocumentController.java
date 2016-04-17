/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpathjfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 *
 * @author Karim
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Path path;
    @FXML
    private ImageView img;

    @FXML
    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        img.setImage(new Image(getClass().getResource("1422913162_sedan-128.png").toString()));
        path.getStrokeDashArray().addAll(25d, 20d, 5d, 20d);
        img.setOnMouseClicked(new EventHandler<MouseEvent>() {
            int flag = 0;

            @Override
            public void handle(MouseEvent t) {
                if (flag == 0) {
                    PathTransition anim = PathTransitionBuilder.create().duration(new Duration(5000.0)).node(img).path(path).orientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT).interpolator(Interpolator.LINEAR).autoReverse(false).cycleCount(Timeline.INDEFINITE).build();
                    anim.play();
                    flag = 1;
                } else {
                    PathTransition anim = PathTransitionBuilder.create().duration(new Duration(5000.0)).node(img).path(path).orientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT).interpolator(Interpolator.LINEAR).autoReverse(false).cycleCount(Timeline.INDEFINITE).build();
                    anim.setRate(-1);
                    anim.play();
                    flag = 0;
                }
            }
        });

    }

}
