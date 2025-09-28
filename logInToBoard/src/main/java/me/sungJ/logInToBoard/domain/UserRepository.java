package me.sungJ.logInToBoard.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스 (명세)
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
