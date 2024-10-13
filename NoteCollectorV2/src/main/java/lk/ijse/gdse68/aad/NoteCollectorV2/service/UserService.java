package lk.ijse.gdse68.aad.NoteCollectorV2.service;



import lk.ijse.gdse68.aad.NoteCollectorV2.customObj.UserResponse;
import lk.ijse.gdse68.aad.NoteCollectorV2.dto.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void deleteUser(String userId);
    List<UserDTO> getAllUsers();
    UserResponse getSelectUserBYId(String userId);
    UserDTO getSelectUser(String userId);
}
