package del.alstrudat.repository;

import del.alstrudat.entity.*;
import java.util.*;

public class CategoryRepositoryImpl implements CategoryRepository {
    private final Map<String, Category> categories;

    public CategoryRepositoryImpl() {
        this.categories = new HashMap<>();
    }

    @Override
    public void addCategory(Category category) {
        validateCategory(category);
        if (categories.containsKey(category.getId())) {
            throw new IllegalArgumentException("Kategori sudah ada.");
        }
        categories.put(category.getId(), category);
    }

    @Override
    public Category getCategoryById(String id) {
        validateString(id, "ID");
        return categories.get(id);
    }

    @Override
    public void updateCategory(Category category) {
        validateCategory(category);
        if (!categories.containsKey(category.getId())) {
            throw new IllegalArgumentException("Kategori tidak ditemukan.");
        }
        categories.put(category.getId(), category);
    }

    @Override
    public void deleteCategory(String id) {
        validateString(id, "ID");
        if (categories.remove(id) == null) {
            throw new IllegalArgumentException("Kategori tidak ditemukan.");
        }
    }

    @Override
    public List<Category> getAllCategories() {
        return new ArrayList<>(categories.values());
    }

    @Override
    public String toString() {
        return "CategoryRepositoryImpl{categories=" + categories.size() + "}";
    }

    private void validateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Kategori tidak valid: tidak boleh null.");
        }
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}