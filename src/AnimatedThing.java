import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    double x;
    double y;
    ImageView spriteSheet;
    int attitude;       //ex {0->still, 1->running, 2->jumping up, 3->jumping down}

    int index;
    long durationFrame;
    int offsetFrame;
    int maxIndex;
    double sizeX;
    double sizeY;

    public AnimatedThing(String filename, double x, double y, double sX, double sY) {
        this.x = x;
        this.y = y;
        Image img = new Image(filename);
        this.spriteSheet = new ImageView(img);
        attitude = 0;
        this.sizeX = sX;
        this.sizeY = sY;
        this.spriteSheet.setViewport(new Rectangle2D(12,0,sX,sY));
        this.spriteSheet.setX(x);
        this.spriteSheet.setY(y);
    }

    public ImageView getSpriteSheet() {
        return spriteSheet;
    }
}
