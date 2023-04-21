package Zamay.PP312.v.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPageController {
    @GetMapping()
    public String hello() {
        return "hello";
    }
}
