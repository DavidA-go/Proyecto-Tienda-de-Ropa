package uts.java.parcial2.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uts.java.parcial2.Models.EstadoCliente;
import uts.java.parcial2.Services.EstadoClienteService;

@Controller
@RequestMapping("/views/estadocliente")
public class EstadoClienteController {
    @Autowired
	private EstadoClienteService servicio;

    @RequestMapping("/")
	public String verIndex(Model model) {
		List<EstadoCliente> listaEstadoCliente = servicio.listar();
		model.addAttribute("listaEstadoCliente", listaEstadoCliente);
		return "views/estadocliente/estadocliente";
	}

	//Abre la pagina para crear el nuevo proveedor
    @GetMapping("/new")
    public String mostrarPaginaNuevoTipo(Model model){
        EstadoCliente estadoCliente = new EstadoCliente();
        model.addAttribute("estadocliente", estadoCliente);
        return "views/estadocliente/nuevo_estadocliente";
    }

	//Guarda el objeto en la clase y por ende el registro en la tabla
    @PostMapping("/save")
    public String saveTipoCliente(EstadoCliente estadoCliente, Model model) {
        servicio.save(estadoCliente);
        return "redirect:/views/estadocliente/";
    }
    
    @GetMapping("/listar/{CODIGO}")
    public String listarId(@PathVariable String CODIGO, Model model){
        model.addAttribute("estadocliente", servicio.listarId(CODIGO));
        return "views/estadocliente/editar_estadocliente";
    }

    @RequestMapping("/delete/{CODIGO}")
    public String delete(@PathVariable(name = "CODIGO") String CODIGO, RedirectAttributes attribute){
        try{
            servicio.delete(CODIGO);
            System.out.println("Estado de Cliente eliminado correctamente!");
            attribute.addAttribute("info", "Estado de Cliente eliminado correctamente!");
        }catch (Exception e){
            e.printStackTrace();
        }
        servicio.delete(CODIGO);
        return "redirect:/views/estadocliente/";
    }
}