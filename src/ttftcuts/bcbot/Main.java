package ttftcuts.bcbot;

import bwapi.*;
import ttftcuts.bcbot.util.Drawing;

public class Main extends DefaultBWListener {

    public static Mirror mirror = new Mirror();

    public static Bot bot;

    public Game game;

    public void run() {
        try {
            mirror.getModule().setEventListener(this);
            mirror.startGame();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // on game start
    @Override
    public void onStart() {
        game = mirror.getGame();

        bot = new Bot(game);

        Drawing.Colours.initPalette();
    }

    // on game end
    @Override
    public void onEnd(boolean b) {
        game = null;
        bot = null;
    }

    // main update
    @Override
    public void onFrame() {
        //System.out.println("##### bot: "+bot);
        try {
            if (bot != null) {
                bot.onFrame();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // unit created, not morphing or vespene
    @Override
    public void onUnitCreate(Unit unit) {
        if (bot != null) {

        }
    }

    // unit destroyed or completely removed
    @Override
    public void onUnitDestroy(Unit unit) {
        if (bot != null) {

        }
    }

    // morphing, siegeing and vespene extractors
    @Override
    public void onUnitMorph(Unit unit) {
        if (bot != null) {

        }
    }

    // protoss mind control ability
    @Override
    public void onUnitRenegade(Unit unit) {
        if (bot != null) {

        }
    }

    // construction or training complete
    @Override
    public void onUnitComplete(Unit unit) {
        if (bot != null) {

        }
    }

    // player times out
    @Override
    public void onPlayerDropped(Player player) {
        if (bot != null) {

        }
    }

    // player leaves game
    @Override
    public void onPlayerLeft(Player player) {
        if (bot != null) {

        }
    }

    @Override
    public void onUnitDiscover(Unit unit) {
        if (bot != null) {

        }
    }

    @Override
    public void onUnitEvade(Unit unit) {
        if (bot != null) {

        }
    }

    @Override
    public void onUnitShow(Unit unit) {
        if (bot != null) {

        }
    }

    @Override
    public void onUnitHide(Unit unit) {
        if (bot != null) {

        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}