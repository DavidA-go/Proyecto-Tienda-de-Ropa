package uts.java.parcial2.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import uts.java.parcial2.Models.Cliente;
import uts.java.parcial2.Models.EstadoCliente;
import uts.java.parcial2.Models.TipoCliente;
import uts.java.parcial2.Services.ClienteService;
import uts.java.parcial2.Services.EstadoClienteService;
import uts.java.parcial2.Services.TipoClienteService;

@Controller
@RequestMapping("/views/cliente")
public class ClienteController {
    @Autowired
	private ClienteService servicio;
	@Autowired
	private TipoClienteService tipoClienteService;
	@Autowired
	private EstadoClienteService estadoClienteService;

    @RequestMapping("/")
	public String verIndex(Model model) {
		List<Cliente> listaCliente = servicio.listar();
		model.addAttribute("listaCliente", listaCliente);
		return "views/cliente/cliente";
	}

    @RequestMapping("/new")
	public String mostrarPaginaNuevoProducto(Model model) {
		Cliente cliente = new Cliente();
		List<TipoCliente> listaTipoCliente = tipoClienteService.listar();
		List<EstadoCliente> listaEstadoCliente = estadoClienteService.listar();
		model.addAttribute("listaTiposCliente", listaTipoCliente);
		model.addAttribute("listaEstadoCliente", listaEstadoCliente);
		model.addAttribute("cliente", cliente);
		return "views/cliente/nuevo_cliente";
	}

    @PostMapping("/save")
	public String saveCliente(@Valid @ModelAttribute("cliente") Cliente cliente, 
		Errors errores, RedirectAttributes attribute, Model model) {
				servicio.save(cliente);
				System.out.println("Cliente Guardado con exito!");
				attribute.addFlashAttribute("success", "Cliente guardado con exito!");
				return "redirect:/views/cliente/";		
	}

    @GetMapping("/listar/{CODIGOCLIENTE}")
	public String listarId(@PathVariable float CODIGOCLIENTE, Model model) {
		model.addAttribute("cliente", servicio.listarId(CODIGOCLIENTE));
		List<TipoCliente> listaTiposCliente = tipoClienteService.listar();
		model.addAttribute("listaTiposCliente", listaTiposCliente);
		List<EstadoCliente> listaEstadoCliente = estadoClienteService.listar();
		model.addAttribute("listaEstadoCliente", listaEstadoCliente);
		return "views/cliente/editar_cliente";
	}

    @RequestMapping("/delete/{CODIGOCLIENTE}")
	public String deleteProducto(@PathVariable(name = "CODIGOCLIENTE") float CODIGOCLIENTE, RedirectAttributes attribute) {
		servicio.delete(CODIGOCLIENTE);
		System.out.println("Cliente eliminado correctamente!");
		attribute.addFlashAttribute("warning", "Cliente eliminado correctamente!");
		return "redirect:/views/cliente/";
	}

}
