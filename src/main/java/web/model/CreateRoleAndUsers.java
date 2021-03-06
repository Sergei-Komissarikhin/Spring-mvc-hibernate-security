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

        roleService.addRole(new Role("ADMIN"));
        roleService.addRole(new Role("USER"));

        userService.addUser(new User("Sergei", "Ivanov", 37,
                "sus@mail.ru", "1234",
                Set.of(roleService.getRoleByName("ADMIN"), roleService.getRoleByName("USER"))));

        userService.addUser(new User("Anna", "Ivanova", 37,
                "asu@ya.ru", "1234",
                Set.of(roleService.getRoleByName("USER"))));
    }
}