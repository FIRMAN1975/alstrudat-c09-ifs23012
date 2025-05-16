package del.alstrudat.model;

import del.alstrudat.entity.*;
import del.alstrudat.repository.*;
import java.util.*;

public class UserModelImpl implements UserModel {
    private final UserRepository userRepository;

    public UserModelImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(String username, String password, User.Role role) {
        userRepository.addUser(new User(username, password, role));
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userRepository.getUserByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Username atau password salah.");
        }
        return user;
    }

    @Override
    public void updatePassword(String username, String newPassword) {
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("Pengguna tidak ditemukan.");
        }
        user.setPassword(newPassword);
        userRepository.updateUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public String toString() {
        return "UserModelImpl{userRepository=" + userRepository + "}";
    }
}