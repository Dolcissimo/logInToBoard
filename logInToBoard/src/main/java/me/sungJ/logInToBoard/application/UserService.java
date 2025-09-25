package me.sungJ.logInToBoard.application;

import me.sungJ.logInToBoard.domain.User;
import me.sungJ.logInToBoard.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //로그인 기능 구현
    public User login(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; //null은 수정 예정
    }

    //회원가입 기능 구현
    public User register(String username, String password, String name) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);

        return userRepository.savedUserKey(user);
    }


}
