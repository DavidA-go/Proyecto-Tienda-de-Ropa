package uts.java.parcial2.Services;

import java.util.List;
import uts.java.parcial2.Models.EstadoCliente;

public interface IEstadoCliente {
     public List<EstadoCliente> listar();

    //Buscar producto por id
    public EstadoCliente listarId(String CODIGO);

    //Crear un producto
    public void save(EstadoCliente ec);

    //Eliminar por id
    public void delete(String CODIGO);

}
