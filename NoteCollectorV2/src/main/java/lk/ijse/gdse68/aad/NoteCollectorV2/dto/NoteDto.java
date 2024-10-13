package lk.ijse.gdse68.aad.NoteCollectorV2.dto;

import lk.ijse.gdse68.aad.NoteCollectorV2.customObj.NoteResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDto implements  SuperDTO, NoteResponse {
    private String noteId;
    private String noteTitle;
    private String noteDecs;
    private String priorityLevel;
    private String createDate;
    private String userId;
}
