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
        this.durationFrame = 3;
    }

    public ImageView getSpriteSheet() {
        return spriteSheet;
    }

    public void update(long time){

        if ((int)(time/700000)%(int)(durationFrame)==0){
            double sheetX = 7 + 83*index;
            double sheetY = 160 * attitude;
            switch (attitude){              //settings for heros.png
                case 0:     //running
                case 2:
                    maxIndex = 6;
                    index = (index+1)%maxIndex;
                    spriteSheet.setViewport(new Rectangle2D(sheetX,sheetY,sizeX,sizeY));
                    spriteSheet.setX(x);
                    spriteSheet.setY(y);break;
                case 1:     //jumping
                case 3:
                    if ((index==0)&&(y>50)){
                        spriteSheet.setViewport(new Rectangle2D(sheetX,sheetY,sizeX,sizeY));
                        if (y-15<=50){
                            y = 50;
                            index +=1 ;
                        }
                        else {y = y-15;}
                        spriteSheet.setX(x);
                        spriteSheet.setY(y);
                    }
                    else {
                        if ((index==1)&&(y<(400-sizeY-50))){
                            if (y+15>=(400-sizeY-50)){
                                y = (400-sizeY-50);
                                attitude -=1;
                            }
                            else {y = y+15;}
                        }
                        spriteSheet.setX(x);
                        spriteSheet.setY(y);
                    }
                    break;
            }

        }
    }
}
