package me.sungJ.logInToBoard.domain;


import java.util.Optional;

//인터페이스 (명세)
public interface UserRepository {

    User savedUserKey(User user);
    Optional<User> findByUsername(String username);

}
