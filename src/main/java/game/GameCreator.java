package game;


public class GameCreator {

    public static Game createSinglePlayer(Player player1) {
        Game game = new Game();
        game.addPlayer(player1);
        LevelCreator.setPlayerList(game.getPlayerList());
        for (int i = 1; i < 6; i++) {
            game.addLevel(LevelCreator.getLevel(i));
        }
        return game;
    }

    public static Game createMultiPlayer(Player player1, Player player2) {
        Game game = new Game();
        game.addPlayer(player1);
        game.addPlayer(player2);
        LevelCreator.setPlayerList(game.getPlayerList());
        System.out.println(game.getPlayerList().size());
        game.addLevel(LevelCreator.getLevel1());
        return game;
    }
}
