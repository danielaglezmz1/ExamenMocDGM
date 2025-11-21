package com.example.ExamenMocDGM.repository;

import com.example.ExamenMocDGM.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByPrecio(float precio);
    List<Producto> findByCategoria(String categoria);
    List<Producto> findByPrecioAndCategoria(float precio, String categoria);
}
