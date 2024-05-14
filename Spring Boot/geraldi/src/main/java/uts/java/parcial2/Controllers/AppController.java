package uts.java.parcial2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {
    //Metodo para generar el inicio del proyecto
    //Abrir la pagina home.html

    @GetMapping({"/", "/inicio"})
    public String index(){
        return "home";
    }
}