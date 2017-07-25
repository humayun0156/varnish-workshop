package varnish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import varnish.model.UserPass;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author humayun
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public void submit(@ModelAttribute UserPass userPass, HttpServletResponse response, Model model) {
        System.out.println("User: " + userPass.getUserName());
        System.out.println("Pass: " + userPass.getPassword());
        Cookie ck = new Cookie("user", userPass.getUserName());
        ck.setMaxAge(3600);
        ck.setPath("/");
        response.addCookie(ck);
        model.addAttribute("page", "index");

        try {
            response.sendRedirect("/gallery");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
