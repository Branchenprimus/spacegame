package hellofx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) {
        theStage.setTitle("Timeline Example");
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);
        Canvas canvas = new Canvas(512, 512);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image earth = new Image("/hellofx/earth.png");
        Image sun = new Image("/hellofx/sun.png");
        Image space = new Image("/hellofx/space.png");
        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                double x = 232 + 150 * Math.cos(t);
                double y = 232 + 150 * Math.sin(t);
                // background image clears canvas
                gc.drawImage(space, 0, 0);
                gc.drawImage(earth, x, y);
                gc.drawImage(sun, 196, 196);

                gc.setFill(Color.RED);
                Font theFont = Font.font("calibri", FontWeight.BOLD, 48);
                gc.setFont(theFont);
                gc.fillText("Hello, World!", x - 100, y - 30);

            }
        }.start();
        theStage.show();
    }
}