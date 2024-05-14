package uts.java.parcial2.Services;

import java.util.List;
import uts.java.parcial2.Models.TipoCliente;

public interface ITipoCliente {
    public List<TipoCliente> listar();

    //Buscar producto por id
    public TipoCliente listarId(String CODIGO);

    //Crear un producto
    public void save(TipoCliente tc);

    //Eliminar por id
    public void delete(String CODIGO);
}