package del.alstrudat.repository;

import del.alstrudat.entity.*;
import java.util.*;


public class UserRepositoryImpl implements UserRepository {
    private final Map<String, User> users;

    public UserRepositoryImpl() {
        this.users = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        validateUser(user);
        if (users.containsKey(user.getUsername())) {
            throw new IllegalArgumentException("Pengguna sudah ada.");
        }
        users.put(user.getUsername(), user);
    }

    @Override
    public User getUserByUsername(String username) {
        validateString(username, "Username");
        return users.get(username);
    }

    @Override
    public void updateUser(User user) {
        validateUser(user);
        if (!users.containsKey(user.getUsername())) {
            throw new IllegalArgumentException("Pengguna tidak ditemukan.");
        }
        users.put(user.getUsername(), user);
    }

    @Override
    public void deleteUser(String username) {
        validateString(username, "Username");
        if (users.remove(username) == null) {
            throw new IllegalArgumentException("Pengguna tidak ditemukan.");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public String toString() {
        return "UserRepositoryImpl{users=" + users.size() + "}";
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Pengguna tidak valid: tidak boleh null.");
        }
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}