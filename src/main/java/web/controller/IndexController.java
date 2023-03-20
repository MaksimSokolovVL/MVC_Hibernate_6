package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/")
    public String allUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();

        model.addAttribute("edit_user", user);
        return "edit-user";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("edit_user") User user) {
        if (user.getId() != 0) {
            userService.updateUser(user);
        } else {
            userService.addNewUser(user);
        }
        return "redirect:/";
    }

    @PostMapping("/updateInfo")
    public String updateUser(@RequestParam("empId") long id, Model model) {
        model.addAttribute("edit_user", userService.getUserForId(id));
        return "edit-user";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("empId") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}