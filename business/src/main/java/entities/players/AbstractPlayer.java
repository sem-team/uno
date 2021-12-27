package entities.players;

public abstract class AbstractPlayer implements IPlayer {
    protected String name;

    public AbstractPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
