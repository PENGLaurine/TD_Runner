public class Hero extends AnimatedThing{

    public Hero(String filename, double x, double y, double sizeX, double sizeY) {
        super(filename, x, y, sizeX, sizeY);
    }

    public void jump (){
        if ((this.attitude==0)||(this.attitude==2)){
            this.attitude += 1;
            this.index = 0;
        }
    }

}
