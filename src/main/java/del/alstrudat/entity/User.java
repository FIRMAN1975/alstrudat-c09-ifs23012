package del.alstrudat.entity;

public class User {
    public enum Role {
        BUYER, SELLER, ADMIN
    }

    private final String username;
    private String password;
    private final Role role;

    public User(String username, String password, Role role) {
        validateString(username, "Username");
        validateString(password, "Password");
        if (role == null) {
            throw new IllegalArgumentException("Role tidak valid: tidak boleh null.");
        }
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setPassword(String password) {
        validateString(password, "Password");
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', role=" + role + "}";
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}