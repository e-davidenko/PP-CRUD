package com.excecc.spring.mvc.controller;
import com.excecc.spring.mvc.entity.User;
import com.excecc.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created in Intellij
 * User: Davidenko
 * Date: 05.11.2022
 * Time: 20:27
 */

@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }
    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @GetMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/addNewUser", params = "userId")
    public String updateInfo(@RequestParam("userId") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @GetMapping("/addNewUser/saveUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/removeUser")
    public String removeUser(@RequestParam("userId") int id) {
        User user = userService.getUser(id);
        userService.removeUser(user);
        return "redirect:/";
    }

}
