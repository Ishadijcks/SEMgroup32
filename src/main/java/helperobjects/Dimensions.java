package helperobjects;

/**
 * Class that will keep a combination of a height and a width element.
 * @author Boning
 *
 */
public class Dimensions {
    
    private int height;
    private int width;
    
    /**
     * Constructor for the dimensions class.
     * @param height of object
     * @param width of object
     */
    public Dimensions(int height, int width) {
        this.height = height;
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    
    /**
     * Equals method to compare a dimensions object.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dimensions other = (Dimensions) obj;
        if (height != other.height)
            return false;
        if (width != other.width)
            return false;
        return true;
    }
    
    

}
