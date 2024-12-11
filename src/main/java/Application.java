import com.chickengame.Game;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**Application é o ponto de entrada do programa
 * Cria a unica instancia do jogo e inicia-o*/
public class Application {
    public static void main(String[] args) {
            Game game = Game.getInstance();
        try {
            game.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}