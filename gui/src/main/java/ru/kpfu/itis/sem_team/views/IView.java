package ru.kpfu.itis.sem_team.views;

import javafx.scene.Parent;
import ru.kpfu.itis.sem_team.util.Observer;

public interface IView extends Observer {
    Parent asParent();
}
