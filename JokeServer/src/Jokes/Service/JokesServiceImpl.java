package Jokes.Service;

import Jokes.Model.Jokes;
import Jokes.dao.JokesRepoImpl;

import java.util.Scanner;

public class JokesServiceImpl implements JokesService {

    public static void showJokesMenu() {
        System.out.println("+-------------------------+");
        System.out.println("| 1. Create Joke          |");
        System.out.println("| 2. Get Verified Jokes   |");
        System.out.println("| 3. Update Joke          |");
        System.out.println("| 4. Delete Joke          |");
        System.out.println("| 5. Quit                 |");
        System.out.println("+-------------------------+");

        Scanner input = new Scanner(System.in);
        String userChoice = input.nextLine();

        switch (userChoice) {
            case "1": {
                System.out.println("Please enter the joke text : ");
                String jokeText = input.nextLine();
                System.out.println("Please enter the number corresponding to the category you wish the joke to be a part of : ");
                System.out.println("1 for IT-Related Jokes");
                System.out.println("2 for Puns");
                System.out.println("3 for Knock-knock Jokes");
                System.out.println("4 for Dad Jokes");
                String categoryID = input.nextLine();

                JokesRepoImpl joke = new JokesRepoImpl();
                joke.createJoke(jokeText, categoryID);

                System.out.println("Joke was created successfully");
                break;
            }
            case "2": {
                JokesRepoImpl joke = new JokesRepoImpl();
                joke.getVerifiedJokes();

                System.out.println("Jokes were retrieved successfully");
                break;
            }
            case "3": {
                System.out.println("Please enter the joke text : ");
                String jokeText = input.nextLine();

                JokesRepoImpl joke = new JokesRepoImpl();
                joke.updateJoke(jokeText);

                System.out.println("Joke updated successfully");
                break;
            }
            case "4": {
                System.out.println("Please enter the joke text : ");
                String jokeText = input.nextLine();

                JokesRepoImpl joke = new JokesRepoImpl();
                joke.deleteJoke(jokeText);

                System.out.println("Joke deleted successfully");
                break;
            }
            case "5": {
                System.out.println("Quitting the program");
                break;
            }
        }
        input.close();
    }
}
