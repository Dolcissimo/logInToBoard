package me.sungJ.logInToBoard.presentation;

import jakarta.servlet.http.HttpSession;
import me.sungJ.logInToBoard.application.UserService;
import me.sungJ.logInToBoard.domain.User;
import me.sungJ.logInToBoard.presentation.auth.SessionUserDto;
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

    //로그인 페이지를 보여줌
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // templates/login.html
    }

    //로그인 처리 및 인증
    @PostMapping("/login")
    public String login (@RequestParam String username,
                         @RequestParam String password,
                         HttpSession session,
                         Model model) {

        User user = userService.login(username, password);

        if (user != null) {
            //로그인 성공할 시
            session.setAttribute("loginUser",
                    new SessionUserDto(user.getId(), user.getUsername(), user.getName()));

            //로그인 성공페이지로 고
            model.addAttribute("name", user.getName());
            return "login-success";

            //만약 바로 게시판으로 가려면
            // return "redirect:/posts";
        } else {
            //로그인 실패 시
            model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }



}
