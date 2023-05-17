package peaksoft.repository.repositoryImpl;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.User;
import peaksoft.repository.UserRepository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void updateUser(Long id, User user) {
        User foundedUser = entityManager.find(User.class, id);
        foundedUser.setFullName(user.getFullName());
        foundedUser.setPhoto(user.getPhoto());
        foundedUser.setEmail(user.getEmail());
        foundedUser.setAge(user.getAge());
        entityManager.merge(foundedUser);
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public List<User> searchUser(String word) {
        return entityManager.createQuery(
                "select u from User u where u.fullName like :word", User.class)
                .setParameter("word", "%" + word + "%")
                .getResultList();
    }
}
