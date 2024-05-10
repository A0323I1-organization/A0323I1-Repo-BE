package a0323i_cinema_professtional_be.controller;

import a0323i_cinema_professtional_be.dto.CustomerDto;
import a0323i_cinema_professtional_be.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class CustomerController {
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private CustomerService customerService;


    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") CustomerDto userDto) {
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") CustomerDto customerDto, Model model) {
        customerService.save(customerDto);
        model.addAttribute("message", "Registered Successfully!");
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("user-page")
    public String userPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "user";
    }

    @GetMapping("admin-page")
    public String adminPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "admin";
    }
}
