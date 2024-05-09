package Jokes.Model;

public class Jokes {
    private int jokeID;
    private String jokeText;
    private String jokeCategory;
    private int categoryID;



    public Jokes() {
    }

    public Jokes(int jokeID, String jokeText, String jokeCategory) {
        this.jokeID = jokeID;
        this.jokeText = jokeText;
        this.jokeCategory = jokeCategory;
    }

    public int getJokeID() {
        return jokeID;
    }

    public void setJokeID(int jokeID) {
        this.jokeID = jokeID;
    }

    public String getJokeText() {
        return jokeText;
    }

    public void setJokeText(String jokeText) {
        this.jokeText = jokeText;
    }

    public String getJokeCategory() {
        return jokeCategory;
    }

    public void setJokeCategory(String jokeCategory) {
        this.jokeCategory = jokeCategory;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
