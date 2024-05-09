package Categories.Service;

import Categories.Model.Categories;
import Categories.dao.CategoriesRepoImpl;
import User.dao.UserRepoImpl;

import java.util.List;
import java.util.Scanner;

public class CategoriesServiceImpl extends CategoriesRepoImpl implements CategoriesService{

    public static void showCategoriesMenu() {
        System.out.println("+---------------------+");
        System.out.println("| 1. Create Category  |");
        System.out.println("| 2. Get Categories   |");
        System.out.println("| 3. Update Category  |");
        System.out.println("| 4. Delete Category  |");
        System.out.println("| 5. Quit             |");
        System.out.println("+---------------------+");

        Scanner input = new Scanner(System.in);
        String userChoice = input.nextLine();

        switch (userChoice) {
            case "1": {
                System.out.println("Please enter the category name : ");
                String categoryName = input.nextLine();

                CategoriesRepoImpl category = new CategoriesRepoImpl();
                category.createCategory(categoryName);

                System.out.println("Category was created successfully");
                break;
            }
            case "2": {
                CategoriesRepoImpl category = new CategoriesRepoImpl();
                category.getCategories();

                System.out.println("Categories were retrieved successfully");
                break;
            }
            case "3": {
                System.out.println("Please enter the category name : ");
                String categoryName = input.nextLine();

                CategoriesRepoImpl category = new CategoriesRepoImpl();
                category.updateCategory(categoryName);

                System.out.println("Category was updated successfully");
                break;
            }
            case "4": {
                System.out.println("Please enter the category name : ");
                String categoryName = input.nextLine();

                CategoriesRepoImpl category = new CategoriesRepoImpl();
                category.deleteCategory(categoryName);

                System.out.println("Category was deleted successfully");
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
