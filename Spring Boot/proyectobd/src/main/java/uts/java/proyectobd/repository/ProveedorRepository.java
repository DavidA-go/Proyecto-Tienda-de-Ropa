package uts.java.proyectobd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uts.java.proyectobd.model.Proveedor;

public interface ProveedorRepository extends JpaRepository <Proveedor, Integer> {}