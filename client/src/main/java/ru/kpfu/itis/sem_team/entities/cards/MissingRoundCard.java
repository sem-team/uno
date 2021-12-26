package main.java.ru.kpfu.itis.sem_team.entities.cards;

import main.java.ru.kpfu.itis.sem_team.entities.games.UnoGame;

public class MissingRoundCard extends UnoCard implements IMissingRound{

    public MissingRoundCard(Color color) {
        super(color, 0);
    }

    @Override
    public void missRound(UnoGame game) {
        //TODO: set the game's active player by missing the next one
    }
}
