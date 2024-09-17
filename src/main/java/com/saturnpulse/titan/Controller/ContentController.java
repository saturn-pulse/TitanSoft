package com.saturnpulse.titan.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ContentController {

    @GetMapping("/req/login")
    public String login() {
        return "login";
    }

    @GetMapping("/req/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/index")
    public String home(Model model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();


        Object principal = authentication.getPrincipal();


        // Assuming you have a UserDetails implementation and it has a getId() method
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            String userId = userDetails.getUsername();
            // or another method to get user ID
            log.error(userId);
            model.addAttribute("userId", userId);


        }
        return "index";

    }
}
