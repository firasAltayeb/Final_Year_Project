package com.mygdx.game.gui;


public interface StatusSubject {
    public void addObserver(StatusObserver statusObserver);
    public void removeObserver(StatusObserver statusObserver);
    public void removeAllObservers();
    public void notify(final int value, StatusObserver.StatusEvent event);
}
