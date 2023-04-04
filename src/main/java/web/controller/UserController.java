package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String index(Model model) {
        //отобразить всех юзеров
        //3. В приложении должна быть страница, на которую выводятся все юзеры с возможностью добавлять, удалять и изменять юзера.
        List<User> userList = new ArrayList<>();
        userList.add(new User( "name1", 10));
        userList.add(new User( "name2", 20));
        userList.add(new User( "name3", 30));

//        userService.saveUser(new User( "name1", 10));
//        userService.saveUser(new User( "name1", 10));
//        userService.saveUser(new User( "name1", 10));
//
        model.addAttribute("users", userService.getAllUsers());
        return "/users";
    }



}
