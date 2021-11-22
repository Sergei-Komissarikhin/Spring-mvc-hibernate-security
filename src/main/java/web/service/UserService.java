package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void updateUser(User user, Set<Role> roles);

    void deleteUser(Long id);

    void addUser(User user,Set<Role> roles);
}
