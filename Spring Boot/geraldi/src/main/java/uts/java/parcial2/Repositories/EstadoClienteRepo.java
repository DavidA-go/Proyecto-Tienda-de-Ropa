package uts.java.parcial2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uts.java.parcial2.Models.EstadoCliente;

public interface EstadoClienteRepo extends JpaRepository <EstadoCliente, String> {

}