package peaksoft.service;

import peaksoft.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

//    void assignHouseToUser(Long userId, Long houseId);

    void updateUser(Long id, User user);

    void deleteUserById(Long id);

    List<User> searchUser(String word);
}
