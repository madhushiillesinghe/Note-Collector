package lk.ijse.gdse68.aad.NoteCollectorV2.service;




import lk.ijse.gdse68.aad.NoteCollectorV2.customObj.NoteResponse;
import lk.ijse.gdse68.aad.NoteCollectorV2.dto.NoteDto;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDto noteDTO);
    void updateNote(String noteId,NoteDto noteDTO);
    void deleteNote(String noteId);
    NoteResponse getSelectedNote(String noteId);
    List<NoteDto> getAllNotes();
}