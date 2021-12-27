package ru.kpfu.itis.sem_team.gui_graphics;

import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.util.Observable;
import ru.kpfu.itis.sem_team.util.Observer;

import javafx.scene.Node;

public abstract class AbstractGuiElement extends Observable implements IGuiElement, Observer {
    protected Node node;

    protected abstract void build();

    @Override
    public Node getNode() {
        if (node == null) build();
        return node;
    }

    @Override
    public void update(Observable o, IEvent event) {

    }
}
