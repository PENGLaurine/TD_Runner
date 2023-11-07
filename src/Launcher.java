import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Launcher {

    static public void main(String[] args){
        /*Image spriteSheet = new Image("../data/img/heros.png");
        ImageView sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20,0,65,100));
        sprite.setX(200);
        sprite.setY(300);
        */

        Camera cam = new Camera(200,300);
        System.out.println(cam);
        Main.main(args);
    }
}
