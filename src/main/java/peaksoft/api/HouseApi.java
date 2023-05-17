package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.service.HouseService;

@Controller
@RequestMapping("/houses")
@RequiredArgsConstructor
public class HouseApi {

    private final HouseService service;

    @PutMapping("/assign/{userId}/{houseId}")
    public String assign(@PathVariable("userId") Long userId,
                         @PathVariable("houseId") Long houseId) {
        service.assignHouseToUser(userId, houseId);
        return "";
    }
}
