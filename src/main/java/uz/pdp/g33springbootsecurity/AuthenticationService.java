package uz.pdp.g33springbootsecurity;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.g33springbootsecurity.config.jtw.JwtProvider;
import uz.pdp.g33springbootsecurity.dto.web.JwtResponse;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final JwtProvider jwtProvider;

    public JwtResponse login(){
        //get user from UserRepo
        User user = User.builder()
                .id(1L)
                .username("John Doe")
                .roles(List.of("ROLE_USER", "ROLE_ADMIN"))
                .build();
        String token = jwtProvider.generate(user);
        return new JwtResponse(token);
    };
}
