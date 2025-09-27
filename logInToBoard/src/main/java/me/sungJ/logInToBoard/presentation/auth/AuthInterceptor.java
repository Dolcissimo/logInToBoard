package me.sungJ.logInToBoard.presentation.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession(false);
        SessionUserDto loginUser = (session == null) ?
                null : (SessionUserDto) session.getAttribute("loginUser");

        if (loginUser == null) {
            String requestURI = request.getRequestURI();

            // 게시판 URL 접근 시에 needLogin 파라미터 추가
            if (requestURI.startsWith("/posts")) {
                response.sendRedirect("/login?needLogin=true");
            } else {
                response.sendRedirect("/login");
            }
            return false;
        }
        return true; // 통과
    }
}
