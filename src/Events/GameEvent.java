package Events;

import game.GameContext;

public abstract class GameEvent {

    protected GameContext gameContext;

    abstract boolean isAllowed();

    abstract void performAction();


    public GameContext getGameContext() {
        return gameContext;
    }

    public void setGameContext(GameContext gameContext) {
        this.gameContext = gameContext;
    }
}
