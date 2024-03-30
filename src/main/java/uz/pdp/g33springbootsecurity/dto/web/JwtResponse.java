package uz.pdp.g33springbootsecurity.dto.web;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String accessToken;

    private String refreshToken;

    private LocalDateTime time = LocalDateTime.now();

    public JwtResponse(String accessToken) {
        this.accessToken = accessToken;
    }


}
