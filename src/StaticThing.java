import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {
    double sizeX;
    double sizeY;
    ImageView imview;

    public StaticThing(double sizeX, double sizeY, String filename) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        Image img = new Image(filename);
        this.imview = new ImageView(img);

    }
}
