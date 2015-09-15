package game;

public class IceRope extends Rope{

    public IceRope(int x, int y) {
        super(x, y);
    }

    /**
     * The rope moves up and gets destroyed when it hits the roof
     */
    @Override
    public void move() {
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
