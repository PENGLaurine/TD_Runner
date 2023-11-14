import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameScene extends Scene {
    Camera camera;
    StaticThing left;
    StaticThing right;


    public GameScene(Parent parent, Camera cam) {
        super(parent,cam.getX(),cam.getY(),true);
        this.camera = cam;
        this.left = new StaticThing(cam.getX(),cam.getY(),"../data/img/desert.png");
    }


}
