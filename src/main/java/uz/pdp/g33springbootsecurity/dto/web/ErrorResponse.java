package uz.pdp.g33springbootsecurity.dto.web;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private String path;
    private String errorCode;
    private String errorMessage;
    private int status;
    @Builder.Default
    private LocalDateTime time = LocalDateTime.now();

}
