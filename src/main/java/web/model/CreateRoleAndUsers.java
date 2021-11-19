package web.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class CreateRoleAndUsers {
    private final UserService userService;

    @Autowired
    public CreateRoleAndUsers(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    void createUsers() {
        userService.addUser(new User("Sergei", "Komissarikhin", 37
                , "sus@mail.ru", "*********", "Admin"));
    }
}
