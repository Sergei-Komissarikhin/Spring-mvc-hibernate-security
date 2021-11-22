package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleService roleService;

    public UserServiceImpl(UserDao userDao, RoleService roleService) {
        this.userDao = userDao;
        this.roleService = roleService;
    }


    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void addUser(User user,Set<Role> roles) {
        user.setRoles(getRolesForUpdate(roles));
        userDao.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Long id){
       return userDao.getUserById(id);
    };


    @Override
    public void updateUser(User user, Set<Role> roles) {
        user.setRoles(getRolesForUpdate(roles));
        userDao.updateUser(user);
    }

    public Set<Role> getRolesForUpdate(Set<Role> roles){
        Set<Role> updateRoles = new HashSet<>();
        for(Role role: roles){
            updateRoles.add(roleService.getRoleByName(role.getRole()));
        }
        return updateRoles;
    }


    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
