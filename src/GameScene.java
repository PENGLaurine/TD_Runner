import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GameScene extends Scene {
    Camera camera;
    StaticThing left;
    StaticThing right;
    int numberOfLifes;
    StaticThing life1 = new StaticThing(24,24,"meat/meat3.png");
    StaticThing life2 = new StaticThing(24,24,"meat/meat3.png");
    StaticThing life3 = new StaticThing(24,24,"meat/meat3.png");
    Hero hero;
    AnimationTimer timer = new AnimationTimer()
    {public void handle(long time){
        hero.update(time);
        camera.update(time);
        update(time);
    }
    };

    public GameScene(Parent parent, Camera cam) {
        super(parent,cam.getX(),cam.getY(),true);
        this.camera = cam;
        this.left = new StaticThing(cam.getX(),cam.getY(), "desert.png");
        this.right = new StaticThing(cam.getX(),cam.getY(), "desert.png");
        this.numberOfLifes = 3;
        this.hero = new Hero("heros.png",20,250,83,105);
        this.life1 = new StaticThing(24,24,"meat/meat3.png");
        this.life1.imview.setX(20);
        this.life1.imview.setY(20);
        this.life2 = new StaticThing(24,24,"meat/meat3.png");
        this.life2.imview.setX(50);
        this.life2.imview.setY(20);
        this.life3 = new StaticThing(24,24,"meat/meat3.png");
        this.life3.imview.setX(80);
        this.life3.imview.setY(20);
        timer.start();
    }

    public void dispLife(){

        if (numberOfLifes==2) {
            life3.imview = new ImageView(new Image("meat/meat3b.png"));
            life3.imview.setX(80);
            life3.imview.setY(20);
        } else if (numberOfLifes==1) {
            life2.imview = new ImageView(new Image("meat/meat3b.png"));
            life2.imview.setX(50);
            life2.imview.setY(20);
            life3.imview = new ImageView(new Image("meat/meat3b.png"));
            life3.imview.setX(80);
            life3.imview.setY(20);
        } else if (numberOfLifes<=0){
            life1.imview = new ImageView(new Image("meat/meat3b.png"));
            life1.imview.setX(20);
            life1.imview.setY(20);
            life2.imview = new ImageView(new Image("meat/meat3b.png"));
            life2.imview.setX(50);
            life2.imview.setY(20);
            life3.imview = new ImageView(new Image("meat/meat3b.png"));
            life3.imview.setX(80);
            life3.imview.setY(20);
        }

    }
    public void render(int posX,int posY){
        left.imview.setViewport(new Rectangle2D(0,0,800,400));
        left.imview.setX(camera.x-posX-800);
        left.imview.setY(posY);
        right.imview.setViewport(new Rectangle2D(0,0,800,400));
        right.imview.setX(camera.x-posX);
        right.imview.setY(posY);
    }

    public void update(long time){
        render((int)(time/2000000)%800,0);

    }

}
