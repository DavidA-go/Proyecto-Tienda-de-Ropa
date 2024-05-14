package uts.java.form.controllers;

import java.util.Arrays;
import java.util.List;

import uts.java.form.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class MainController {
    //Tipo de operacion y su nombre para ejecucion
    @GetMapping("/registro")
    public String showForm(Model model){
        Usuario user = new Usuario();
        
        //Variable a usar en la vista
        model.addAttribute( "user", user);

        //Variable con la lista de profesiones
        List<String> listProfession = Arrays.asList("Desarrollador", "Tester", "Arquitecto"); // Corrección aquí
        model.addAttribute("listProfession", listProfession);

        //El nombre de la vista hacia donde se debe ir
        return "register_form";
    }

    @PostMapping("/mostrar")
	public String submitForm(@ModelAttribute("user") Usuario user) {
		System.out.println(user.toString());
		return "register_success";
	}

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}