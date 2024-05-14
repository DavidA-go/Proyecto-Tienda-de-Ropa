package uts.java.parcial2.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import uts.java.parcial2.Models.TipoCliente;
import uts.java.parcial2.Repositories.TipoClienteRepo;

@Service
@Transactional
public class TipoClienteService implements ITipoCliente {
    @Autowired
    private TipoClienteRepo repo;

    @Override
    public List<TipoCliente> listar(){
        return repo.findAll();
    }

    @Override
    public TipoCliente listarId(String CODIGO){
        return repo.findById(CODIGO).get();
    }

    @Override
    public void save(TipoCliente tc){
        repo.save(tc);
    }

    @Override
    public void delete(String CODIGO){
        repo.deleteById(CODIGO);
    }
}