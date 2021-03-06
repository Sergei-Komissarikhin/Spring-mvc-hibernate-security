package web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserDetailServiceImpl;
import web.service.UserService;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserDetailServiceImpl userDetailService;

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, UserDetailServiceImpl userDetailService, RoleService roleService) {
        this.userService = userService;
        this.userDetailService = userDetailService;
        this.roleService = roleService;
    }

    @GetMapping
    public String index(Model model) {

        model.addAttribute("users", userService.getAllUsers());
//        model.addAttribute("roles", roleService.getRoles());
        return "admin/index";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getRoles());
        return "admin/new";
    }


    @PostMapping()
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam("rolesForUser") Set<Role> roles) {
        userService.addUser(user, roles);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id,
                       Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", roleService.getRoles());
        return "admin/edit";
    }

    @PatchMapping("{id}")
    public String update(@PathVariable("id") long id,
                         @ModelAttribute("user") User user,
                         @RequestParam("rolesForUser") Set<Role> roles) {
        userService.updateUser(user, roles);
        return "redirect:/admin";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
