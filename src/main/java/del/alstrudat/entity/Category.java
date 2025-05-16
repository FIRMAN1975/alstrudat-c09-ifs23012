package del.alstrudat.entity;

public class Category {
    private final String id;
    private String name;

    public Category(String id, String name) {
        validateString(id, "ID");
        validateString(name, "Name");
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateString(name, "Name");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{id='" + id + "', name='" + name + "'}";
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}