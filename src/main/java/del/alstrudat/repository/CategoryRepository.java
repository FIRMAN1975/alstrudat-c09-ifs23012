package del.alstrudat.repository;

import del.alstrudat.entity.*;
import java.util.*;

public interface CategoryRepository {
    void addCategory(Category category);
    Category getCategoryById(String id);
    void updateCategory(Category category);
    void deleteCategory(String id);
    List<Category> getAllCategories();
}