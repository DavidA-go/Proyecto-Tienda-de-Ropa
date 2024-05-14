package uts.java.parcial2.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import uts.java.parcial2.Models.EstadoCliente;
import uts.java.parcial2.Repositories.EstadoClienteRepo;

@Service
@Transactional
public class EstadoClienteService implements IEstadoCliente {
    @Autowired
    private EstadoClienteRepo repo;

    @Override
    public List<EstadoCliente> listar(){
        return repo.findAll();
    }

    @Override
    public EstadoCliente listarId(String CODIGO){
        return repo.findById(CODIGO).get();
    }

    @Override
    public void save(EstadoCliente ec){
        repo.save(ec);
    }
    
    @Override
    public void delete(String CODIGO){
        repo.deleteById(CODIGO);
    }
}