package game.wall;

import helperobjects.Coordinates;

public class MoveHorizontally implements WallMovementBehavior {
    public void move(Coordinates coordinates) {
        coordinates.setxCoordinate(coordinates.getxCoordinate() + 1);
    }
}
