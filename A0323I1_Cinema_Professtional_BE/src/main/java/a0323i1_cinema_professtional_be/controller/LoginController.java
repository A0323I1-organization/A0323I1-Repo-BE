package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.security.JwtResponse;
import a0323i1_cinema_professtional_be.security.JwtServiceImpl;
import a0323i1_cinema_professtional_be.security.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private JwtServiceImpl jwtService;

    @PostMapping({"/auth/login"})
    public JwtResponse createJwtToken(@RequestBody LoginRequest loginRequest) throws Exception {
        return jwtService.createJwtToken(loginRequest);
    }
}
