package uts.java.proyectobd.controller;

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
import uts.java.proyectobd.model.Productos;
import uts.java.proyectobd.model.Proveedor;
import uts.java.proyectobd.service.ProductosService;
import uts.java.proyectobd.service.ProveedorService;

@Controller
@RequestMapping("/views/productos")
public class ProductosController {
    @Autowired
	private ProductosService servicio;
	@Autowired
	private ProveedorService proveedorService;
	
	@RequestMapping("/")
	public String verIndex(Model model) {
		List<Productos> listaProductos = servicio.listar();
		model.addAttribute("listaProductos",listaProductos);
		return "views/productos/producto";
	}

	@RequestMapping("/new")
	public String mostrarPaginaNuevoProducto(Model model) {
		Productos producto = new Productos();
		List<Proveedor> listaProveedores = proveedorService.getProveedores();
		model.addAttribute("listaProveedores", listaProveedores);
		model.addAttribute("producto", producto);
		return "views/productos/nuevo_producto";
	}

	@PostMapping("/save")
	public String saveProducto(@Valid @ModelAttribute("producto") Productos producto, 
		Errors errores, RedirectAttributes attribute, Model model) {
		if(errores.hasErrors()){
			List<Proveedor> listaProveedores = proveedorService.getProveedores();
			model.addAttribute("listaProveedores", listaProveedores);
			return "views/productos/nuevo_producto";
		}else{
			servicio.save(producto);
			System.out.println("Producto Guardado con exito!");
			attribute.addFlashAttribute("success", "Producto guardado con exito!");
			return "redirect:/views/productos/";
		}	
	}
	
	@GetMapping("/listar/{codigo}")
	public String listarId(@PathVariable int codigo, Model model) {
		model.addAttribute("producto", servicio.listarId(codigo));
		List<Proveedor> listaProveedores = proveedorService.getProveedores();
		model.addAttribute("listaProveedores", listaProveedores);
		return "views/productos/editar_producto";
	}
	
	@RequestMapping("/delete/{codigo}")
	public String deleteProducto(@PathVariable(name = "codigo") int codigo, RedirectAttributes attribute) {
		servicio.delete(codigo);
		System.out.println("Registro eliminado correctamente!");
		attribute.addFlashAttribute("warning", "Registro eliminado correctamente!");
		return "redirect:/views/productos/";
	}
}