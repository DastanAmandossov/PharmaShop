package org.example.pharmashop.Api;

import lombok.RequiredArgsConstructor;
import org.example.pharmashop.Service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Long  id){
        userService.deleteById(id);
    }
}
