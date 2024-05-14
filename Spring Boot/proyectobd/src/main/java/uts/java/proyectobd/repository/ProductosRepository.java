package uts.java.proyectobd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uts.java.proyectobd.model.Productos;

public interface ProductosRepository extends JpaRepository <Productos, Integer>{}