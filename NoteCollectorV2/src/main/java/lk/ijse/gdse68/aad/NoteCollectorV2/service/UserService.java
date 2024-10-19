package lk.ijse.gdse68.aad.NoteCollectorV2.service;

import lk.ijse.gdse68.aad.NoteCollectorV2.customObj.UserResponse;
import lk.ijse.gdse68.aad.NoteCollectorV2.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void deleteUser(String userId);
    UserResponse getSelectedUser(String userId);
    List<UserDTO> getAllUsers();
    UserDetailsService userDetailsService();
}