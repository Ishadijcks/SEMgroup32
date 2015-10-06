package game;

import java.util.ArrayList;

import game.bubble.Bubble;
import game.log.Logger;

public class Collisions {

    public static boolean checkCollisionPlayer(ArrayList<Bubble> bubbleList,
            ArrayList<Player> playerList) {
        for (int i = 0; i < bubbleList.size(); i++) {
            Bubble bubble = bubbleList.get(i);
            // if the x of the player and the bubble is the same
            // then there is a chance the rope hits the bubble
            // /// Diameter NOT IN ACCOUNT JET AND SIZE OF PLAYER
            Player player = playerList.get(0);

            if (player.getX() <= (bubble.getX() + bubble.getDiameter())
                    && (player.getCollisionX() + player.getWidth()) >= bubble
                            .getX()
                    && player.getCollisionY() <= (bubble.getY() + bubble
                            .getDiameter())
                    && (player.getY() + player.getHeight()) >= bubble.getY()) {
                if (player.getCollisionY() <= bubble.getY()) {
                    Logger.log("Player collided with a bubble", 8, 4);
                    return true;
                }
            }
        }
        return false;
    }

    public static int checkCollisionRope(ArrayList<Bubble> bubbleList,
            Rope rope) {
            for (int i = 0; i < bubbleList.size(); i++) {
                if (bubbleList.get(i).getX() <= rope.getX()) {
                    if (bubbleList.get(i).getX()
                            + bubbleList.get(i).getDiameter() >= rope.getX()) {
                        if (bubbleList.get(i).getY()
                                + bubbleList.get(i).getDiameter() >= rope
                                    .getY()) {
                            Logger.log("Rope collided with a bubble", 8, 4);
                            return i;
                        }
                    }
                }
            }
        return -1;
    }
    

    public static int checkCollisionPowerup(ArrayList<Player> playerList, ArrayList<Powerup> powerupList) {
    Player player1 = playerList.get(0);
    for (int i = 0; i < powerupList.size(); i++) {
        Powerup powerup = powerupList.get(i);

        if (player1.getCollisionX() <= (powerup.getX() + powerup.getWidth())
                && (player1.getCollisionX() + player1.getWidth()) >= powerup
                        .getX()
                && player1.getCollisionY() <= (powerup.getY() + powerup
                        .getHeight())
                && (player1.getY() + player1.getHeight()) >= powerup.getY()) {

            Logger.log("Player collided with a powerup", 8, 4);

           return i;
        }
    }
    return -1;
    }
}
