package lk.ijse.gdse68.aad.NoteCollectorV2.dto;


import lk.ijse.gdse68.aad.NoteCollectorV2.customObj.UserResponse;
import lk.ijse.gdse68.aad.NoteCollectorV2.entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements SuperDTO, UserResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilepic;
    private List<NoteEntity> notes;
}
