package web.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;

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
        userService.addUser(new User("Sergei", "Komissarikhin", 37
                , "sus@mail.ru", "*********", "Admin"));
        roleService.addRole(new Role("Admin"));
    }
}
