package game;


public class GameCreator {

	/**
	 * Create a game with a single player. 
	 * @param player1
	 * @return a game with a single player
	 */
    public static Game createSinglePlayer(Player player1) {
        Game game = new Game();
        game.addPlayer(player1);
        LevelCreator.setPlayerList(game.getPlayerList());
        for (int i = 1; i < 6; i++) {
            game.addLevel(LevelCreator.getLevel(i));
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
    public static Game createMultiPlayer(Player player1, Player player2) {
        Game game = new Game();
        game.addPlayer(player1);
        game.addPlayer(player2);
        LevelCreator.setPlayerList(game.getPlayerList());
     
        game.addLevel(LevelCreator.getLevel1());
        Logger.log("Multiplayer game created",7,4);
        return game;
    }
}
