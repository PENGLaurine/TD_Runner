import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameScene extends Scene {
    Camera camera;
    StaticThing left;
    StaticThing right;
    int numberOfLifes;
    Hero hero;

    public GameScene(Parent parent, Camera cam) {
        super(parent,cam.getX(),cam.getY(),true);
        this.camera = cam;
        this.left = new StaticThing(cam.getX(),cam.getY(), "desert.png");
        this.right = new StaticThing(cam.getX(),cam.getY(), "desert.png");
        this.numberOfLifes = 3;
        this.hero = new Hero("heros.png",20,250,83,105);
    }

    public void dispLife(Group root){
        StaticThing life1 = new StaticThing(24,24,"heart/heart3.png");
        StaticThing life2 = new StaticThing(24,24,"heart/heart3.png");
        StaticThing life3 = new StaticThing(24,24,"heart/heart3.png");
        if (numberOfLifes==2) {
            life3 = new StaticThing(24,24,"heart/heart3b.png");
        } else if (numberOfLifes==1) {
            life2 = new StaticThing(24,24,"heart/heart3b.png");
            life3 = new StaticThing(24,24,"heart/heart3b.png");
        } else if (numberOfLifes<=0){
            life1 = new StaticThing(24,24,"heart/heart3b.png");
            life2 = new StaticThing(24,24,"heart/heart3b.png");
            life3 = new StaticThing(24,24,"heart/heart3b.png");
        }

        root.getChildren().add(life1.imview);
        root.getChildren().add(life2.imview);
        root.getChildren().add(life3.imview);

        life1.imview.setViewport(new Rectangle2D(0,0,24,24));
        life1.imview.setX(20);
        life1.imview.setY(20);
        life2.imview.setViewport(new Rectangle2D(0,0,24,24));
        life2.imview.setX(50);
        life2.imview.setY(20);
        life3.imview.setViewport(new Rectangle2D(0,0,24,24));
        life3.imview.setX(80);
        life3.imview.setY(20);
    }
    public void render(int posX,int posY){
        left.imview.setViewport(new Rectangle2D(0,0,800,400));
        left.imview.setX(camera.x-posX-800);
        left.imview.setY(posY);
        right.imview.setViewport(new Rectangle2D(0,0,800,400));
        right.imview.setX(camera.x-posX);
        right.imview.setY(posY);
    }

}
