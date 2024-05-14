package uts.java.proyectobd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import uts.java.proyectobd.model.Proveedor;
import uts.java.proyectobd.repository.ProveedorRepository;


@Service
@Transactional
public class ProveedorService implements IProveedorService{
    @Autowired
    ProveedorRepository proveedorRepositorio;

    @Override
    public List<Proveedor> getProveedores(){
        return proveedorRepositorio.findAll();
    }

    @Override
    public Proveedor nuevoProveedor(Proveedor proveedor){
        return proveedorRepositorio.save(proveedor);
    }

    @Override
    public Proveedor buscarProveedor(Integer id) {
        return proveedorRepositorio.findById(id).orElse(null);
    }

    @Override
    public void borrarProveedor(Integer id){
        proveedorRepositorio.deleteById(id);
    }
}