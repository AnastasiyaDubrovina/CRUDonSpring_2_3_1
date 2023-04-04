package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/")
public class UserController {
//   @Autowired
//    @Qualifier
private UserService userService;
    /////////////////////////////////////////
    //3. В приложении должна быть страница, на которую выводятся все юзеры с возможностью добавлять, удалять и изменять юзера.
    /////////////////////////////////////////

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        //добавить на страницу ссылку для добавления нового юзера
        //имя юзера сделать в виде ссылки для перехода на его страницу для изменения или удаления
        return "users";
    }

    @GetMapping("/users/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        //просмотр страницы юзера, добавить ссылку для изменениея и удаления юзера
        model.addAttribute("user", userService.showById(id));
        return "show";
    }


}
