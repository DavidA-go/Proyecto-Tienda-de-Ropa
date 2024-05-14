package uts.java.proyectobd.service;

import java.util.List;
import uts.java.proyectobd.model.Proveedor;

public interface IProveedorService {
    //Listar los datos (Select * from proveedor)
    List<Proveedor> getProveedores();

    //Buscar un proveedor por id
    Proveedor buscarProveedor(Integer id);

    //Crear y Grabar un objeto
    Proveedor nuevoProveedor(Proveedor proveedor);

    //Eliminar un objeto de la clase
    void borrarProveedor(Integer id);
}