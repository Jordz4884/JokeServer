package User.Service;

import Categories.dao.CategoriesRepoImpl;
import Jokes.dao.JokesRepoImpl;
import User.dao.UserRepoImpl;
import Categories.Service.CategoriesServiceImpl;
import Jokes.Service.JokesServiceImpl;

import java.util.Scanner;

public class UserServiceImpl implements UserService{

    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();
        service.run();
    }

    @Override
    public void showMainMenu() {
        System.out.println("+-----------------+");
        System.out.println("| 1. Create User  |");
        System.out.println("| 2. Login User   |");
        System.out.println("| 3. Login Member |");
        System.out.println("| 4. Login Admin  |");
        System.out.println("| 5. Quit         |");
        System.out.println("+-----------------+");
        System.out.println("Note : Only members may edit jokes or categories, and only admins may verify jokes and edit user accounts");
        System.out.println("Please enter the number corresponding to your menu choice : ");
    }

    @Override
    public void showUserMenu() {
        System.out.println("+--------------------------+");
        System.out.println("| 1. View Joke Of The Day  |");
        System.out.println("| 2. View Verified Jokes   |");
        System.out.println("| 3. View Categories       |");
        System.out.println("| 4. Register As A Member  |");
        System.out.println("| 5. Update User           |");
        System.out.println("| 6. Delete User           |");
        System.out.println("| 7. Quit                  |");
        System.out.println("+--------------------------+");
        System.out.println("Note : Only members may edit jokes or categories, and only admins may verify jokes and edit user accounts");
        System.out.println("Please enter the number corresponding to your menu choice : ");
    }

    @Override
    public void showMemberMenu() {
        System.out.println("+------------------------------+");
        System.out.println("| 1. Access Jokes              |");
        System.out.println("| 2. Access Categories         |");
        System.out.println("| 3. Register As An Admin      |");
        System.out.println("| 4. Update User               |");
        System.out.println("| 5. Delete User               |");
        System.out.println("| 6. Quit                      |");
        System.out.println("+------------------------------+");
        System.out.println("Note : Only members may edit jokes or categories, and only admins may verify jokes and edit user accounts");
        System.out.println("Please enter the number corresponding to your menu choice : ");
    }

    @Override
    public void showAdminMenu() {
        System.out.println("+------------------------------+");
        System.out.println("| 1. Verify Jokes              |");
        System.out.println("| 2. Update User               |");
        System.out.println("| 3. Delete User               |");
        System.out.println("| 4. Quit                      |");
        System.out.println("+------------------------------+");
        System.out.println("Note : Only members may edit jokes or categories, and only admins may verify jokes and edit user accounts");
        System.out.println("Please enter the number corresponding to your menu choice : ");
    }

    @Override
    public void run() {

        showMainMenu();

        Scanner input = new Scanner(System.in);

        String userChoice = input.nextLine();

        switch (userChoice) {
            case "1": {
                System.out.println("Please enter your username : ");
                String username = input.nextLine();
                System.out.println("Please enter your password : ");
                String password = input.nextLine();

                UserRepoImpl user = new UserRepoImpl();
                user.createUser(username, password);

                break;
            }
            case "2": {
                System.out.println("Please enter your username : ");
                String username = input.nextLine();
                System.out.println("Please enter your password : ");
                String password = input.nextLine();

                UserRepoImpl user = new UserRepoImpl();
                user.userLogin(username, password);

                showUserMenu();

                userChoice = input.nextLine();

                switch (userChoice) {
                    case "1": {
                        JokesRepoImpl.getJokeOfTheDay();
                        break;
                    }
                    case "2": {
                        JokesRepoImpl.getVerifiedJokes();
                        break;
                    }
                    case "3": {
                        CategoriesRepoImpl.getCategories();
                        break;
                    }
                    case "4": {
                        System.out.println("Please enter your username : ");
                        username = input.nextLine();

                        user = new UserRepoImpl();
                        user.createMember(username);
                        break;
                    }
                    case "5": {
                        System.out.println("Please contact an admin to update your account details");
                        break;
                    }
                    case "6": {
                        System.out.println("Please contact an admin to delete your account");
                        break;
                    }
                    case "7": {
                        System.out.println("Quitting the program");
                        break;
                    }
                }
            }
            break;

            case "3": {
                System.out.println("Please enter your username : ");
                String username = input.nextLine();
                System.out.println("Please enter your password : ");
                String password = input.nextLine();

                UserRepoImpl user = new UserRepoImpl();
                user.memberLogin(username, password);

                showMemberMenu();

                userChoice = input.nextLine();

                switch (userChoice) {
                    case "1": {
                        JokesServiceImpl.showJokesMenu();
                        break;
                    }
                    case "2": {
                        CategoriesServiceImpl.showCategoriesMenu();
                        break;
                    }
                    case "3": {
                        System.out.println("Please enter your username : ");
                        username = input.nextLine();

                        user = new UserRepoImpl();
                        user.createAdmin(username);
                        break;
                    }
                    case "4": {
                        System.out.println("Please contact an admin to update your account details");
                        break;
                    }
                    case "5": {
                        System.out.println("Please contact an admin to delete your account");
                        break;
                    }
                    case "6": {
                        System.out.println("Quitting the program");
                        break;
                    }
                }
                break;
            }
            case "4": {
                System.out.println("Please enter your username : ");
                String username = input.nextLine();
                System.out.println("Please enter your password : ");
                String password = input.nextLine();

                UserRepoImpl user = new UserRepoImpl();
                user.adminLogin(username, password);

                showAdminMenu();

                userChoice = input.nextLine();

                switch (userChoice) {
                    case "1": {
                        System.out.println("Please enter the joke category : ");
                        String jokeCategory = input.nextLine();

                        JokesRepoImpl.getJokes(jokeCategory);

                        System.out.println("Please enter the joke text : ");
                        String jokeText = input.nextLine();

                        JokesRepoImpl.verifyJoke(jokeText);
                        break;
                    }
                    case "2": {
                        System.out.println("Please enter your username : ");
                        username = input.nextLine();
                        System.out.println("Please enter your old password : ");
                        password = input.nextLine();
                        System.out.println("Please enter your new password : ");
                        String newPassword = input.nextLine();

                        user = new UserRepoImpl();
                        user.updateUser(username, password, newPassword);
                        break;
                    }
                    case "3": {
                        System.out.println("Please enter your username : ");
                        username = input.nextLine();

                        user = new UserRepoImpl();
                        user.deleteUser(username);
                        break;
                    }
                    case "4": {
                        System.out.println("Quitting the program");
                        break;
                    }
                }
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
