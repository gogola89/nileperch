package com.george.nileperch.web.front;

import com.george.nileperch.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author wladek
 */
@Controller
public class LoginController {

    @RequestMapping("/users/loginform")
    public String signin(Model model) {
        model.addAttribute("user", new User());
        return "/front/users/loginform";
    }

    @RequestMapping("/users/loginfailure")
    public String signinFailure(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("isFailed", true);
        return "redirect:/users/loginform";
    }

}
