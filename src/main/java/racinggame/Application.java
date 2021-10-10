package racinggame;

public class Application {
    public static void main(String[] args) {
        GameService gameService = GameService.getInstance();
        gameService.play();
    }
}
