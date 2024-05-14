package uts.java.parcial2.Services;

import java.util.List;
import uts.java.parcial2.Models.Cliente;

public interface ICliente {
    public List<Cliente> listar();

    //Buscar producto por id
    public Cliente listarId(float CODIGOCLIENTE);

    //Crear un producto
    public void save(Cliente c);

    //Eliminar por id
    public void delete(float CODIGOCLIENTE);
}