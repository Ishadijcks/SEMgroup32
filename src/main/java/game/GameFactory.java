package game;

import game.log.Logger;

/**
 * Creates either a survival or a normal game.
 * @author Boning
 *
 */
public class GameFactory {

    /**
     * Create a new survival game.
     * @param player1 the player that will be put in the game
     * @return a new survival game 
     */
    public static SurvivalGame createSurvival(Player player1) {
        SurvivalGame game = new SurvivalGame();
        game.addPlayer(player1);
        SurvivalLevelCreator.setPlayerList(game.getPlayerList());
        game.addLevel(SurvivalLevelCreator.getLevel());
        Logger.log("SurvivalGame game created", 7, 4);
        return game;
    }
    
	/**
	 * Create a game with a single player. 
	 * @param player1 the player that will be put in the game
	 * @return a game with a single player
	 */
    public static NormalGame createSinglePlayer(Player player1) {
        NormalGame game = new NormalGame();
        game.addPlayer(player1);
        NormalLevelCreator.setPlayerList(game.getPlayerList());
        for (int i = 1; i < 9; i++) {
            game.addLevel(NormalLevelCreator.getLevel(i));
        }
        Logger.log("Singleplayer game created", 7, 4);
        return game;
    }

    /**
     * Create a game with multiple players.
     * @param player1 the first player that will be put in the game
     * @param player2 the first player that will be put in the game
     * @return a game with multiple players
     */
    public static NormalGame createMultiPlayer(Player player1, Player player2) {
        NormalGame game = new NormalGame();
        game.addPlayer(player1);
        game.addPlayer(player2);
        NormalLevelCreator.setPlayerList(game.getPlayerList());
     
        game.addLevel(NormalLevelCreator.getLevel1());
        Logger.log("Multiplayer game created", 7, 4);
        return game;
    }
}
