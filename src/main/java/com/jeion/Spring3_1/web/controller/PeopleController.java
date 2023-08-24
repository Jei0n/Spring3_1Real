package com.jeion.Spring3_1.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.jeion.Spring3_1.web.model.User;
import com.jeion.Spring3_1.web.service.UserService;
import java.util.List;


@Controller
public class PeopleController {

    private final UserService userService;

    @Autowired
    public PeopleController (UserService userService) {this.userService = userService;}

    @RequestMapping("/")
    public ModelAndView home() {
        List<User> users = userService.listUsers();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("users", users);
        return mav;
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        System.out.println("Редирект");

        return "/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        System.out.println("Добавление");
        userService.add(user);
        return "redirect:/";
    }

    @RequestMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findUser(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
