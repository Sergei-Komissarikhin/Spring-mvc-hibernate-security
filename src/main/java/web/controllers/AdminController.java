package web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final List<String> roles;

    @Autowired
    public AdminController(UserService userService) {
        roles = new ArrayList<>();
        roles.add("Admin");
        roles.add("User");
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "admin/index";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        System.out.println("hello");
        return "admin/show";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("roles",roles);
        model.addAttribute("user", new User());
        return "admin/new";
    }


    @PostMapping()
    public String createUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id,
                       Model model){
        model.addAttribute("roles",roles);
        model.addAttribute("user",userService.getUserById(id));
        return "admin/edit";
    }

    @PatchMapping("{id}")
    public String update(@PathVariable("id") long id,
                         @ModelAttribute("user") User user){
        System.out.println("Пользователь " + user + " изменен");
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }

}
