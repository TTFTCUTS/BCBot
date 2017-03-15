package ttftcuts.bcbot;

import bwapi.Game;
import bwapi.Player;
import ttftcuts.bcbot.map.BWMap;

public class Bot {
    public final Game theGame;
    public final Player self;
    public final BWMap map;

    public Bot(Game theGame) {
        this.theGame = theGame;
        this.self = theGame.self();
        this.map = new BWMap();

        this.gameStart();
    }

    // ###########

    public void gameStart() {
        print("go!");
    }

    public void onFrame() {
        this.map.draw();
    }

    // ###########

    public static void print(Object thing) {
        System.out.println(thing);
    }
}
