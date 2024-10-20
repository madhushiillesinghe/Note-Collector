package lk.ijse.gdse68.aad.NoteCollectorV2.util;



import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;
public class AppUtil {

    public  static String createNoteId(){
        return "Note" +UUID.randomUUID().toString();
    }
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
    public static String createUserId(){
    return "User"+ UUID.randomUUID().toString();
    }
//    encode-
//    decode-
    public static String toBase64Profilepic(MultipartFile profilepic){
        String profilepicBase64=null;
        try{
            byte [] imagebyteCollection= profilepic.getBytes();
            profilepicBase64= Base64.getEncoder().encodeToString(imagebyteCollection);
        }catch (Exception e){
            e.printStackTrace();
        }
       return profilepicBase64;
    }
}
