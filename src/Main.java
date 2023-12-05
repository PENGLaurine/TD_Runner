import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Runner");
        Group root = new Group();
        Pane pane = new Pane(root);
        //Scene theScene = new Scene(pane, 600, 400,true);

        Camera cam = new Camera(600,400);
        GameScene theScene = new GameScene(pane,cam);
        //theScene.setFill(Color.BLACK);
        theScene.render(300,0);
        root.getChildren().add(theScene.left.imview);
        root.getChildren().add(theScene.right.imview);
        theScene.numberOfLifes=2;
        theScene.dispLife();
        root.getChildren().add(theScene.life1.imview);
        root.getChildren().add(theScene.life2.imview);
        root.getChildren().add(theScene.life3.imview);
        root.getChildren().add(theScene.food.imview);
        root.getChildren().add(theScene.hero.spriteSheet);


        stage.setScene(theScene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}