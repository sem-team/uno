package ru.kpfu.itis.sem_team.gui_graphics.game;

import ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import ru.kpfu.itis.sem_team.gui_graphics.AbstractGuiGraphics;

public class GameGraphics extends AbstractGuiGraphics {
    private UnoBoard board;

    @Override
    protected void build() {

    }



    public void bindToBoard(UnoBoard board) {
        this.board = board;
        this.addObserver(board);
        board.addObserver(this);
    }


}
