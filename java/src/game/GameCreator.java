package game;

public class GameCreator {

    public static Game createSinglePlayer(Player player1){
        Game game = new Game();
        game.addPlayer(player1);
        LevelCreator.setPlayerList(game.getPlayerList());

        game.addLevel(LevelCreator.getLevel1());
        game.addLevel(LevelCreator.getLevel2());
        game.addLevel(LevelCreator.getLevel3());
        game.addLevel(LevelCreator.getLevel4());
        game.addLevel(LevelCreator.getLevel5());
        return game;
    }
    
    public static Game createMultiPlayer(Player player1, Player player2){
        Game game = new Game();
        game.addPlayer(player1);
        game.addPlayer(player2);
        LevelCreator.setPlayerList(game.getPlayerList());
        System.out.println(game.getPlayerList().size());
        game.addLevel(LevelCreator.getLevel1());
        return game;
    }
}