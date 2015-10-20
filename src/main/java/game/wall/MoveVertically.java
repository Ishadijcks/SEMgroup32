package game.wall;

import helperobjects.Coordinates;

public class MoveVertically implements WallMovementBehavior {
    public void move(Coordinates coordinates) {
        coordinates.setyCoordinate(coordinates.getyCoordinate() + 1);
    }
}
