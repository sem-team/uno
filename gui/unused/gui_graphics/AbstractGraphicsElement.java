package ru.kpfu.itis.sem_team.gui_graphics;

import javafx.scene.Parent;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.util.Observable;
import ru.kpfu.itis.sem_team.util.Observer;


public abstract class AbstractGraphicsElement extends Observable implements IGraphicsElement, Observer {
    protected Parent graphics;

    protected abstract void build();

    @Override
    public Parent getGraphics() {
        if (graphics == null) build();
        return graphics;
    }

    @Override
    public void update(Observable o, IEvent event) {

    }
}
