package del.alstrudat.model;

import del.alstrudat.entity.*;
import java.util.*;

public interface UserModel {
    void registerUser(String username, String password, User.Role role);
    User loginUser(String username, String password);
    void updatePassword(String username, String newPassword);
    List<User> getAllUsers();
}