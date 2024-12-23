import com.chickengame.Game;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
            Game game = Game.getInstance();
        try {
            game.run();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}