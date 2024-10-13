package lk.ijse.gdse68.aad.NoteCollectorV2.service;

import jakarta.transaction.Transactional;

import lk.ijse.gdse68.aad.NoteCollectorV2.customObj.NoteErrorResponse;
import lk.ijse.gdse68.aad.NoteCollectorV2.customObj.NoteResponse;
import lk.ijse.gdse68.aad.NoteCollectorV2.dao.NoteDao;
import lk.ijse.gdse68.aad.NoteCollectorV2.dao.UserDao;
import lk.ijse.gdse68.aad.NoteCollectorV2.dto.NoteDto;
import lk.ijse.gdse68.aad.NoteCollectorV2.entity.NoteEntity;
import lk.ijse.gdse68.aad.NoteCollectorV2.exception.DataPersistFailedException;
import lk.ijse.gdse68.aad.NoteCollectorV2.exception.NoteNotFound;
import lk.ijse.gdse68.aad.NoteCollectorV2.util.AppUtil;
import lk.ijse.gdse68.aad.NoteCollectorV2.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {
    @Autowired
   private NoteDao noteDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveNote( NoteDto noteDto) {
        noteDto.setNoteId(AppUtil.createNoteId());
        var noteEntity = mapping.convertToEntity(noteDto);

        var savedNote =  noteDao.save(noteEntity);
        if (savedNote == null){
            throw new DataPersistFailedException("cannot saved note");
        }
}
    @Override
    public void updateNote(String noteId, NoteDto incomeNoteDTO) {
        Optional<NoteEntity> tmpNoteEntity= noteDao.findById(noteId);
        if(!tmpNoteEntity.isPresent()){
            throw new NoteNotFound("Note not found");
        }else {
            tmpNoteEntity.get().setNoteDecs(incomeNoteDTO.getNoteDecs());
            tmpNoteEntity.get().setNoteTitle(incomeNoteDTO.getNoteTitle());
            tmpNoteEntity.get().setCreateDate(incomeNoteDTO.getCreateDate());
            tmpNoteEntity.get().setPriorityLevel(incomeNoteDTO.getPriorityLevel());
        }
    }

    @Override
    public void deleteNote(String noteId) {
        Optional<NoteEntity> findId = noteDao.findById(noteId);
        if (!findId.isPresent()) {
            throw new NoteNotFound("Note not found");
        } else {
            noteDao.deleteById(noteId);
        }

    }
    @Override
    public NoteResponse getSelectNote(String noteId) {
        if(noteDao.existsById(noteId)){
            return mapping.convertToDTO(noteDao.getReferenceById(noteId));
        }else {
            return new NoteErrorResponse(0,"Note not found");
        }    }

    @Override
    public List<NoteDto> getAllNote() {
       return  mapping.convertToDTO(noteDao.findAll());
    }

}
