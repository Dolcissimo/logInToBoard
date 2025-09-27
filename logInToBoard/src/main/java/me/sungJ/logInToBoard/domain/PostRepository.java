package me.sungJ.logInToBoard.domain;

import org.springframework.data.jpa.repository.JpaRepository;


//인터페이스 (명세)
public interface PostRepository extends JpaRepository<Post, Long> {

}
