package Zamay.PP312.v.controller;

import Zamay.PP312.v.Model.User;
import Zamay.PP312.v.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/list")
public class UsersController {

    private final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String hello(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "usersList";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id")int id, Model model) {
    model.addAttribute("user", userService.getUser(id));
    return "userPage";
    }

    @GetMapping("/new")
    private String createUser(Model model) {
        model.addAttribute("user", new User());

        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute ("user")User user) {
        userService.saveUser(user); //добавить метод
        return "redirect:/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";

    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/list";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id) {
        userService.delete(id);
        return "redirect:/list";
    }

}
