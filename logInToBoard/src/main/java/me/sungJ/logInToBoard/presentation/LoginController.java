package me.sungJ.logInToBoard.presentation;

import me.sungJ.logInToBoard.application.UserService;
import me.sungJ.logInToBoard.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController (UserService userService) {
        this.userService = userService;
    }

    //로그인 페이지를 보여줌.
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // templates/login.html
    }

    @PostMapping("/login")
    public String login (@RequestParam String username,
                         @RequestParam String password,
                         Model model) {

        User user = userService.login(username, password);

        if (user != null) {
            //로그인 성공할 시
            model.addAttribute("name", user.getName());
            return "login-success";
        } else {
            //로그인 실패 시
            model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다");
            return "login";
        }
    }



}
