package me.sungJ.logInToBoard;

import me.sungJ.logInToBoard.application.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LogInToBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogInToBoardApplication.class, args);
	}

    //테스트 로그인 정보
    @Bean
    CommandLineRunner init(UserService userService) {
        return args -> {
            userService.register("test", "1234", "테스트유저");
        };
    }

}
