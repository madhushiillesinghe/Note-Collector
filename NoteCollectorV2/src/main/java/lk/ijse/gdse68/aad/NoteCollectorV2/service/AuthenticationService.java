package lk.ijse.gdse68.aad.NoteCollectorV2.service;


import lk.ijse.gdse68.aad.NoteCollectorV2.dto.UserDTO;
import lk.ijse.gdse68.aad.NoteCollectorV2.jwtmodels.JwtAuthResponse;
import lk.ijse.gdse68.aad.NoteCollectorV2.jwtmodels.SignIn;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(UserDTO signUp);
    JwtAuthResponse refreshToken(String accessToken);
}