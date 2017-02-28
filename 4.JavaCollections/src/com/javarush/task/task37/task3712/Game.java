package com.javarush.task.task37.task3712;

public abstract class Game {
    public void run(){
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }

    protected abstract void prepareForTheGame();

    protected abstract void playGame();

    protected abstract void congratulateWinner();
}
