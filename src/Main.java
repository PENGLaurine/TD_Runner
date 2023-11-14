import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        /*
        Image spriteSheet = new Image("../data/img/heros.png");
        ImageView sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20,0,65,100));
        sprite.setX(200);
        sprite.setY(300);
        */

        stage.setTitle("Hello world");
        Group root = new Group();
        Pane pane = new Pane(root);

        //Scene theScene = new Scene(pane, 600, 400,true);
        Camera cam = new Camera(600,400);
        GameScene theScene = new GameScene(pane,cam);
        theScene.setFill(Color.BLACK);

        stage.setScene(theScene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}