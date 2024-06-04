package org.example.pharmashop.Api;
import lombok.RequiredArgsConstructor;
import org.example.pharmashop.Model.User;
import org.example.pharmashop.Service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

    @GetMapping("/sign-in")
    @PreAuthorize("isAnonymous()")
    public String signInPage() {
        return "sign-in";
    }

    @GetMapping("/sign-up")
    @PreAuthorize("isAnonymous()")
    public String signUpPage() {
        return "sign-up";
    }

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String profile() {
        return "profile";
    }

    @PostMapping("/registration")
    @PreAuthorize("isAnonymous()")
    public String registration(@RequestParam(name = "user_email") String email,
                               @RequestParam(name = "user_password") String password,
                               @RequestParam(name = "user_repeat_password") String repeatPassword,
                               @RequestParam(name = "user_full_name") String fullName) {

        Boolean result = userService.signUp(email, password, repeatPassword, fullName);

        if (result != null) {
            if (result) {
                return "redirect:/sign-up?success";
            }

            return "redirect:/sign-up?passwordError";
        }

        return "redirect:/sign-up?emailError";
    }

    @GetMapping("/change-password")
    @PreAuthorize("isAuthenticated()")
    public String changePasswordPage() {
        return "change-password";
    }

    @PostMapping("/save-password")
    @PreAuthorize("isAuthenticated()")
    public String savePassword(@RequestParam(name = "user_old_password") String oldPassword,
                               @RequestParam(name = "user_new_password") String newPassword,
                               @RequestParam(name = "user_repeat_new_password") String repeatNewPassword) {

        Boolean result = userService.updatePassword(oldPassword, newPassword, repeatNewPassword);

        if (result != null) {
            if (result) {
                return "redirect:/change-password?success";
            }

            return "redirect:/change-password?newPasswordError";
        }

        return "redirect:/change-password?oldPasswordError";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String users(Model model) {
        List<User> users=userService.getAllUsers();
        model.addAttribute("users",users);
        return "users";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "users";
    }

}
