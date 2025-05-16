package del.alstrudat.model;

import del.alstrudat.entity.*;
import del.alstrudat.repository.*;
import java.util.*;

public class CategoryModelImpl implements CategoryModel {
    private final CategoryRepository categoryRepository;

    public CategoryModelImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void addCategory(String id, String name) {
        categoryRepository.addCategory(new Category(id, name));
    }

    @Override
    public Category getCategory(String id) {
        return categoryRepository.getCategoryById(id);
    }

    @Override
    public void updateCategory(String id, String name) {
        Category category = getCategory(id);
        if (category == null) {
            throw new IllegalArgumentException("Kategori tidak ditemukan.");
        }
        category.setName(name);
        categoryRepository.updateCategory(category);
    }

    @Override
    public void deleteCategory(String id) {
        categoryRepository.deleteCategory(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public String toString() {
        return "CategoryModelImpl{categoryRepository=" + categoryRepository + "}";
    }
}