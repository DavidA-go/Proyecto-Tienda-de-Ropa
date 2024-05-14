package uts.java.parcial2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uts.java.parcial2.Models.Cliente;

public interface ClienteRepo extends JpaRepository <Cliente, Float> {
}