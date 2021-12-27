package main.java.ru.kpfu.itis.sem_team.entities.cards;

import main.java.ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import main.java.ru.kpfu.itis.sem_team.entities.games.UnoGame;

public class MissingRoundCard extends UnoCard implements IMissingRound{

    public MissingRoundCard(Color color) {
        super(color, 0);
    }

    @Override
    public void missRound(UnoGame game) {
        if (((UnoBoard) game.getBoard()).isClockwise()) {
            if (game.getNumberOfActivePlayer() + 2 > game.getRoom().getMaxNumberOfParticipants()) {
                game.setNumberOfActivePlayer(0);
            }
            else {
                game.setNumberOfActivePlayer(game.getNumberOfActivePlayer() + 1);
            }
        }

        else {
            if (game.getNumberOfActivePlayer() - 1 < 0) {
                game.setNumberOfActivePlayer(game.getRoom().getMaxNumberOfParticipants() - 1);
            }
            else {
                game.setNumberOfActivePlayer(game.getNumberOfActivePlayer() - 1);
            }
        }
    }
}
