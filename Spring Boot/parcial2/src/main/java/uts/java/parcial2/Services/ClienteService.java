package uts.java.parcial2.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import uts.java.parcial2.Models.Cliente;
import uts.java.parcial2.Repositories.ClienteRepo;

@Service
@Transactional
public class ClienteService implements ICliente {

    @Autowired
    private ClienteRepo repo;

    @Override
    public List<Cliente> listar(){
        return repo.findAll();
    }

    @Override
    public Cliente listarId(float CODIGOCLIENTE){
        return repo.findById(CODIGOCLIENTE).get();
    }

    @Override
    public void save(Cliente c){
        repo.save(c);
    }

    @Override
    public void delete(float CODIGOCLIENTE){
        repo.deleteById(CODIGOCLIENTE);
    }
}