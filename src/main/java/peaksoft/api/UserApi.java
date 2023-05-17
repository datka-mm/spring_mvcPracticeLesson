package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.User;
import peaksoft.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {

    private final UserService service;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "userMainPage";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "userPage";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") Long id,
                         Model model) {
        model.addAttribute("editUser", service.getUserById(id));
        return "updateUser";
    }

    @PostMapping("/updateUser/{id}")
    public String saveUpdate(@ModelAttribute("editUser") User user,
                             @PathVariable("id") Long id) {
        service.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping("/searchUsers")
    public String search(@RequestParam("word") String word,
                         Model model) {
        List<User> users = service.searchUser(word);
        model.addAttribute("foundedUsers", users);
        return "";
    }
}
