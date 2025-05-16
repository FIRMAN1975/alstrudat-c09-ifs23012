package del.alstrudat.repository;

import del.alstrudat.entity.*;
import java.util.*;


public interface UserRepository {
    void addUser(User user);
    User getUserByUsername(String username);
    void updateUser(User user);
    void deleteUser(String username);
    List<User> getAllUsers();
}