package org.example.pharmashop.Service;

import org.example.pharmashop.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    Boolean signUp(String email, String password, String repeatPassword, String fullName);
    Boolean updatePassword(String oldPassword, String newPassword, String repeatNewPassword);
    List<User>getAllUsers();
    void deleteById(Long id);

}