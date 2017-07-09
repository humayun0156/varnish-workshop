package varnish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Index");
        model.addAttribute("page", "index");
        return "index";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About");
        model.addAttribute("page", "about");
        return "index";
    }

    @RequestMapping("/services")
    public String services(Model model) {
        model.addAttribute("title", "Services");
        model.addAttribute("page", "services");
        return "index";
    }

    @RequestMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contact");
        model.addAttribute("page", "contact");
        return "index";
    }


    @RequestMapping("/gallery")
    public String gallery(Model model) {
        model.addAttribute("title", "Gallery");
        model.addAttribute("page", "gallery");
        return "index";
    }





    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/vm")
    public String hellovm(@RequestParam(value="name", required =false, defaultValue ="World!!") String name, Model model) {
        model.addAttribute("name", name);
        return "myvm";
    }

}
