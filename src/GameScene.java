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
    StaticThing life1;
    StaticThing life2;
    StaticThing life3;
    Hero hero;
    AnimationTimer timer = new AnimationTimer()
    {public void handle(long time){
        hero.update(time);
        camera.update(time);
        update(time);
    }
    };
    StaticThing food;
    long waitRecovery;
    long timRecovery;
    StaticThing trap;
    long invincibleTime;
    long timInvinsible;

    public GameScene(Parent parent, Camera cam) {
        super(parent,cam.getX(),cam.getY(),true);
        this.camera = cam;

        //background init
        this.left = new StaticThing(cam.getX(),cam.getY(), "desert.png");
        this.right = new StaticThing(cam.getX(),cam.getY(), "desert.png");

        //hero init
        this.hero = new Hero("heros.png",50,250,83,105);

        //life bar init
        this.numberOfLifes = 3;
        this.life1 = new StaticThing(48,24,"meat/meat3_.png");
        this.life1.imview.setViewport(new Rectangle2D(0,0,24,24));
        this.life1.imview.setX(20);
        this.life1.imview.setY(20);
        this.life2 = new StaticThing(48,24,"meat/meat3_.png");
        this.life2.imview.setViewport(new Rectangle2D(0,0,24,24));
        this.life2.imview.setX(50);
        this.life2.imview.setY(20);
        this.life3 = new StaticThing(48,24,"meat/meat3_.png");
        this.life3.imview.setViewport(new Rectangle2D(0,0,24,24));
        this.life3.imview.setX(80);
        this.life3.imview.setY(20);

        //recovery item init
        this.food = new StaticThing(64,47,"yms-Momo.png");
        this.food.imview.setX(400);
        this.food.imview.setY(310);
        this.waitRecovery = 100;
        this.timRecovery = -1;

        //negative item init
        this.trap = new StaticThing(52,47,"yms-UnkoP.png");
        this.trap.imview.setX(400);
        this.trap.imview.setY(310);
        this.invincibleTime = 100;
        this.timInvinsible = -1;

        timer.start();
    }

    public void dispLife(){

        double lifeX1 = 0;
        double lifeX2 = 0;
        double lifeX3 = 0;

        if (this.numberOfLifes <= 2) {
            lifeX3 = 24;
            if (this.numberOfLifes <= 1) {
                lifeX2 = 24;
            }
            if (this.numberOfLifes <= 0) {
                lifeX1 = 24;
            }
        }
        this.life1.imview.setViewport(new Rectangle2D(lifeX1,0,24,24));
        this.life1.imview.setX(20);
        this.life1.imview.setY(20);
        this.life2.imview.setViewport(new Rectangle2D(lifeX2,0,24,24));
        this.life2.imview.setX(50);
        this.life2.imview.setY(20);
        this.life3.imview.setViewport(new Rectangle2D(lifeX3,0,24,24));
        this.life3.imview.setX(80);
        this.life3.imview.setY(20);

    }
    public void render(int posX,int posY){
        left.imview.setViewport(new Rectangle2D(0,0,800,400));
        left.imview.setX(camera.x-posX-800);
        left.imview.setY(posY);
        right.imview.setViewport(new Rectangle2D(0,0,800,400));
        right.imview.setX(camera.x-posX);
        right.imview.setY(posY);

        int posFood = 600-posX+100;int posTrap = 500;int posTrapY=310;
        //int posTrap = 600-posX+100;int posFood = 900;int posTrapY=310;
        //int posFood = 600-posX+100;int posTrap = 700-3*posX;int posTrapY=150;

        if ((posTrap<hero.x)&&(posTrapY < (hero.y+80))){
            trap.imview.setViewport(new Rectangle2D(52,0,52,47));
            this.lostLife();
        }else if ((posFood<hero.x)&&(320 < (hero.y+80))){
            food.imview.setViewport(new Rectangle2D(0,95,64,47));
            this.recovery();}
        else {
            if (timRecovery != -1){ timRecovery++; }
            if (timInvinsible != -1){ timInvinsible++; }
            food.imview.setViewport(new Rectangle2D(0,0,64,47));
            trap.imview.setViewport(new Rectangle2D(0,0,52,47));}
        food.imview.setX(posFood);
        food.imview.setY(310);
        trap.imview.setX(posTrap);
        trap.imview.setY(posTrapY);
    }

    public void update(long time){
        render((int)(time/2000000)%800,0);
        this.setOnMouseClicked( (event)->{
            System.out.println("Jump");
            hero.jump();
        });
    }

    public void recovery(){
        if ((timRecovery == -1)||(timRecovery >= waitRecovery)) {
            this.numberOfLifes = Math.min(this.numberOfLifes + 1, 3);
            this.dispLife();
            timRecovery++;
        } else if (timRecovery == (waitRecovery-1)) {
            timRecovery=-1;
        } else {timRecovery++;}
    }

    public void lostLife(){
        if ((timInvinsible == -1)||(timInvinsible >= invincibleTime)) {
            this.numberOfLifes = Math.max(this.numberOfLifes - 1, 0);
            this.dispLife();
            timInvinsible++;
        } else if (timInvinsible == (invincibleTime-1)) {
            timInvinsible=-1;
        } else {timInvinsible++;}
    }

}
