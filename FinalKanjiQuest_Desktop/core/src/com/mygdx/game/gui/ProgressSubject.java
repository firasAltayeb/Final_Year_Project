package com.mygdx.game.gui;


public interface ProgressSubject {
    public void addObserver(ProgressObserver progressObserver);
    public void removeObserver(ProgressObserver progressObserver);
    public void removeAllObservers();
    public void notify(final int value, ProgressObserver.StatusEvent event);
}
