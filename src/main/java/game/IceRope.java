package game;

public class IceRope extends Rope{

    public IceRope(int x, int y) {
       
        super(x, y);
        Logger.log("Ice rope created", 5 ,4);
    }

    /**
     * The rope moves up and gets destroyed when it hits the roof
     */
    @Override
    public void move() {
        Logger.log("Ice rope moved", 5, 5, 100);
       if (super.y <= Settings.getTopMargin() - 2) 
       {
          return;
       } 
       else 
       {
           super.y -= Settings.getRopeSpeed();
       } 
    }
    
}
