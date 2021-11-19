package web.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.expression.Sets;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
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

        Set<Role> roles = new HashSet<>();
        roles.add(new Role("admin"));
        roles.add(new Role("user"));

        userService.addUser(new User("Sergei", "Komissarikhin", 37
                , "sus@mail.ru", "*********", "Admin"
                , roles));

    }
}
