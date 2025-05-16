package del.alstrudat.model;

import del.alstrudat.entity.*;
import java.util.*;

public interface CategoryModel {
    void addCategory(String id, String name);
    Category getCategory(String id);
    void updateCategory(String id, String name);
    void deleteCategory(String id);
    List<Category> getAllCategories();
}