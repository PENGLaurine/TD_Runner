import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameScene extends Scene {
    Camera camera;

    public GameScene(Parent parent, Camera cam) {
        super(parent);
        this.camera = cam;
    }
}
