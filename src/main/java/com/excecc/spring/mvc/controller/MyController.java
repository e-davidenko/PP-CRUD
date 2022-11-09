package com.excecc.spring.mvc.controller;
import com.excecc.spring.mvc.entity.User;
import com.excecc.spring.mvc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * Created in Intellij
 * User: Davidenko
 * Date: 05.11.2022
 * Time: 20:27
 */

@Controller
@RequestMapping("/users")
public class MyController {
    private final UserService userService;
    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    //===========================================================================//

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        } else {
            userService.saveUser(user);
            return "redirect:/users";
        }
    }

    //============================================================================//

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {
        System.out.println("Click update");
        if (bindingResult.hasErrors())
            return "edit";

        userService.updateUser(id, user);
        return "redirect:/users";
    }


    //============================================================================//


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        System.out.println("Click delete");
        User user = userService.getUser(id);
        userService.removeUser(user);

        return "redirect:/users";
    }
}












//    @RequestMapping("/")
//    public String showAllUsers(Model model) {
//        List<User> allUsers = userService.getAllUsers();
//        model.addAttribute("allUsers", allUsers);
//        return "all-users";
//    }
//    @RequestMapping("/user")
//    public String addNewUser(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "user-info";
//    }
//
//    @RequestMapping("/saveUser")
//    public String saveUser(@ModelAttribute("user") User user) {
//        userService.saveUser(user);
//        return "redirect:/";
//    }
//
//    @RequestMapping(value = "/user", params = "userId")
//    public String updateInfo(@RequestParam("userId") int id, Model model) {
//        User user = userService.getUser(id);
//        model.addAttribute("user", user);
//        return "user-info";
//    }
//
//    @RequestMapping("/addNewUser/saveUser")
//    public String updateUser(@ModelAttribute("user") User user) {
//        userService.updateUser(user);
//        return "redirect:/";
//    }
//
//    @RequestMapping(value = "/removeUser")
//    public String removeUser(@RequestParam("userId") int id) {
//        System.out.println(id);
//        User user = userService.getUser(id);
//        System.out.println(user.getId());
//        userService.removeUser(user);
//        return "redirect:/";
//    }
