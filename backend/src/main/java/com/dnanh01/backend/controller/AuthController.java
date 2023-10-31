package com.dnanh01.backend.controller;

import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnanh01.backend.config.JwtProvider;
import com.dnanh01.backend.exception.UserException;
import com.dnanh01.backend.model.User;
import com.dnanh01.backend.repository.UserRepository;
import com.dnanh01.backend.request.LoginRequest;
import com.dnanh01.backend.response.AuthResponse;
import com.dnanh01.backend.service.CustomerUserServiceImplementation;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserRepository userRepository;
    private JwtProvider jwtProvider;
    private PasswordEncoder passwordEncoder;
    private CustomAutowireConfigurer customerUserService;

    public AuthController(
            UserRepository userRepository,
            CustomerUserServiceImplementation customerUserService,
            PasswordEncoder passwordEncoder,
            JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.customerUserService = this.customerUserService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {
        String email = user.getEmail();
        String password = user.getPassword();
        String firstNameString = user.getFirstName();
        String lastNameString = user.getLastName();

        User isEmailExist = userRepository.findUserByEmail(email);

        if (isEmailExist != null) {
            throw new UserException("Email is already used with another account");
        }

        User createUser = new User();
        createUser.setFirstName(firstNameString);
        createUser.setLastName(lastNameString);
        createUser.setEmail(email);
        createUser.setPassword(passwordEncoder.encode(password));
        
        User saveUser = userRepository.save(createUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(saveUser.getEmail(),
                saveUser.getPassword());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Signup Success");

        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginRequest) {

        String userName = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Authentication authentication = authenticate(userName, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);
        
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Signin Success");
        
        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
    }

    private Authentication authenticate(String userName, String password) {
        UserDetails userDetails = ((UserDetailsService) customerUserService).loadUserByUsername(userName);

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username...");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password...");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}