package Categories.dao;

import Categories.Model.Categories;

import java.util.List;

public interface CategoriesRepo {
    void createCategory(String category);

    static void getCategories() {

    }

    void updateCategory(String category);
    void deleteCategory(String category);
}
