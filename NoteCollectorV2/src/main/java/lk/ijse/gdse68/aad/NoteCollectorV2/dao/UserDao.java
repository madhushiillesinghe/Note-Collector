package lk.ijse.gdse68.aad.NoteCollectorV2.dao;


import lk.ijse.gdse68.aad.NoteCollectorV2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, String> {

    UserEntity getUserEntitiesByUserId(String userId);
}
