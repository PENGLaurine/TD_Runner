import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    double x;
    double y;
    ImageView spriteSheet;
    int attitude;

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
        this.durationFrame = 10;
    }

    public ImageView getSpriteSheet() {
        return spriteSheet;
    }

    public void update(long time){

        if ((int)(time/1000000)%(int)(durationFrame)==0){
            switch (attitude){              //à adapter selon le spritesheet utilisé
                case 0:
                case 2:
                    maxIndex = 6;
                    index = (index+1)%maxIndex;
                    double sheetX = 7 + 83*index;
                    double sheetY = 160 * attitude;
                    spriteSheet.setViewport(new Rectangle2D(sheetX,sheetY,sizeX,sizeY));
                    spriteSheet.setX(x);
                    spriteSheet.setY(y);break;
                case 1:
                case 3:
                    maxIndex = 2;break;
            }

        }
    }
}
