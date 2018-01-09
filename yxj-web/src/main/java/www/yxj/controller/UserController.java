package www.yxj.controller;

import www.yxj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import www.yxj.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/")
    public String Index(Model model){
        User user = userService.findUserById(1);
        model.addAttribute("userInfo",user);
        System.out.println("==============="+user.getName()+"===============");
        return "index";
    }
}
