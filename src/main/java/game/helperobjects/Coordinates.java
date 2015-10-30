package game.helperobjects;

/**
 * Class that will keep a combination of a x-Coordinate and a y-Coordinate.
 * 
 * @author Boning
 *
 */
public class Coordinates {

    private int xCoordinate;
    private int yCoordinate;

    /**
     * Constructor for the coordinates class.
     * 
     * @param xCoord
     *            of object
     * @param yCoord
     *            of object
     */
    public Coordinates(int xCoord, int yCoord) {
        xCoordinate = xCoord;
        yCoordinate = yCoord;
    }

    /**
     * @return the xCoordinate
     */
    public int getxCoordinate() {
        return xCoordinate;
    }

    /**
     * @return the yCoordinate
     */
    public int getyCoordinate() {
        return yCoordinate;
    }

    /**
     * @param xCoordinate
     *            the xCoordinate to set
     */
    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * @param yCoordinate
     *            the yCoordinate to set
     */
    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Equals method for a coordinates object.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Coordinates other = (Coordinates) obj;
        if (xCoordinate != other.xCoordinate) {
            return false;
        }
        if (yCoordinate != other.yCoordinate) {
            return false;
        }
        return true;
    }

}
