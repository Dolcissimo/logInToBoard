package me.sungJ.logInToBoard.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
public class User {

    private Long id;

    private String username;
    private String password;
    private String name;

}
