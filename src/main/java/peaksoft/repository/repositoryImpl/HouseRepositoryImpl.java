package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import peaksoft.entity.House;
import peaksoft.entity.User;
import peaksoft.repository.HouseRepository;

@Repository
@RequiredArgsConstructor
public class HouseRepositoryImpl implements HouseRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void assignHouseToUser(Long userId, Long houseId) {
        User user = entityManager.find(User.class, userId);
        House house = entityManager.find(House.class, houseId);
        user.getHouses().add(house);
    }
}
