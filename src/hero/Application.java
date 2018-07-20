package hero;

import java.util.ArrayList;

public class Application {
    public static void main(String argv[]) {
        Application app = new Application();
        app.launch();
    }

    private void launch() {
        ILogger log = new Log(new ArrayList());

        Game game = new Game(log);
        game.play();
        log.display();
    }
}
