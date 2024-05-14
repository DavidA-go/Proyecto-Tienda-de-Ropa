package uts.java.proyectobd.service;

import java.util.List;
import uts.java.proyectobd.model.Productos;

public interface IProductosService {
    //Definir los encabezados de los metodos a implementar
    //Mostrar todos los datos
    public List<Productos> listar();

    //Buscar producto por id
    public Productos listarId(int id);

    //Crear un producto
    public void save(Productos p);

    //Eliminar por id
    public void delete(int id);
}