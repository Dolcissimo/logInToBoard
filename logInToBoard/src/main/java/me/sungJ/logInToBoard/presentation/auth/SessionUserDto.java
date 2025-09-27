package me.sungJ.logInToBoard.presentation.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SessionUserDto {
    private Long id;
    private String username;
    private String name;
}
