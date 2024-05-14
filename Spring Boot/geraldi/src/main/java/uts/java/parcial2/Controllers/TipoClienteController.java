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
import uts.java.parcial2.Models.TipoCliente;
import uts.java.parcial2.Services.TipoClienteService;

@Controller
@RequestMapping("/views/tipocliente")
public class TipoClienteController {
    @Autowired
	private TipoClienteService servicio;

    @RequestMapping("/")
	public String verIndex(Model model) {
		List<TipoCliente> listaTiposCliente = servicio.listar();
		model.addAttribute("listaTiposCliente", listaTiposCliente);
		return "views/tipocliente/tipocliente";
	}

	//Abre la pagina para crear el nuevo proveedor
    @GetMapping("/new")
    public String mostrarPaginaNuevoTipo(Model model){
        TipoCliente tipoCliente = new TipoCliente();
        model.addAttribute("tipocliente", tipoCliente);
        return "views/tipocliente/nuevo_tipocliente";
    }

	//Guarda el objeto en la clase y por ende el registro en la tabla
    @PostMapping("/save")
    public String saveTipoCliente(TipoCliente tipoCliente, Model model) {
        servicio.save(tipoCliente);
        return "redirect:/views/tipocliente/";
    }
    
    @GetMapping("/listar/{CODIGO}")
    public String listarId(@PathVariable String CODIGO, Model model){
        model.addAttribute("tipocliente", servicio.listarId(CODIGO));
        return "views/tipocliente/editar_tipocliente";
    }

    @RequestMapping("/delete/{CODIGO}")
    public String deleteProducto(@PathVariable(name = "CODIGO") String CODIGO, RedirectAttributes attribute){
        try{
            servicio.delete(CODIGO);
            System.out.println("Tipo de Cliente eliminado correctamente!");
            attribute.addAttribute("info", "Tipo de Cliente eliminado correctamente!");
        }catch (Exception e){
            e.printStackTrace();
        }
        servicio.delete(CODIGO);
        return "redirect:/views/tipocliente/";
    }
}