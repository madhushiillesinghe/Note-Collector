package lk.ijse.gdse68.aad.NoteCollectorV2.controller;



import lk.ijse.gdse68.aad.NoteCollectorV2.customObj.NoteResponse;
import lk.ijse.gdse68.aad.NoteCollectorV2.dto.NoteDto;
import lk.ijse.gdse68.aad.NoteCollectorV2.exception.DataPersistFailedException;
import lk.ijse.gdse68.aad.NoteCollectorV2.exception.NoteNotFound;
import lk.ijse.gdse68.aad.NoteCollectorV2.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
@RequiredArgsConstructor
public class NoteController {

    @Autowired
    private final NoteService noteService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createNote(@RequestBody NoteDto note) {
        if (note == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                System.out.println(note + " Controller");
                noteService.saveNote(note);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    @GetMapping(value = "/allnotes",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDto> getAllNotes(){
        return noteService.getAllNote();
    }
    @GetMapping(value = "/{noteId}",produces =MediaType.APPLICATION_JSON_VALUE )
    public NoteResponse getNote(@PathVariable("noteId") String noteId){
        return noteService.getSelectNote(noteId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{noteId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateNote(@PathVariable ("noteId") String noteId, @RequestBody NoteDto note) {
        try {
            if (note == null && (noteId == null || note.equals(""))){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            noteService.updateNote(noteId, note);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NoteNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    restfull widiyt karanne
    @DeleteMapping(value = "/{noteId}")
//    responsee entity is object using spring
    public ResponseEntity<Void> deleteNote(@PathVariable ("noteId") String noteId) {
        try{
            noteService.deleteNote(noteId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (NoteNotFound e){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
    }
