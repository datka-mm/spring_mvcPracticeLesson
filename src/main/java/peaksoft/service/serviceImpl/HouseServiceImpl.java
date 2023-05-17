package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.repository.HouseRepository;
import peaksoft.service.HouseService;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;

    @Override
    public void assignHouseToUser(Long userId, Long houseId) {
        houseRepository.assignHouseToUser(userId, houseId);
    }
}
