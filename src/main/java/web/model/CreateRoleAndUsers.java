package web.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class CreateRoleAndUsers {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public CreateRoleAndUsers(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    void createUsers() {

        roleService.addRole(new Role("admin"));
        roleService.addRole(new Role("user"));

        userService.addUser(new User("Sergei", "Komissarikhin", 37,
                "sus@mail.ru", "*********", "Admin",
                Set.of(roleService.getRoleByName("admin"), roleService.getRoleByName("user"))));

        userService.addUser(new User("Anna", "Shimanovskaya", 37,
                "asusai@ya.ru", "************", "User",
                Set.of(roleService.getRoleByName("user"))));
    }
}