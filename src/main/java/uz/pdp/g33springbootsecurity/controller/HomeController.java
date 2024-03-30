package uz.pdp.g33springbootsecurity.controller;

import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/")
    public ResponseEntity<?> home() {
        return ResponseEntity.ok(
                Map.of(
                        "currentTime", LocalDateTime.now().toString(),
                        "application-name", applicationName
                ));
    }
}
