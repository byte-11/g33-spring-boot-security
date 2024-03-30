package uz.pdp.g33springbootsecurity;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {
    private Long id;

    private String username;

    private String password;

    private List<String> roles;
}
