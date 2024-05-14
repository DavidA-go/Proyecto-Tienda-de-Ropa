package uts.java.parcial2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uts.java.parcial2.Models.TipoCliente;

public interface TipoClienteRepo extends JpaRepository <TipoCliente, String>{

}
