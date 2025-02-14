package org.example.pharmashop.Service.Impl;


import org.example.pharmashop.Model.Permission;
import org.example.pharmashop.Model.User;
import org.example.pharmashop.Repository.PermissionRepository;
import org.example.pharmashop.Repository.UserRepository;
import org.example.pharmashop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if(user!=null)
            return user;
        throw new UsernameNotFoundException("User Not Found");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User user = (User) authentication.getPrincipal();
            return user;
        }

        return null;
    }

    @Override
    public Boolean signUp(String email, String password, String repeatPassword, String fullName) {
        User u = userRepository.findByEmail(email);

        if(u == null) {
            if(password.equals(repeatPassword)){
                List<Permission> permissions = new ArrayList<>();
                Permission simplePermission = permissionRepository.findByPermission("ROLE_USER");
                permissions.add(simplePermission);

                User newUser = new User();
                newUser.setEmail(email);
                newUser.setPassword(passwordEncoder.encode(password));
                newUser.setFullName(fullName);
                newUser.setRoles(permissions);

                userRepository.save(newUser);

                return true;
            }

            return false;
        }

        return null;
    }

    @Override
    public Boolean updatePassword(String oldPassword, String newPassword, String repeatNewPassword) {
        User currentUser = getCurrentUser();

        if(currentUser != null){
            if(passwordEncoder.matches(oldPassword, currentUser.getPassword())){
                if(newPassword.equals(repeatNewPassword)){
                    currentUser.setPassword(passwordEncoder.encode(newPassword));
                    userRepository.save(currentUser);
                    return true;
                }

                return false;
            }

            return null;
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
