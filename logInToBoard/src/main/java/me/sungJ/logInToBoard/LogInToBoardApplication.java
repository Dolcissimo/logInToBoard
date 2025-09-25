package me.sungJ.logInToBoard;

import me.sungJ.logInToBoard.application.UserService;
import me.sungJ.logInToBoard.domain.Post;
import me.sungJ.logInToBoard.domain.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LogInToBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogInToBoardApplication.class, args);
	}

    //테스트 로그인 정보
    @Bean
    CommandLineRunner initUser(UserService userService) {
        return args -> {
            userService.register("test", "1234", "테스트유저");
        };
    }

    //테스트 게시글
    @Bean
    CommandLineRunner initPost(PostRepository postRepository) {
        return args -> {
            if (postRepository.count() == 0) {
                postRepository.save(Post.builder()
                        .title("테스트 글")
                        .author("관리자")
                        .content("테스트 내용입니다")
                        .build());
            }
        };
    }

}
