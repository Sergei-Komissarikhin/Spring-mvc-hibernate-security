package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserDetailServiceImpl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserDetailServiceImpl userService;
    @Autowired
    public UserController(UserDetailServiceImpl userService) {
        this.userService = userService;
    }


    @RequestMapping()
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }
    @GetMapping(value = "login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/logout")
    public String logoutPage(){
        return "redirect:/admin";
    }

    @GetMapping("/user/{id}")
    public String userShowPage(Principal principal, Model model){
        model.addAttribute("user",userService.loadUserByUsername(principal.getName()));
        return "/user/show";
    }

}
