package uts.java.proyectobd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import uts.java.proyectobd.model.Productos;
import uts.java.proyectobd.repository.ProductosRepository;

@Service
@Transactional
public class ProductosService implements IProductosService {
    @Autowired
    private ProductosRepository repo;

    @Override
    public List<Productos> listar(){
        return repo.findAll();
    }

    @Override
    public Productos listarId(int id){
        return repo.findById(id).get();
    }

    @Override
    public void save(Productos p){
        repo.save(p);
    }

    @Override
    public void delete(int id){
        repo.deleteById(id);
    }
}