package uts.java.proyectobd.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uts.java.proyectobd.model.Proveedor;
import uts.java.proyectobd.service.ProveedorService;

@Controller
@RequestMapping("/views/proveedor") //Agregamos un link de acceso al controlador
public class ProveedorController {
    //Instanciar un objeto de la clase servicio
    @Autowired
    ProveedorService proveedorService;

    @GetMapping("/")
    public String verIndex(Model model){
        List<Proveedor> ListaProveedores = proveedorService.getProveedores();
        model.addAttribute("listaProveedores", ListaProveedores);
        return "views/proveedor/proveedor";
    }

    //Abre la pagina para crear el nuevo proveedor
    @GetMapping("/new")
    public String mostrarPaginaNuevoProveedor(Model model){
        Proveedor Proveedor = new Proveedor();
        model.addAttribute("proveedor", Proveedor);
        return "views/proveedor/nuevo_proveedor";
    }

    //Guarda el objeto en la clase y por ende el registro en la tabla
    @PostMapping("/save")
    public String saveProveedor(Proveedor proveedor, Model model) {
        proveedorService.nuevoProveedor(proveedor);
        return "redirect:/views/proveedor/";
    }
    
    @GetMapping("/listar/{nit}")
    public String listarId(@PathVariable int nit, Model model){
        model.addAttribute("proveedor", proveedorService.buscarProveedor(nit));
        return "views/proveedor/editar_proveedor";
    }

    @RequestMapping("/delete/{nit}")
    public String deleteProducto(@PathVariable(name = "nit") int nit, RedirectAttributes attribute){
        try{
            proveedorService.borrarProveedor(nit);
            System.out.println("Proveedor eliminado correctamente!");
            attribute.addAttribute("info", "Proveedor eliminado correctamente!");
        }catch (Exception e){

        }
        proveedorService.borrarProveedor(nit);
        return "redirect:/views/proveedor/";
    }
}