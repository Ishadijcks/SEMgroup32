package game;

import game.log.Logger;


public class GameCreator {

    public static SurvivalGame createSurvival(Player player1){
        SurvivalGame game = new SurvivalGame();
        game.addPlayer(player1);
        NormalLevelCreator.setPlayerList(game.getPlayerList());
        game.addLevel(SurvivalLevelCreator.getLevel());
        Logger.log("SurvivalGame game created",7,4);
        return game;
    }
	/**
	 * Create a game with a single player. 
	 * @param player1
	 * @return a game with a single player
	 */
    public static NormalGame createSinglePlayer(Player player1) {
        NormalGame game = new NormalGame();
        game.addPlayer(player1);
        NormalLevelCreator.setPlayerList(game.getPlayerList());
        for (int i = 1; i < 6; i++) {
            game.addLevel(NormalLevelCreator.getLevel(i));
        }
        Logger.log("Singleplayer game created",7,4);
        return game;
    }

    /**
     * Create a game with multiple players
     * @param player1
     * @param player2
     * @return a game with multiple players
     */
    public static NormalGame createMultiPlayer(Player player1, Player player2) {
        NormalGame game = new NormalGame();
        game.addPlayer(player1);
        game.addPlayer(player2);
        NormalLevelCreator.setPlayerList(game.getPlayerList());
     
        game.addLevel(NormalLevelCreator.getLevel1());
        Logger.log("Multiplayer game created",7,4);
        return game;
    }
}
