package com.example.pwbackend.Services;



import com.example.pwbackend.Models.*;
import com.example.pwbackend.Models.Bodies.AuthenticationRequest;
import com.example.pwbackend.Models.Bodies.AuthenticationResponse;
import com.example.pwbackend.Models.Bodies.RegisterRequest;
import com.example.pwbackend.Models.Entities.Token;
import com.example.pwbackend.Models.Entities.User;
import com.example.pwbackend.Repositories.TokenRepository;
import com.example.pwbackend.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthenticationService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private TokenRepository tokenRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private JwtService jwtService;
  @Autowired
  private AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {

    User user = User.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .username(request.getUsername())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(request.getRole())
            .build();

    User savedUser = userRepository.save(user);

    String jwtToken = jwtService.generateToken(savedUser);
    saveUserToken(savedUser, jwtToken);

    return AuthenticationResponse.builder()
        .userId(savedUser.getId())
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getUsername(),
            request.getPassword()
        )
    );

    User user = userRepository.getUserByUsername(request.getUsername())
        .orElseThrow();

    var jwtToken = jwtService.generateToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);

    return AuthenticationResponse.builder()
        .userId(user.getId())
        .token(jwtToken)
        .build();
  }

  private void saveUserToken(User user, String jwtToken) {
    Token token = Token.builder()
        .user(user)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(User user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }

  public Boolean validate(String token) {
    throw new RuntimeException("AuthenticationService.validate() not implemented");
  }
}
