package lk.ijse.gdse68.aad.NoteCollectorV2.service;


import jakarta.transaction.Transactional;
import lk.ijse.gdse68.aad.NoteCollectorV2.customObj.UserErrorResponse;
import lk.ijse.gdse68.aad.NoteCollectorV2.customObj.UserResponse;
import lk.ijse.gdse68.aad.NoteCollectorV2.dao.UserDao;
import lk.ijse.gdse68.aad.NoteCollectorV2.dto.UserDTO;
import lk.ijse.gdse68.aad.NoteCollectorV2.entity.UserEntity;
import lk.ijse.gdse68.aad.NoteCollectorV2.exception.DataPersistFailedException;
import lk.ijse.gdse68.aad.NoteCollectorV2.exception.UserNotFoundException;
import lk.ijse.gdse68.aad.NoteCollectorV2.util.AppUtil;
import lk.ijse.gdse68.aad.NoteCollectorV2.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveUser(UserDTO userDTO) {
        userDTO.setUserId(AppUtil.createUserId());
        UserEntity usersave= userDao.save(mapping.convertToUserEntity(userDTO));
        if(usersave == null && usersave.getUserId() == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }    }
    @Override
    public  void updateUser( UserDTO userDTO) {
        //controlling the null point exception
        Optional<UserEntity> updateById=userDao.findById(userDTO.getUserId());
        if(!updateById.isPresent()){
            throw new UserNotFoundException("User not found");
        }else {
            updateById.get().setEmail(userDTO.getEmail());
            updateById.get().setPassword(userDTO.getPassword());
            updateById.get().setFirstName(userDTO.getFirstName());
            updateById.get().setLastName(userDTO.getLastName());
            updateById.get().setProfilepic(userDTO.getProfilepic());

        }    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> selectedUserId = userDao.findById(userId);
        if(selectedUserId.isPresent()){
            userDao.deleteById(userId);
        }else {
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return  mapping.convertToUserDTO(userDao.findAll());
    }
// get user by id using same for note
    @Override
    public UserDTO getSelectUser(String userId) {
        return mapping.convertToUserDTO(userDao.getReferenceById(userId));
    }
    @Override
    public UserResponse getSelectUserBYId(String userId) {
        if(userDao.existsById(userId)){
            UserEntity userEntityByUserId = userDao.getUserEntitiesByUserId(userId);
            return mapping.convertToUserDTO(userEntityByUserId);
        }else {
            return new UserErrorResponse(0, "User not found");
        }
    }
}
