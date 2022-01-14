package bkit.training.SpringBootDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {
  @GetMapping(value = {"","/"})
  public String swagger(){
    return "redirect:swagger-ui.html";
  }
}