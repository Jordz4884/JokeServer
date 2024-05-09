package Jokes.dao;

import Jokes.Model.Jokes;

public interface JokesRepo {
    void createJoke(String jokeText, String categoryID);
    void finalizeJoke(int jokeID, String categoryID);
    static void getJokes(String jokeCategory) {

    }
    void updateJoke(String jokeText);
    void deleteJoke(String jokeText);
    static void verifyJoke(String jokeText) {

    }
}
