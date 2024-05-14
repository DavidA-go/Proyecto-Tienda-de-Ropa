package uts.java.practica1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uts.java.practica1.models.Estudiante;

@Controller
@RequestMapping("/")
public class EstudianteController {

    @GetMapping("/form")
    public String showForm(Model model){
        Estudiante estu = new Estudiante();
        
        //Variable a usar en la vista
        model.addAttribute( "estu", estu);
        
        return "ingDatos";
    }

    @PostMapping("/mostrar")
	public String submitForm(@ModelAttribute("estu") Estudiante estu) {
		System.out.println(estu.toString());
		return "mostrarDatos";
	}

    @GetMapping("/")
    public String index(){
        return "index";
    }
}